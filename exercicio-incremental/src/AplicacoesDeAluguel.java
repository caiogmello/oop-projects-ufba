public interface AplicacoesDeAluguel {
    boolean checkDisponibilidade(Imovel imovel);
    double calcularPrecoAluguel(Imovel imovel);
}
