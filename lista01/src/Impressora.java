
public class Impressora {

    private String fabricante;
    private String modelo;
    private int capacidadeDeImpressao;
    private String tecnologia;
    private double velocidade;

    public Impressora(String fabricante, String modelo,
                      int capacidadeDeImpressao, String tecnologia,
                      double velocidade) {
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.capacidadeDeImpressao = capacidadeDeImpressao;
        this.tecnologia = tecnologia;
        this.velocidade = velocidade;
    }

    public double getTempoDeImpressao(int paginas){
        return paginas/velocidade;
    }

    public void imprimirTexto(String texto) {
        System.out.println(texto);
    }

    public String paginasQueAindaPodemSerImpressas(int paginas) {
        return capacidadeDeImpressao>paginas
                ? "Ainda podem ser impressas" + (capacidadeDeImpressao-paginas) + "páginas"
                : "Não pode mais imprimir páginas. Faltaram: " + (paginas-capacidadeDeImpressao);
    }
}
