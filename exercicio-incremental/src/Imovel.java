enum Tipo {
    CASA, APTO
}
public class Imovel {

    private String numeroIptu;
    private Endereco endereco;
    private Tipo tipo;
    private String utilizacao;

    public Imovel(String numeroIptu, String rua,
                  String numero, String cep,
                  String estado, String cidade,
                  Tipo tipo, String utilizacao) {
        this.numeroIptu = numeroIptu;
        this.endereco = new Endereco(rua, numero, cep, estado, cidade);
        this.tipo = tipo;
        this.utilizacao = utilizacao;
    }

    public Imovel(String numeroIptu, String rua,
                  String numero, String cep,
                  Tipo tipo, String utilizacao) {

        this(numeroIptu, rua, numero,
                cep, "Bahia", "Salvador",
                tipo, utilizacao);
    }

    public String getNumeroIptu() {
        return numeroIptu;
    }

    public void setNumeroIptu(String numeroIptu) {
        this.numeroIptu = numeroIptu;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getUtilizacao() {
        return utilizacao;
    }

    public void setUtilizacao(String utilizacao) {
        this.utilizacao = utilizacao;
    }
}


