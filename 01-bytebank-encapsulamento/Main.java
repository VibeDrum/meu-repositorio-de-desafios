import java.util.Scanner;

// Classe Conta com encapsulamento
class Conta {
    private int saldo;

    public Conta(int saldoInicial) {
        this.saldo = saldoInicial;
    }

    public void depositar(int valor) {
        if (valor > 0) {
            this.saldo += valor;
        }
    }

    public void sacar(int valor) {
        if (valor > 0 && valor <= this.saldo) {
            this.saldo -= valor;
        }
    }

    public int getSaldo() {
        return this.saldo;
    }
}

// Classe Principal corrigida
public class Main {
    public static void main(String[] args) {
        // Correção feita aqui: System.in direto
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) return;
        int saldoInicial = scanner.nextInt();
        
        Conta conta = new Conta(saldoInicial);

        while (scanner.hasNext()) {
            String comando = scanner.next();

            if (comando.equals("fim")) {
                break;
            }

            int valor = scanner.nextInt();

            if (comando.equals("depositar")) {
                conta.depositar(valor);
            } else if (comando.equals("sacar")) {
                conta.sacar(valor);
            }
        }

        System.out.println(conta.getSaldo());
        
        scanner.close();
    }
}
