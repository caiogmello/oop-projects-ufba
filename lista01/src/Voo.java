import java.sql.Time;
import java.util.Date;

public class Voo {

    private String data;
    private String horario;
    private long numeroVoo;
    private int numeroDePassageiros = 0;

    public Voo(String data, String horario, long numeroVoo) {
        this.data = data;
        this.horario = horario;
        this.numeroVoo = numeroVoo;
    }

    public long getNumeroVoo() {
        return numeroVoo;
    }

    public String getData() {
        return data;
    }

    public boolean comprarPassagem() {
        if(numeroDePassageiros < 100) {
            numeroDePassageiros ++;
            return true;
        }
        return false;
    }


}
