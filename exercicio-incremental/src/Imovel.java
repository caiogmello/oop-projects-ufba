import java.util.Objects;

enum Tipo {
    CASA, APTO, INVALID
}
public class Imovel {

    private String numeroIptu;
    private Endereco endereco;
    private Tipo tipo;
    private String utilizacao;

    public Imovel(String numeroIptu, String rua,
                  String numero, String cep,
                  String estado, String cidade,
                  String tipo, String utilizacao) {
        this.numeroIptu = numeroIptu;
        this.endereco = new Endereco(rua, numero, cep, estado, cidade);
        this.tipo = verificaTipo(tipo)
                ? Tipo.valueOf(tipo.toUpperCase())
                : Tipo.INVALID;
        this.utilizacao = utilizacao;
    }

    public Imovel(String numeroIptu, String rua,
                  String numero, String cep,
                  String tipo, String utilizacao) {

        this(numeroIptu, rua, numero,
                cep, "BA", "Salvador",
                tipo, utilizacao);
    }

    public boolean verificaTipo(String tipo) {
        try {
            Tipo.valueOf(tipo.toUpperCase());
            return true;
        } catch (IllegalArgumentException ex) {
            return false;
        }
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

    public void setTipo(String tipo) {
        this.tipo = verificaTipo(tipo)
                ? Tipo.valueOf(tipo.toUpperCase())
                : Tipo.INVALID;
    }

    public String getUtilizacao() {
        return utilizacao;
    }

    public void setUtilizacao(String utilizacao) {
        this.utilizacao = utilizacao;
    }

    @Override
    public String toString() {
        return "Imovel{" +
                "numeroIptu='" + numeroIptu + '\'' +
                ", endereco=" + endereco +
                ", tipo=" + tipo +
                ", utilizacao='" + utilizacao + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Imovel imovel = (Imovel) o;
        return Objects.equals(numeroIptu, imovel.numeroIptu) && Objects.equals(endereco, imovel.endereco) && tipo == imovel.tipo && Objects.equals(utilizacao, imovel.utilizacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroIptu, endereco, tipo, utilizacao);
    }
}


