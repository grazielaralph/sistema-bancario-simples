import java.util.ArrayList;

public class Banco {

	private ArrayList<Conta> contas;

	public Banco(){
		contas = new ArrayList<>();
	}

	public void AdicionarConta(Conta conta) {
		contas.add(conta);
	}

	public Conta ConsultarConta(int num_conta){
		for (Conta c: contas){
			if (c.getnum_conta() == num_conta){ //
				return c;
			}
		}
		return null;
	}
}

