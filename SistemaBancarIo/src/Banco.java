import java.util.ArrayList;

class Banco {

	private ArrayList<Conta> contas;

	// construtor
	public Banco() {
		contas = new ArrayList<>();
	}

	// criar conta
	public void criarConta(String nome, double saldo) {

		Conta novaConta = new Conta(nome, saldo);

		contas.add(novaConta);

		System.out.println();
		System.out.println("Conta criada com sucesso!");
		System.out.println("Número da conta: " + novaConta.getNum_conta());
	}

	public Conta consultarConta(int num_conta) {

		for (Conta c : contas) {

			if (c.getNum_conta() == num_conta) {
				return c;
			}
		}

		return null;
	}

	public boolean transferir(int origem, int destino, double valor) {

		Conta contaOrigem = consultarConta(origem);
		Conta contaDestino = consultarConta(destino);

		if (contaOrigem == null || contaDestino == null) {
			return false;
		}

		if (contaOrigem.sacar(valor)) {

			contaDestino.depositar(valor);
			return true;
		}

		return false;
	}
}
