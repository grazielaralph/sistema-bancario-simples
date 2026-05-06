import java.util.ArrayList;

public class Main {
	//"banco de dados" armazenando as contas
	static ArrayList<Conta> contasBancarias = new ArrayList<>();

	public static boolean verificaConta(int numConta) {
		//cria um objeto "temporario" de Conta que recebe o proximo item da lista pra verificar
		for (Conta c : contasBancarias) {
			if(c.getNum_conta() == numConta) {
				return true;
			}
		}
		return false;
	}
	
	public void sacar() {}
	
	public void depositar() {}
	
	public void transferir() {}
	
	public void consultarConta(int numConta) {
		if(verificaConta(numConta)) {
			
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}

}
