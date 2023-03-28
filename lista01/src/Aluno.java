import java.time.LocalDate;

// QUESTAO 5
public class Aluno {

    private String nome;
    private int anoDeIngresso;
    private String curso;
    private int qtdDeAprovacoes;

    public Aluno(String nome, int anoDeIngresso, String curso, int qtdDeAprovacoes) {
        this.nome = nome;
        this.anoDeIngresso = anoDeIngresso;
        this.curso = curso;
        this.qtdDeAprovacoes = qtdDeAprovacoes;
    }

    public int getNumeroDeCreditos() {
        return qtdDeAprovacoes*4;
    }

    public int getTempoDePermanencia() {
        return LocalDate.now().getYear() - anoDeIngresso;
    }
}
