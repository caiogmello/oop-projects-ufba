public class Main {
    public static void main(String[] args) {
        Automovel automovel = new Automovel(TipoCombustivel.FLEX, "Ford", 2010, "Mustang");

        System.out.println(automovel.getQuantidadeDeCombustivel(30));
    }
}