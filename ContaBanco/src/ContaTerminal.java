import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);

        @SuppressWarnings("deprecation")
        Locale localeBR = new Locale("en", "US");

        System.out.println("\n=== Cadastro de Conta ===");

        System.out.print("Por favor, digite o número da Agência: ");
        String agencia = scanner.nextLine();

        System.out.print("Por favor, digite o número da Conta: ");
        int numeroConta = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Por favor, digite o nome do cliente: ");
        String nomeCliente = scanner.nextLine();

        System.out.print("Por favor, digite o saldo da conta: ");
        String saldoStr = scanner.nextLine();
        Number saldoNumero = NumberFormat.getInstance(localeBR).parse(saldoStr);
        double saldo = saldoNumero.doubleValue();

        System.out.println();
        System.out.println("Olá " + nomeCliente + ", obrigado por criar uma conta em nosso banco.");
        System.out.println("Sua agência é " + agencia + ", conta " + numeroConta + " e seu saldo R$ " + String.format("%.2f", saldo) + " já está disponível para saque.");

        scanner.close();
    }
}
