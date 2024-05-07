package application;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import entities.ContractService;
import entities.Installment;
import entities.PaypalService;
public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);        
        
        System.out.println("Entre com os dados do contrato:");
        System.out.print("Número: ");
        int numeroContrato = sc.nextInt();
        sc.nextLine();

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
        System.out.print("Data (dd/MM/yyyy): ");       
        LocalDate data = LocalDate.parse(sc.nextLine(), formato);

        System.out.print("Valor do contrato: ");
        double valorContrato = sc.nextDouble();

        Contract contract = new Contract(numeroContrato, data, valorContrato);

        System.out.print("Entre com o número de parcelas: ");
        int numeroParcelas = sc.nextInt();

        ContractService contractService = new ContractService(new PaypalService());

        contractService.processContract(contract, numeroParcelas);

        for (Installment string : contract.getInstallments()) {
            System.out.println(string);
        }
        
        sc.close();
    }
}
