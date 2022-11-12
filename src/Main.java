import java.sql.SQLException;
import java.util.Locale;
import java.util.Scanner;

import dao.ConsultaDao;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		scanner.useLocale(Locale.ENGLISH);

		int opcaoMenuPrincipal = 0;

		ConsultaDao consulta = null;

		try {
			consulta = new ConsultaDao();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		imprimirMenuPrincipal();

		while (scanner.hasNext()) {

			opcaoMenuPrincipal = scanner.nextInt();

			switch (opcaoMenuPrincipal) {
				case 1:
					System.out.println("A opção 1 escolhida");
					consulta.consultaOpcao1();
					break;
				case 2:
					System.out.println("A opção 2 escolhida");
					consulta.consultaopcao2();
					break;
				case 3:
					System.out.println("A opção 3 escolhida");
					consulta.consultaopcao3();
					break;
				case 4:
					System.out.println("A opção 4 escolhida");
					consulta.consultaopcao4();
					break;
				case 5:
					System.out.println("A opção 5 escolhida");
					consulta.consultaopcao5();
					break;
				case 6:
					System.out.println("O programa será encerrado");
					break;
				default:
					System.out.println("A opção escolhida não correponde a opção valida. Digite novamente:");
					break;
			}

			imprimirMenuSecundario();
			String opcaoMenuSecundario = retornaValorEscolhidoMenuSecundario();

			if (opcaoMenuSecundario.toUpperCase().equals("S")) {
				imprimirMenuPrincipal();
			} else {
				System.out.println("O programa será encerrado");
				break;
			}

		}
	}

	public static void imprimirMenuPrincipal() {
		System.out.println("1 - Imprimir todos os cliente seguido de seus respectivos pedidos");
		System.out.println("2 - Imprimir o somatório dos pedidos, nome e forma de pagamento");
		System.out.println(
				"3 - Imprimir o nome do cliente e quantidade de pedido dos clientes que já realizaram 3 ou mais pedidos");
		System.out.println(
				"4 - Imprimir todos os cliente com seus pedidos (data e forma de pagamento e preço e o nome do produto)");
		System.out.println("5 - Imprimir o nome do cliente, a data do pedido, o valor do pedido e o tamanho do pedido");
		System.out.println("6 - Para finalizar a execução do programa");
		System.out.print("Digita o numero da opção que voce quer escolher: ");
	}

	public static void imprimirMenuSecundario() {
		System.out.print("Quer escolher outra opção? Digite: S - SIM ou N - NÃO: ");
	}

	public static String retornaValorEscolhidoMenuSecundario() {
		Scanner scanner = new Scanner(System.in);
		return scanner.next();
	}

}
