import java.util.ArrayList;

public class Banco {

	private ArrayList<Conta> contas;

	public Banco(){
		contas = new ArrayList<>();
	}

	public void adicionarConta(String nome, double saldo) {
			contas.add(new Conta(nome, 0, saldo));
		}

	public Conta consultarConta(int num_conta){
		for (Conta c: contas){
			if (c.getNum_conta() == num_conta){ //
				return c;
			}
		}
		return null;
	}
	
	public boolean tranferir(int origem, int destino, double valor){
		Conta contaOrigem = consultarConta(origem);
	    Conta contaDestino = consultarConta(destino);

	    if(contaOrigem == null || contaDestino == null){
		   return false;
	    }
	    if (contaOrigem.sacar(valor)) {
			contaDestino.depositar(valor);
			return true;
        }
		return false;
    }
	
	public void depositar(int numConta, double valor) {
		Conta c = consultarConta(numConta);
		if(c!=null) {
			c.depositar(valor);			
		}else {
			System.out.println("Conta nao encontrada! Tente novamente");
		}
	}
	
	public boolean sacar(int numConta, double valor) {
		Conta c = consultarConta(numConta);
		if(c!=null) {
			if(c.sacar(valor)) {
				return true;
			}else {
				return false;
			}
		}else {
			System.out.println("Conta nao encontrada! Tente novamente");
			return false;
		}
	}
}