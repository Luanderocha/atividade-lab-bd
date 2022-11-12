import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);

		int opcaoMenuPrincipal = 0;

		imprimirMenuPrincipal();
		
		while (scanner.hasNext()) {
			
			opcaoMenuPrincipal = scanner.nextInt();
			
			switch (opcaoMenuPrincipal) {
			case 1:
				System.out.println("A op��o 1 escolhida");
				//Implmenta��o do aluno
				break;
			case 2:
				System.out.println("A op��o 2 escolhida");
				//Implmenta��o do aluno
				break;
			case 3:
				System.out.println("A op��o 3 escolhida");
				//Implmenta��o do aluno
				break;
			case 4:
				System.out.println("A op��o 4 escolhida");
				//Implmenta��o do aluno
				break;
			case 5:
				System.out.println("A op��o 5 escolhida");
				//Implmenta��o do aluno
				break;
			case 6:
				System.out.println("O programa ser� encerrado");
				break;
			default:
				System.out.println("A op��o escolhida n�o correponde a op��o valida. Digite novamente:");
				break;
			}
			
			imprimirMenuSecundario();
			String opcaoMenuSecundario = retornaValorEscolhidoMenuSecundario();
			
			if(opcaoMenuSecundario.toUpperCase().equals("S")) {
				imprimirMenuPrincipal();
			}else {
				System.out.println("O programa ser� encerrado");
				break;
			}


		}
	}
	
	public static void imprimirMenuPrincipal() {
		System.out.println("1 - Imprimir todos os cliente seguido de seus respectivos pedidos");
		System.out.println("2 - Imprimir o somat�rio dos pedidos, nome e forma de pagamento");
		System.out.println("3 - Imprimir o nome do cliente e quantidade de pedido dos clientes que j� realizaram 3 ou mais pedidos");
		System.out.println("4 - Imprimir todos os cliente com seus pedidos (data e forma de pagamento e pre�o e o nome do produto)");
		System.out.println("5 - Imprimir o nome do cliente, a data do pedido, o valor do pedido e o tamanho do pedido");
		System.out.println("6 - Para finalizar a execu��o do programa");
		System.out.print("Digita o numero da op��o que voce quer escolher: ");
	}
	
	public static void imprimirMenuSecundario() {
		System.out.print("Quer escolher outra op��o? Digite: S - SIM ou N - N�O: ");
	}
	
	public static String retornaValorEscolhidoMenuSecundario() {
		Scanner scanner = new Scanner(System.in);
		return scanner.next();
	}
	

}
