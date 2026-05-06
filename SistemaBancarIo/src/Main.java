public class Main {
	
	
	//metodos da main
	public void CriarConta(String nome, int numConta, double saldo) {
		if(verificaConta(numConta)) {
			System.out.println("Já existe uma conta com esse ID! Tente novamente");
		}else {
			contasBancarias.add(new Conta(nome, numConta, saldo));
		}
	} 

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
