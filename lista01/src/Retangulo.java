// QUESTÃO 3
public class Retangulo {
    private double comprimento;
    private double largura;

    public Retangulo(double comprimento, double largura) {
        this.comprimento = comprimento > 0 ? comprimento : comprimento*(-1);
        this.largura = largura > 0 ? largura : largura *(-1);
    }

    public double getPerimetro() {
        return 2*comprimento + 2*largura;
    }

    public double getArea() {
        return comprimento*largura;
    }

}
