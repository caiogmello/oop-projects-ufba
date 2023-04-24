import java.util.*;

public class Mesa {
  
  private long idNum;
  private String cpf;
  private String nomeCliente;
  private int numPessoas;
  private ArrayList<Prato> pratos;

  //1. a) i) 
  public Mesa(long idNum, String cpf, String nomeCliente, int numPessoas) {
    this.idNum = idNum;
    this.cpf = cpf;
    this.nomeCliente = nomeCliente;
    this.numPessoas = numPessoas;
    this.pratos = new ArrayList<>();
  }
  
  //1. a) ii) 
  public Mesa(long idNum, String cpf, String nomeCliente,
              int numPessoas, Prato prato) {
    this(idNum, cpf, nomeCliente, numPessoas);
    this.pratos.add(prato);
  }

  //2. a)
  public boolean addPrato(Prato prato) {
    for(Prato p: pratos) {
      if(prato.getIdPrato() == p.getIdPrato()){
        return false;
      }
    }
    this.pratos.add(prato);
    return true;
  }

  //2. b) ii)
  public boolean removePrato(int idPrato) {
    for(Prato p: pratos) {
      if(p.getIdPrato() == idPrato) {
        pratos.remove(p);
        return true;
      }
    }
    return false;
  }

  //3. a)
  public void imprimeDados() {
    System.out.println("nomeCliente = " + this.nomeCliente + 
                      "\ncpf = " + this.cpf +
                      "\nnumPratos = " + this.pratos.size()
                      );
  }
  //3. b) 
  public void imprimeDados(boolean bool) {
    //i)
    if(bool){
      System.out.println("nomeCliente = " + this.nomeCliente + 
                         "\nidNum = " + this.idNum +
                         "\npratos:"
                        );
      for(Prato p : pratos) {
        System.out.println("- nome = " + p.getNome() +
                           "\n  tipo = " + p.getTipo() +
                           "\n  IdPrato = " + p.getIdPrato() +
                           "\n  preco = " + p.getPreco() +
                           "\n"
                          );
      }
      System.out.println("Total = " + this.calculaConta());
      // ii)
    } else {
      System.out.println("nomeCliente = " + this.nomeCliente + 
                         "\nidNum = " + this.idNum + 
                         "\nTotal = " + this.calculaConta() +
                         "\nValor por pessoa = " +       this.calculaConta()/this.numPessoas
                         );
    }
  }

  public float calculaConta() {
    float valor = 0f;
    for(Prato p : pratos) {
      valor += p.getPreco();
    }
    return valor;
  }
  
  public long getIdNum() {
  	return idNum;
  }
  
  public void setIdNum(long idNum) {
  	this.idNum = idNum;
  }
  
  public String getCpf() {
  	return cpf;
  }
  
  public void setCpf(String cpf) {
  	this.cpf = cpf;
  }
  
  public String getNomeCliente() {
  	return nomeCliente;
  }
  
  public void setNomeCliente(String nomeCliente) {
  	this.nomeCliente = nomeCliente;
  }
  
  public int getNumPessoas() {
  	return numPessoas;
  }
  
  public void setNumPessoas(int numPessoas) {
  	this.numPessoas = numPessoas;
  }
  
  public ArrayList<Prato> getPratos() {
  	return pratos;
  }
  
  public void setPratos(ArrayList<Prato> pratos) {
  	this.pratos = pratos;
  }
  
}
