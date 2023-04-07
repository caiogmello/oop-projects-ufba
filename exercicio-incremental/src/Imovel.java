enum Tipo {
    CASA, APTO;
}
public class Imovel {

    private String numeroIptu;
    private String rua;
    private String numero;
    private String cep;
    private String estado;
    private String cidade;
    private Tipo tipo;
    private String utilizacao;

    public Imovel(String numeroIptu, String rua,
                  String numero, String cep,
                  String estado, String cidade,
                  Tipo tipo, String utilizacao) {
        this.numeroIptu = numeroIptu;
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
        this.estado = estado;
        this.cidade = cidade;
        this.tipo = tipo;
        this.utilizacao = utilizacao;
    }

    public Imovel(String numeroIptu, String rua, String numero, String cep, Tipo tipo, String utilizacao) {
        this(numeroIptu, rua, numero, cep, "Bahia", "Salvador", tipo, utilizacao);
    }

    public String getNumeroIptu() {
        return numeroIptu;
    }

    public void setNumeroIptu(String numeroIptu) {
        this.numeroIptu = numeroIptu;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
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
