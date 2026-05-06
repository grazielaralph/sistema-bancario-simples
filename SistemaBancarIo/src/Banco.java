import java.util.ArrayList;

public class Banco {

	private ArrayList<Conta> contas;

	public Banco(){
		contas = new ArrayList<>();
	}

	public void criarConta(String nome, int numConta, double saldo) {
	    if(verificaConta(numConta)) {
			System.out.println("Já existe uma conta com esse ID! Tente novamente");
		}else {
			contas.add(new Conta(nome, numConta, saldo));
		}
	} 

	public void adicionarConta(Conta conta) {
		contas.add(conta);
	}

	public boolean verificaConta(int numConta) {
		for (Conta c : contas) {
			if(c.getNum_conta() == numConta) {
				return true;
			}
		}
		return false;
	}

	public Conta consultarConta(int num_conta){
		for (Conta c: contas){
			if (c.getNum_conta() == num_conta){
				return c;
			}
		}
		return null;
	}
	
	public boolean transferir(int origem, int destino, double valor){
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