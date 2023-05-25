import java.util.ArrayList;
import java.util.Scanner;

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

    public static Proprietario cadastrarProprietario() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do proprietário: ");
        String nome = scanner.nextLine();
        System.out.println("Digite o CPF do proprietário: ");
        String cpf = scanner.nextLine();
        System.out.println("Digite a identidade do proprietário: ");
        String identidade = scanner.nextLine();
        System.out.println("Digite o nome da rua: ");
        String rua = scanner.nextLine();
        System.out.println("Digite o número da casa: ");
        String numero = scanner.nextLine();
        System.out.println("Digite o CEP: ");
        String cep = scanner.nextLine();
        System.out.println("Digite o estado: ");
        String estado = scanner.nextLine();
        System.out.println("Digite a cidade: ");
        String cidade = scanner.nextLine();
        System.out.println("Proprietário cadastrado com sucesso!\n");
        return new Proprietario(nome, cpf, identidade, rua, numero, cep, estado, cidade);
    }

    @Override
    public String toString() {
        return "Proprietario{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", identidade='" + identidade + '\'' +
                ", endereco=" + endereco +
                ", imoveis=" + imoveis +
                '}';
    }
}
