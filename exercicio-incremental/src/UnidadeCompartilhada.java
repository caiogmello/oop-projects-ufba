import java.util.Scanner;

public class UnidadeCompartilhada extends Imovel {
    private String identificacao;
    private Condominio condominio;

    public UnidadeCompartilhada(String numeroIptu, String rua,
                                String numero, String cep,
                                String estado, String cidade,
                                String tipo, String utilizacao,
                                String identificacao, Condominio condominio) {
        super(numeroIptu, rua, numero, cep, estado, cidade, tipo, utilizacao);
        this.identificacao = identificacao;
        this.condominio = condominio;
    }

    public UnidadeCompartilhada(String numeroIptu, String rua,
                                String numero, String cep, String tipo,
                                String utilizacao, String identificacao,
                                Condominio condominio) {
        super(numeroIptu, rua, numero, cep, tipo, utilizacao);
        this.identificacao = identificacao;
        this.condominio = condominio;
    }

    @Override
    public double getAluguel() {
        double iptu = Double.parseDouble(super.getNumeroIptu());
        return iptu*
    }

    @Override
    public Imovel cadastrarImovel() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o número do IPTU: ");
        String numeroIptu = scanner.nextLine();
        System.out.println("Digite o nome da rua: ");
        String rua = scanner.nextLine();
        System.out.println("Digite o número do condomínio: ");
        String numero = scanner.nextLine();
        System.out.println("Digite a identificação da unidade: ");
        String identificacao = scanner.nextLine();
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

        Condominio condominio = new Condominio(rua, numero, cep, estado, cidade);

        return new UnidadeCompartilhada(numeroIptu, rua, numero,
                cep, estado, cidade, tipo,
                utilizacao, identificacao, condominio);
    }
}
