package cartaoDeCredito;


import java.util.Scanner;


public class Principal {

    public static class CartaoDeCredito {
        private String numero;
        private String nomeTitular;
        private String cpfTitular;
        private float limite;
        private float saldo;

        public CartaoDeCredito(String numero, String nomeTitular, String cpfTitular, float limite) {
            this.numero = numero;
            this.nomeTitular = nomeTitular;
            this.cpfTitular = cpfTitular;
            this.limite = limite;
            this.saldo = 0;
        }

        public float consultarSaldo() {
            return saldo;
        }

        public float consultarLimite() {
            return limite - saldo;
        }

        public void realizarTransacao(float valor) {
            if (valor > consultarLimite()) {
                System.out.println("Transação recusada. Limite insuficiente.");
            } else {
                saldo += valor;
                System.out.println("Transação de R$" + valor + " realizada com sucesso.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o número do cartão: ");
        String numero = scanner.nextLine();

        System.out.print("Digite o nome do titular: ");
        String nomeTitular = scanner.nextLine();

        System.out.print("Digite o CPF do titular: ");
        String cpfTitular = scanner.nextLine();

        System.out.print("Digite o limite do cartão: ");
        float limite = scanner.nextFloat();

        CartaoDeCredito cartao = new CartaoDeCredito(numero, nomeTitular, cpfTitular, limite);

        int opcao;
        do {
            System.out.println("\n--- Menu Cartão de Crédito ---");
            System.out.println("1. Realizar Transação");
            System.out.println("2. Consultar Limite");
            System.out.println("3. Consultar Saldo");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor da transação: ");
                    float valor = scanner.nextFloat();
                    cartao.realizarTransacao(valor);
                    break;
                case 2:
                    System.out.println("Limite disponível: R$" + cartao.consultarLimite());
                    break;
                case 3:
                    System.out.println("Saldo atual: R$" + cartao.consultarSaldo());
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 4);

        scanner.close();
    }
}