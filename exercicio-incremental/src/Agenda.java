import java.util.ArrayList;
import java.util.Calendar;

public class Agenda {
    private ArrayList<Calendar> alugados = new ArrayList<>();
    private ArrayList<Calendar> bloqueados = new ArrayList<>();
    private boolean agendaBloqueada = false;

    public void bloquearAgenda() {
        agendaBloqueada = true;
    }

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
        return !isAlugado(data) && !isBloqueado(data) && !agendaBloqueada;
    }

    public boolean alugar(Calendar data) {
        if(!isAlugado(data) && !agendaBloqueada) {
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

    public ArrayList<Calendar> getAlugados() {
        return alugados;
    }

    public void setAlugados(ArrayList<Calendar> alugados) {
        this.alugados = alugados;
    }

    public ArrayList<Calendar> getBloqueados() {
        return bloqueados;
    }

    public void setBloqueados(ArrayList<Calendar> bloqueados) {
        this.bloqueados = bloqueados;
    }

    public boolean isAgendaBloqueada() {
        return agendaBloqueada;
    }

    public void setAgendaBloqueada(boolean agendaBloqueada) {
        this.agendaBloqueada = agendaBloqueada;
    }
}
