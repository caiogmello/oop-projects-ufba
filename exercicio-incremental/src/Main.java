



public class Main {
    public static void main(String[] args) {
        Imovel imovel = Imovel.cadastrarImovel();
        System.out.println(imovel);
        Proprietario proprietario = Proprietario.cadastrarProprietario();
        System.out.println(proprietario);
    }
}