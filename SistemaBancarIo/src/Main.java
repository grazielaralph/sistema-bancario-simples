import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);

		Banco banco = new Banco();

		int opcao = 0;

		while (opcao != 6) {

			System.out.println();
			System.out.println("Bem vindo ao JaBank!");
			System.out.println("1- Criar conta.");
			System.out.println("2- Consultar conta.");
			System.out.println("3- Depositar.");
			System.out.println("4- Sacar.");
			System.out.println("5- Transferir.");
			System.out.println("6- Sair.");

			System.out.print("Digite a opção desejada: ");
			opcao = entrada.nextInt();

			System.out.println();

			if (opcao == 1) {
				entrada.nextLine();

				System.out.print("Nome completo do titular da conta: ");
				String nome = entrada.nextLine();

				System.out.print("Saldo inicial: ");
				double saldo = entrada.nextDouble();

				banco.criarConta(nome, saldo);
			}

			else if (opcao == 2) {

				System.out.print("Informe o número da conta: ");
				int num_conta = entrada.nextInt();

				Conta conta = banco.consultarConta(num_conta);

				if (conta != null) {

					System.out.println("Número da conta: " + conta.getNum_conta());
					System.out.println("Nome do titular: " + conta.getNome());

					System.out.printf("Saldo: R$ %.2f%n", conta.getSaldo());

				} else {

					System.out.println("Conta não encontrada! :( ");
				}
			}

			else if (opcao == 3) {

				System.out.print("Informe o número da conta: ");
				int num_conta = entrada.nextInt();

				System.out.print("Qual valor deseja depositar? ");
				double valor = entrada.nextDouble();

				if (banco.depositar(num_conta, valor)) {

					System.out.println("Depósito realizado com sucesso!");

				} else {

					System.out.println("Não foi possível realizar o depósito!");
				}
			}

			else if (opcao == 4) {

				System.out.print("Informe o número da conta: ");
				int num_conta = entrada.nextInt();

				System.out.print("Qual valor deseja sacar? ");
				double valor = entrada.nextDouble();

				if (banco.sacar(num_conta, valor)) {
					System.out.println("Saque realizado com sucesso!");

				} else {

					System.out.println("Não foi possível realizar o saque!");
				}
			}

			else if (opcao == 5) {

				System.out.print("Informe o número da conta de origem: ");
				int origem = entrada.nextInt();

				System.out.print("Informe o número da conta de destino: ");
				int destino = entrada.nextInt();

				System.out.print("Informe o valor a ser transferido: ");
				double valor = entrada.nextDouble();

				if (banco.transferir(origem, destino, valor)) {

					System.out.println("Transferência realizada com sucesso!");

				} else {

					System.out.println("Não foi possível realizar a transferência!");
				}
			}

			else if (opcao == 6) {

				System.out.println("Obrigado por usar o JaBank!");
				System.out.println("Encerrando sistema...");
			}

			else {

				System.out.println("Opção inválida! Tente novamente.");
			}
		}

		entrada.close();
	}
}

