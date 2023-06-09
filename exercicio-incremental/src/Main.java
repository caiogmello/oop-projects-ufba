import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws UsuarioExistenteException {
        Simulacao simulacao = new Simulacao();
        ArrayList<Proprietario> proprietarios = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("O que deseja fazer?");
            System.out.println("1 - Cadastrar imóvel");
            System.out.println("2 - Cadastrar proprietário");
            System.out.println("3 - Bloquear imóveis de um proprietário");
            System.out.println("4 - Checar valor do aluguel de um imóvel");
            System.out.println("5 - Checar disponibilidade de um imóvel");
            System.out.println("6 - Sair");

            int opcao = scanner.nextInt();

            if(opcao == 1) {
                cadastrarImovel(proprietarios);
            } else if (opcao == 2) {
                Proprietario proprietario = cadastrarProprietario();
                if(estaCadastrado(proprietario.getCpf(), proprietarios)){
                    try {
                        throw new UsuarioExistenteException("ERRO: Proprietário com o CPF (" + proprietario.getCpf() + ") já cadastrado. Tente novamente.\n");
                    } catch (UsuarioExistenteException e) {
                        System.out.println(e.getMessage());
                    }
                } else{
                    System.out.println("Proprietário cadastrado com sucesso.\n");
                    proprietarios.add(proprietario);
                }
            } else if (opcao == 3) {
                try {
                    proprietarios.get(listaProprietarios(proprietarios)).bloquearImoveis();
                    System.out.println("Imóveis bloqueados com sucesso.\n");
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Não há proprietário cadastrados com esse CPF.\n");
                }
            } else if (opcao == 4) {
                try {
                    Imovel imovel =  listaImovel(proprietarios.get(listaProprietarios(proprietarios)));
                    simulacao.calcularPrecoAluguel(imovel);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Não há proprietário cadastrados com esse CPF.\n");
                }
            } else if (opcao == 5) {
                try {
                    Imovel imovel =  listaImovel(proprietarios.get(listaProprietarios(proprietarios)));
                    simulacao.checkDisponibilidade(imovel);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Não há proprietário cadastrados com esse CPF.\n");
                }
            } else if (opcao == 6) {
                System.out.println("Saindo...");
                break;
            } else {
                System.out.println("Opção inválida.\n");
            }
        }
    }

    public static void cadastrarImovel(ArrayList<Proprietario> proprietarios) {
        Imovel imovel;
        Scanner scanner = new Scanner(System.in);
        System.out.println("O imóvel é uma unidade autônoma ou compartilhada? (A/C)");
        String resposta = scanner.nextLine();

        if(resposta.equalsIgnoreCase("C")){
            System.out.println("Digite o número do IPTU: ");
            String numeroIptu = scanner.nextLine();
            System.out.println("Digite o nome da rua: ");
            String rua = scanner.nextLine();
            System.out.println("Digite o número do condomínio: ");
            String numero = scanner.nextLine();
            System.out.println("Digite os itens de lazer do condomínio (separados por vírgula e espaço): ");
            String[] itensLazer = scanner.nextLine().split(", ");
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
            for(String item : itensLazer) {
                condominio.adicionaItemLazer(item);
            }

            imovel = new UnidadeCompartilhada(numeroIptu, rua, numero,
                    cep, estado, cidade, tipo,
                    utilizacao, identificacao,
                    condominio);
        } else {
            System.out.println("Digite o número do IPTU: ");
            String numeroIptu = scanner.nextLine();
            System.out.println("Digite o nome da rua: ");
            String rua = scanner.nextLine();
            System.out.println("Digite o número da casa: ");
            String numero = scanner.nextLine();
            System.out.println("Digite a área útil da casa: ");
            double areaUtil = Double.parseDouble(scanner.nextLine());
            System.out.println("Digite a área construída da casa: ");
            double areaConstruida = Double.parseDouble(scanner.nextLine());
            System.out.println("Digite o CEP: ");
            String cep = scanner.nextLine();
            System.out.println("Digite o estado (Em sigla: BA, RJ, SP): ");
            String estado = scanner.nextLine();
            System.out.println("Digite a cidade: ");
            String cidade = scanner.nextLine();
            System.out.println("Digite o tipo do imóvel (CASA ou APTO): ");
            String tipo = scanner.nextLine();
            System.out.println("Digite a utilização do imóvel: ");
            String utilizacao = scanner.nextLine();

            imovel = new UnidadeAutonoma(numeroIptu, rua, numero,
                    cep, estado, cidade, tipo,
                    utilizacao, areaUtil,
                    areaConstruida);
        }

        System.out.println("Deseja adicionar o imóvel a um proprietário? (S/N)");
        resposta = scanner.nextLine();
        if(resposta.equalsIgnoreCase("S")) {
            try {
                proprietarios.get(listaProprietarios(proprietarios)).addImovel(imovel);
                System.out.println("Imóvel adicionado com sucesso.\n");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Não há proprietário cadastrados com esse CPF.\n");
            }
        } else {
            System.out.println("Ok!");
        }

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
        return new Proprietario(nome, cpf, identidade, rua, numero, cep, estado, cidade);
    }

    public static boolean estaCadastrado(String cpf, ArrayList<Proprietario> proprietarios){
        for (Proprietario proprietario : proprietarios) {
            if(proprietario.getCpf().equals(cpf)){
                return true;
            }
        }
        return false;
    }

    public static int listaProprietarios(ArrayList<Proprietario> proprietarios) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o CPF do proprietário: ");
        String cpf = scanner.nextLine();
        for (int i = 0; i < proprietarios.size(); i++) {
            if (proprietarios.get(i).getCpf().equals(cpf)) {
                System.out.println("Proprietário: " + proprietarios.get(i).getNome() + "\n");
                return i;
            }
        }
        return -1;
    }

    public static Imovel listaImovel(Proprietario proprietario){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o número do IPTU do imóvel: ");
        String iptu = scanner.nextLine();
        for (Imovel imovel : proprietario.getImoveis()) {
            if (imovel.getNumeroIptu().equals(iptu)) {
                return imovel;
            }
        }
        return null;
    }

    public static double calcularAluguel(Imovel imovel){
        Scanner scanner = new Scanner(System.in);
        double aluguel=imovel.getAluguel();


        if(imovel instanceof UnidadeCompartilhada){
            UnidadeCompartilhada unidadeCompartilhada = (UnidadeCompartilhada) imovel;
            aluguel = unidadeCompartilhada.getNumItensLazer() == 0
                    ? aluguel*0.9
                    : aluguel* unidadeCompartilhada.getNumItensLazer();
        }

        double aluguelAlterado = checkSazonalidade(aluguel);

        System.out.println("O valor de referência do aluguel é: " + aluguel + "\n");
        System.out.println("O valor do aluguel com a sazonalidade é: " + aluguelAlterado + "\n");

        return aluguelAlterado;
    }

    public static double checkSazonalidade(double aluguel){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o número referente a sazonalidade do aluguel:");
        System.out.println("1 - Reveillon;");
        System.out.println("2 - Carnaval;");
        System.out.println("3 - Feriado Alta Estação;");
        System.out.println("4 - Feriado Baixa Estação;");
        System.out.println("0 - Comum");
        int opcao = scanner.nextInt();
        switch (opcao) {
            case 1 -> aluguel = aluguel*1.2;
            case 2 -> aluguel = aluguel*1.15;
            case 3 -> aluguel = aluguel*1.1;
            case 4 -> aluguel = aluguel*1.05;
            default -> aluguel = aluguel*1;
        }
        return aluguel;
    }


}

