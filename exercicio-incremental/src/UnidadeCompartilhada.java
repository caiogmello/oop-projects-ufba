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

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public Condominio getCondominio() {
        return condominio;
    }

    public void setCondominio(Condominio condominio) {
        this.condominio = condominio;
    }

    public int getNumItensLazer(){
        return condominio.getNumItensLazer();
    }

    @Override
    public double getAluguel() {
        return Double.parseDouble(super.getNumeroIptu());
    }

}
