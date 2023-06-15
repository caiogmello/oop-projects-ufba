import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Proprietario> proprietarios = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("O que deseja fazer?");
            System.out.println("1 - Cadastrar imóvel");
            System.out.println("2 - Cadastrar proprietário");
            System.out.println("3 - Bloquear imóveis de um proprietário");
            System.out.println("4 - Sair");
            Condominio condominio = new Condominio("Rua 1", "123", "12345-678", "SP", "São Paulo");
            Imovel imovel = new UnidadeCompartilhada("1290.09", "Rua 1",
                    "123", "12345-678", "Casa", "Residencial", "asd", condominio);
            
            int opcao = scanner.nextInt();
            if(opcao == 1) {
//                Imovel imovel = UnidadeCompartilhada.cadastrarImovel();
                System.out.println("Deseja adicionar o imóvel a um proprietário? (S/N)");
                String resposta = scanner.next();
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
            } else if (opcao == 2) {
                Proprietario proprietario = Proprietario.cadastrarProprietario();
                proprietarios.add(proprietario);
            } else if (opcao == 3) {
                try {
                    proprietarios.get(listaProprietarios(proprietarios)).bloquearImoveis();
                    System.out.println("Imóveis bloqueados com sucesso.\n");
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Não há proprietário cadastrados com esse CPF.\n");
                }
            } else if (opcao == 4) {
                System.out.println("Saindo...");
                break;
            } else {
                System.out.println("Opção inválida.\n");
            }
        }
    }

    public static int listaProprietarios(ArrayList<Proprietario> proprietarios) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o CPF do proprietário: ");
        String cpf = scanner.nextLine();
        for (int i = 0; i < proprietarios.size(); i++) {
            if (proprietarios.get(i).getCpf().equals(cpf)) {
                return i;
            }
        }
        return -1;
    }
}

