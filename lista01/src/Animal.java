// QUESTAO 4
enum Tipo {
    MAMIFERO, ANFIBIO, AVE;
}

public class Animal {

    private Tipo tipo;
    private String nome;
    private int idade;

    public Animal(Tipo tipo, String nome, int idade) {
        this.tipo = tipo;
        this.nome = nome;
        this.idade = idade;
    }

    public double getQuantidadeDeAlimentoConsumido() {
        if(tipo.equals(Tipo.MAMIFERO)) {
            return idade * 2;
        } else if (tipo.equals(Tipo.AVE)) {
            return idade * 0.1;
        } else {
            return idade * 0.02;
        }
    }
}
