import java.util.ArrayList;

public class Banco {

	private ArrayList<Conta> contas;

	public Banco(){
		contas = new ArrayList<>();
	}

	public void adicionarConta(Conta conta) {
		contas.add(conta);
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
}