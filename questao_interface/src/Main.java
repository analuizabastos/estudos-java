import model.entities.Contract;
import model.services.ContractService;
import model.services.PayPalService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");


        System.out.println("Entre os dados do contrato: ");
        System.out.print("Numero: ");
        Integer number = sc.nextInt();
        System.out.print("Data (dd/MM/yyyy): ");
        String dataString = sc.next();
        LocalDate date = LocalDate.parse(dataString, fmt);
        System.out.print("Valor do Contrato: ");
        BigDecimal valor = sc.nextBigDecimal();

        Contract cr = new Contract(number, date, valor);

        System.out.print("Entre com o numero de parcelas: ");
        Integer months = sc.nextInt();

        ContractService contractService = new ContractService(new PayPalService());

        contractService.processContract(cr, months);
        System.out.println("Parcelas: ");
        cr.installmentsList();

        sc.close();
    }
}