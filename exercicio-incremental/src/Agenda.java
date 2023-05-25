import java.util.ArrayList;
import java.util.Calendar;

public class Agenda {
    private ArrayList<Calendar> alugados = new ArrayList<>();
    private ArrayList<Calendar> bloqueados = new ArrayList<>();


    public boolean isAlugado(Calendar data) {
        for(Calendar c : alugados) {
            if(c.equals(data)) {
                return true;
            }
        }
        return false;
    }

    public boolean isBloqueado(Calendar data) {
        for(Calendar c : bloqueados) {
            if(c.equals(data)) {
                return true;
            }
        }
        return false;
    }

    public boolean isDisponivel(Calendar data) {
        return !isAlugado(data) && !isBloqueado(data);
    }

    public boolean alugar(Calendar data) {
        if(!isAlugado(data) && !isBloqueado(data)) {
            alugados.add(data);
            return true;
        }
        return false;
    }

    public boolean desalugar(Calendar data) {
        if(isAlugado(data)) {
            alugados.remove(data);
            return true;
        }
        return false;
    }

    public boolean bloquear(Calendar data) {
        if(!isAlugado(data)) {
            alugados.remove(data);
        }
        if(!isBloqueado(data)) {
            bloqueados.add(data);
            return true;
        }
        return false;
    }

    public boolean desbloquear(Calendar data) {
        if(isBloqueado(data)) {
            bloqueados.remove(data);
            return true;
        }
        return false;
    }
}
