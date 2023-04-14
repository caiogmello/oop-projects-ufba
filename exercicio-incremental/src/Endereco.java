enum Estados {
    AC, AL, AP, AM, BA, CE, DF, ES, GO, MA,
    MT, MS, MG, PA, PB, PR, PE, PI, RJ, RN,
    RS, RO, RR, SC, SP, SE, TO, INVALID
}
public class Endereco {

    private String rua;
    private String numero;
    private String cep;
    private Estados estado;
    private String cidade;

    public Endereco(String rua
            , String numero
            , String cep
            , String estado
            , String cidade) {

        this.estado = verificaEstado(estado)
                ? Estados.valueOf(estado.toUpperCase())
                : Estados.INVALID;
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
        this.cidade = cidade;
    }

    public boolean verificaEstado(String estado) {
        try {
            Estados.valueOf(estado.toUpperCase());
            return true;
        } catch (IllegalArgumentException ex) {
            return false;
        }
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
        return estado.name();
    }

    public void setEstado(String estado) {
        this.estado = verificaEstado(estado)
                ? Estados.valueOf(estado.toUpperCase())
                : Estados.INVALID;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "rua='" + rua + '\'' +
                ", numero='" + numero + '\'' +
                ", cep='" + cep + '\'' +
                ", estado='" + estado + '\'' +
                ", cidade='" + cidade + '\'' +
                '}';
    }
}
