package economiza;

//114110443 - Gabriela Motta Oliveira: LAB 3 - Turma 3

public class Menu {

	public static final int CADASTRA = 1;
	public static final int VENDE = 2;
	public static final int BALANCO = 3;

	public Menu() { // Construtor default de Menu

	}

	/**
	 * Imprime o menu principal
	 */
	public void imprimeMenu() {

		System.out.println("= = = = Bem-vindo(a) ao EconomizaP2 = = = =");
		System.out.println("Digita a opcao desejada:");
		System.out.println("1 - Cadastrar um Produto");
		System.out.println("2 - Vender um Produto");
		System.out.println("3 - Imprimir Balanco");
		System.out.println("4 - Sair");
		System.out.println();
		System.out.print("Opcao: ");
	}

	/**
	 * Inicializa o menu, e realiza as operacoes de acordo com a escolha do
	 * usuario
	 * 
	 * @param supermercado
	 */
	public void inicializaMenu(Supermercado supermercado) {

		imprimeMenu();

		int escolha = MainSupermercado.ler.nextInt();
		MainSupermercado.ler.nextLine();

		while (escolha != 4) {
			switch (escolha) {
			case CADASTRA:
				supermercado.cadastraProds();
				break;
			case VENDE:
				supermercado.venda();
				break;
			case BALANCO:
				supermercado.imprimeBalanco();
				break;
			default:
				System.out.println("Opcao invalida.");
				break;
			}

			imprimeMenu();
			escolha = MainSupermercado.ler.nextInt();
			MainSupermercado.ler.nextLine();
		}
	}
}