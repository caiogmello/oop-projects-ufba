import java.util.Calendar;
import java.util.Objects;
import java.util.Scanner;

enum Tipo {
    CASA, APTO, INVALID
}
public abstract class Imovel {

    private String numeroIptu;
    private Endereco endereco;
    private Tipo tipo;
    private String utilizacao;
    private Agenda agenda;

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
        this.agenda = new Agenda();
    }

    public Imovel(String numeroIptu, String rua,
                  String numero, String cep,
                  String tipo, String utilizacao) {

        this(numeroIptu, rua, numero,
                cep, "BA", "Salvador",
                tipo, utilizacao);
    }

    public abstract double getAluguel();

    public void bloquearAgenda() {
        agenda.bloquearAgenda();
    }
    public boolean alugarImovel(Calendar data) {
        return agenda.alugar(data);
    }

    public boolean bloquearImovel(Calendar data) {
        return agenda.bloquear(data);
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
}


