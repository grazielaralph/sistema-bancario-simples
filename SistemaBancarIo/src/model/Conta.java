package model;

public class Conta {
	//atributos
	private String nome;
	private int num_conta;
	private int num_ag;
	private double saldo=0;
	
	
	public String getNome() {
		return nome;
	}

	public int getNum_conta() {
		return num_conta;
	}

	public int getNum_ag() {
		return num_ag;
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
	
	
	public Conta(String nome, int num_conta, int num_ag, double saldo) {
		super();
		this.nome = nome;
		this.num_conta = num_conta;
		this.num_ag = num_ag;
		this.saldo = saldo;
	}

	public void depositar(double valor) {
		
	}
	
	public void sacar(double valor) {
	
		
	}
	

}
