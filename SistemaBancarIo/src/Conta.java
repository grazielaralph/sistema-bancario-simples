class Conta {

	private String nome;
	private double saldo;
	private int num_conta;

	private static int cont = 0;

	// construtor
	public Conta(String nome, double saldo) {

		this.nome = nome;
		this.saldo = saldo;

		cont++;
		this.num_conta = cont;
	}

	public String getNome() {
		return nome;
	}

	public int getNum_conta() {
		return num_conta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void depositar(double valor) {
		saldo += valor;
	}

	public boolean sacar(double valor) {

		if (saldo < valor) {
			return false;
		}

		saldo -= valor;
		return true;
	}
}