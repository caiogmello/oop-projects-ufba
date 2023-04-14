import java.util.ArrayList;

public class Proprietario {

    private String nome;
    private String cpf;
    private String identidade;
    private Endereco endereco;
    private ArrayList<Imovel> imoveis = new ArrayList<>();

    public Proprietario(String nome, String cpf,
                        String identidade, String rua,
                        String numero, String cep,
                        String estado, String cidade) {
        this.nome = nome;
        this.cpf = cpf;
        this.identidade = identidade;
        this.endereco = new Endereco(rua, numero, cep, estado, cidade);
    }

    public void addImovel(Imovel imovel) {
        if(!possuiImovel(imovel)){
            imoveis.add(imovel);
        }
    }

    private boolean possuiImovel(Imovel imovel) {
        for(Imovel i : imoveis) {
            if(imovel.equals(i)){
                return true;
            }
        }
        return false;
    }

    public void listaImoveis(String tipo) {
        for(Imovel i : imoveis) {
            if(i.verificaTipo(tipo)){
                if(i.getTipo().equals(Tipo.valueOf(tipo.toUpperCase()))) {
                    System.out.println(i);
                }
            }
        }
    }
    public void atualizaEndereco(String rua, String numero,
                                 String cep, String estado,
                                 String cidade){
        this.endereco.setRua(rua);
        this.endereco.setNumero(numero);
        this.endereco.setCep(cep);
        this.endereco.setEstado(estado);
        this.endereco.setCidade(cidade);
    }

    public void atualizaEndereco(String rua, String numero, String cep) {
        this.endereco.setRua(rua);
        this.endereco.setNumero(numero);
        this.endereco.setCep(cep);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getIdentidade() {
        return identidade;
    }

    public void setIdentidade(String identidade) {
        this.identidade = identidade;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
