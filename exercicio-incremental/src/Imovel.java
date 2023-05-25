import java.util.Calendar;
import java.util.Objects;
import java.util.Scanner;

enum Tipo {
    CASA, APTO, INVALID
}
public class Imovel {

    private String numeroIptu;
    private Endereco endereco;
    private Tipo tipo;
    private String utilizacao;
    private Agenda agenda;

    public Imovel(String numeroIptu, String rua,
                  String numero, String cep,
                  String estado, String cidade,
                  String tipo, String utilizacao) {
        this.numeroIptu = numeroIptu;
        this.endereco = new Endereco(rua, numero, cep, estado, cidade);
        this.tipo = verificaTipo(tipo)
                ? Tipo.valueOf(tipo.toUpperCase())
                : Tipo.INVALID;
        this.utilizacao = utilizacao;
        this.agenda = new Agenda();
    }

    public Imovel(String numeroIptu, String rua,
                  String numero, String cep,
                  String tipo, String utilizacao) {

        this(numeroIptu, rua, numero,
                cep, "BA", "Salvador",
                tipo, utilizacao);
    }

    public boolean alugarImovel(Calendar data) {
        return agenda.alugar(data);
    }

    public boolean bloquearImovel(Calendar data) {
        return agenda.bloquear(data);
    }

    public boolean verificaTipo(String tipo) {
        try {
            Tipo.valueOf(tipo.toUpperCase());
            return true;
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }

    public String getNumeroIptu() {
        return numeroIptu;
    }

    public void setNumeroIptu(String numeroIptu) {
        this.numeroIptu = numeroIptu;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = verificaTipo(tipo)
                ? Tipo.valueOf(tipo.toUpperCase())
                : Tipo.INVALID;
    }

    public String getUtilizacao() {
        return utilizacao;
    }

    public void setUtilizacao(String utilizacao) {
        this.utilizacao = utilizacao;
    }

    public static Imovel cadastrarImovel() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o número do IPTU: ");
        String numeroIptu = scanner.nextLine();
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
        System.out.println("Digite o tipo do imóvel (CASA ou APTO): ");
        String tipo = scanner.nextLine();
        System.out.println("Digite a utilização do imóvel: ");
        String utilizacao = scanner.nextLine();
        System.out.println("Imóvel cadastrado com sucesso!\n");
        return new Imovel(numeroIptu, rua, numero, cep, estado, cidade, tipo, utilizacao);
    }
    @Override
    public String toString() {
        return "Imovel{" +
                "numeroIptu='" + numeroIptu + '\'' +
                ", endereco=" + endereco +
                ", tipo=" + tipo +
                ", utilizacao='" + utilizacao + '\'' +
                '}';
    }
}


