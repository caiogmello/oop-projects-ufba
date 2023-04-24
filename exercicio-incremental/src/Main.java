



public class Main {
    public static void main(String[] args) {
        Proprietario caio = new Proprietario(
                "Caio", "0012810221",
                "21029109210", "Rua 1",
                "130", "32189318",
                "BA", "Salvador"
        );

        Proprietario joao = new Proprietario(
                "Joao", "0012810221",
                "21029109210", "Rua 1",
                "130", "32189318",
                "BA", "Salvador"
        );

        Proprietario maria = new Proprietario(
                "Maria", "0012810221",
                "21029109210", "Rua 1",
                "130", "32189318",
                "BA", "Salvador"
        );

        //metodos para imovel: diga se o imovel é apto ou casa e se é pra moradia ou pra alugar



        Imovel imovel1 = new Imovel("28191", "Rua 7", "130", "4527817","apto", "praia");
        Imovel imovel2 = new Imovel("54332", "Av 12", "130", "12312312", "casa", "moradia");

        caio.addImovel(imovel1);
        caio.addImovel(imovel2);

        Imovel imovel3 = new Imovel("28191", "Rua 7", "130", "4527817","apto", "praia");

        caio.listaImoveis("casa");
    }
}