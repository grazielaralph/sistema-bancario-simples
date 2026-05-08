package model;

public class Contax {

    private String nome;
	private double saldo;
	private int num_conta;

	private static int cont = 0;

	
	public Contax(String nome, double saldo) {

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

	public setSaldo(double saldo){
		this.saldo=saldo;
	}

	public void depositar(double valor) {
		saldo += valor;
	}

	public void mostrarDados(){
	}

	public boolean sacar(double valor) {
		if (saldo < valor) {
			return false;
		}

		saldo -= valor;
		return true;
	}
}

