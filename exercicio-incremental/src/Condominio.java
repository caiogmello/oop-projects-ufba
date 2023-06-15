import java.lang.reflect.Array;
import java.util.ArrayList;

public class Condominio {
    private Endereco endereco;
    private ArrayList<String>itensLazer;

    public Condominio(String rua, String numero,
                      String cep, String estado,
                      String cidade) {
        this.endereco = new Endereco(rua, numero, cep, estado, cidade);
        this.itensLazer = new ArrayList<>();
    }

    public boolean adicionaItemLazer(String item) {
        if (!this.itensLazer.contains(item)) {
            this.itensLazer.add(item);
            return true;
        }
        return false;
    }

    public int getNumItensLazer() {
        return this.itensLazer.size();
    }
}
