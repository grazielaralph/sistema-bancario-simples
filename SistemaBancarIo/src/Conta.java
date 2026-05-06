
public class Conta {
	//atributos
	private String nome;
	private int num_conta;
	private double saldo=0;
	
	
	public String getNome() {
		return nome;
	}

	public int getNum_conta() {
		return num_conta;
	}


	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Conta() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Conta(String nome, int num_conta, double saldo) {
		super();
		this.nome = nome;
		this.num_conta = num_conta;
		this.saldo = saldo;
	}

	public void depositar(double valor) {
		saldo = saldo+valor;
		
	}
	
	public boolean sacar(double valor) {
		if(saldo<valor) {
			return false;
		}else {
			saldo = saldo - valor;
			return true;
		}
	
	}
	

}