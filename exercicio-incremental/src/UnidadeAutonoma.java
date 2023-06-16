public class UnidadeAutonoma extends Imovel {
    private double areaUtil;
    private double areaConstruida;

    public UnidadeAutonoma(String numeroIptu, String rua,
                           String numero, String cep, String estado,
                           String cidade, String tipo,
                           String utilizacao, double areaUtil,
                           double areaConstruida) {
        super(numeroIptu, rua, numero, cep, estado, cidade, tipo, utilizacao);
        this.areaUtil = areaUtil;
        this.areaConstruida = areaConstruida;
    }

    public UnidadeAutonoma(String numeroIptu, String rua,
                           String numero, String cep, String tipo,
                           String utilizacao, double areaUtil,
                           double areaConstruida) {
        super(numeroIptu, rua, numero, cep, tipo, utilizacao);
        this.areaUtil = areaUtil;
        this.areaConstruida = areaConstruida;
    }

    public double getAreaUtil() {
        return areaUtil;
    }

    public void setAreaUtil(double areaUtil) {
        this.areaUtil = areaUtil;
    }

    public double getAreaConstruida() {
        return areaConstruida;
    }

    public void setAreaConstruida(double areaConstruida) {
        this.areaConstruida = areaConstruida;
    }

    @Override
    public double getAluguel() {
        return this.areaConstruida*15;
    }
}
