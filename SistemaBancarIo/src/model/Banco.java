package model;

import java.util.ArrayList;
import model.Contax;

public class Banco {

	private ArrayList<Contax> contas;


	public Banco() {
		contas = new ArrayList<>();
	}

	public Contax criarConta(String nome, double saldo) {
		Contax novaConta = new Contax(nome, saldo);
		contas.add(novaConta);
		 return novaConta;
	}

	public Contax consultarConta(int num_conta) {

		for (Contax c : contas) {

			if (c.getNum_conta() == num_conta) {
				return c;
			}
		}

		return null;
	}
	
	public boolean depositar(int numConta, double valor) {
		Contax c = consultarConta(numConta);
		if(c == null) return false ;
			c.depositar(valor);
			return true;
		}
	
	public boolean sacar(int numConta, double valor) {
		Contax c = consultarConta(numConta);
		
		if(c == null) return false;
		
		return c.sacar(valor);
	}

	public boolean transferir(int origem, int destino, double valor) {

		Contax contaOrigem = consultarConta(origem);
		Contax contaDestino = consultarConta(destino);

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