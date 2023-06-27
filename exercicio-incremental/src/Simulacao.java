import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Simulacao implements AplicacoesDeAluguel{
    public static ArrayList<String> checkDia(){
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> dias = new ArrayList<>();
        System.out.println("Data de início do aluguel: ");
        System.out.println("Dia: ");
        dias.add(scanner.nextLine());
        System.out.println("Mês: ");
        dias.add(scanner.nextLine());
        System.out.println("Ano: ");
        dias.add(scanner.nextLine());
        System.out.println("Data de fim do aluguel: ");
        System.out.println("Dia: ");
        dias.add(scanner.nextLine());
        System.out.println("Mês: ");
        dias.add(scanner.nextLine());
        System.out.println("Ano: ");
        dias.add(scanner.nextLine());
        return dias;
    }

    @Override
    public boolean checkDisponibilidade(Imovel imovel){
        ArrayList<String> dias = checkDia();
        Calendar dataInicio = Calendar.getInstance();
        dataInicio.set(Integer.parseInt(dias.get(2)), Integer.parseInt(dias.get(1)), Integer.parseInt(dias.get(0)));
        Calendar dataFim = Calendar.getInstance();
        dataFim.set(Integer.parseInt(dias.get(5)), Integer.parseInt(dias.get(4)), Integer.parseInt(dias.get(3)));
        if (dataInicio.after(dataFim)) {
            System.out.println("ERRO: Data de início maior que a data de fim.\n");
            return false;
        }
        for (Calendar c: imovel.getAgenda().getAlugados()) {
            if (dataInicio.after(c) && dataFim.before(c)) {
                System.out.println("Imóvel indisponível para aluguel nesse período.\n");
                return false;
            }
        }

        System.out.println("Imóvel disponível para aluguel nesse período.\n");
        return true;
    }

    @Override
    public double calcularPrecoAluguel(Imovel imovel) {
        ArrayList<String> dias = checkDia();
        Calendar dataInicio = Calendar.getInstance();
        dataInicio.set(Integer.parseInt(dias.get(2)), Integer.parseInt(dias.get(1)), Integer.parseInt(dias.get(0)));
        Calendar dataFim = Calendar.getInstance();
        dataFim.set(Integer.parseInt(dias.get(5)), Integer.parseInt(dias.get(4)), Integer.parseInt(dias.get(3)));
        if (dataInicio.after(dataFim)) {
            System.out.println("ERRO: Data de início maior que a data de fim.\n");
            return 0;
        }

        double valorAluguel = Main.calcularAluguel(imovel);

        // Valor do aluguel * quantidade de dias
        return valorAluguel * (dataFim.get(Calendar.DAY_OF_YEAR) - dataInicio.get(Calendar.DAY_OF_YEAR));
    }
}
