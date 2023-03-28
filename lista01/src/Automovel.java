enum TipoCombustivel {
    GASOLINA, ALCOOL, FLEX;
}

public class Automovel {
    private TipoCombustivel tipoCombustivel;
    private String fabricante;
    private int anoDeFabricacao;
    private String modelo;

    public Automovel(TipoCombustivel tipoCombustivel, String fabricante, int anoDeFabricacao, String modelo) {
        this.tipoCombustivel = tipoCombustivel;
        this.fabricante = fabricante;
        this.anoDeFabricacao = anoDeFabricacao;
        this.modelo = modelo;
    }

    public double getQuantidadeDeCombustivel(double percurso) {
        if (tipoCombustivel.equals(TipoCombustivel.ALCOOL)) {
            return percurso/15;
        } else if (tipoCombustivel.equals(TipoCombustivel.GASOLINA)) {
            return percurso/12;
        } else {
            return percurso/2/15 + percurso/2/12;
        }
    }
}
