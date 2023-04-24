public class Prato {
  private int idPrato;
  private String nome;
  private float preco;
  private String tipo;
  
  //1. b) i)
  public Prato(int idPrato, String nome, float preco, String tipo) {
    this.idPrato = idPrato;
    this.nome = nome;
    this.preco = preco;
    // ii)
    this.tipo = verificaTipo(tipo) 
      ? tipo
      : "principal";
  }

  public boolean verificaTipo(String tipo) {
    if(tipo.equals("entrada") || tipo.equals("sobremesa")) 
      return true;
    else 
      return false;
  }
  
  public int getIdPrato() {
  	return idPrato;
  }
  public void setIdPrato(int idPrato) {
  	this.idPrato = idPrato;
  }
  public String getNome() {
  	return nome;
  }
  public void setNome(String nome) {
  	this.nome = nome;
  }
  public float getPreco() {
  	return preco;
  }
  public void setPreco(float preco) {
  	this.preco = preco;
  }
  public String getTipo() {
  	return tipo;
  }
  public void setTipo(String tipo) {
  	this.tipo = tipo;
  }
  
}
