package economiza;

//114110443 - Gabriela Motta Oliveira: LAB 3 - Turma 3

public class Supermercado {

	Produto novoProduto;
	static Produto[] produtos = new Produto[5];
	static double totalArrecadado = 0.0;
	static int posicao = 0;

	public Supermercado() { // Construtor default de Supermercado

	}

	/**
	 * Calcula quanto ainda pode ser arrecadado pelo supermercado
	 * 
	 * @return aindaPodeArrecadar O valor que pode ser arrecadado
	 */
	public double podeArrecadar() {

		double aindaPodeArrecadar = 0;

		for (int i = 0; i < produtos.length; i++) {
			if (!(produtos[i] == null)) {
				aindaPodeArrecadar = aindaPodeArrecadar
						+ (produtos[i].getPreco() * produtos[i].getQuantidade());
			}
		}
		return aindaPodeArrecadar;
	}

	/**
	 * Verifica se o supermercado tem produtos cadastrados
	 * 
	 * @return false se nao houver produtos, true se houver
	 */
	public boolean temProdsCadastrados() {

		if (produtos[0] == null) {
			return false;
		}
		return true;
	}

	/**
	 * Verifica se um produto especifico esta cadastrado
	 * 
	 * @param nome
	 *            O nome do produto
	 * @return true se o produto estiver cadastrado, false se nao estiver
	 */
	public boolean estaCadastrado(String nome) {

		for (int i = 0; i < produtos.length; i++) {
			if (!(produtos[i] == null) && produtos[i].getNome().equals(nome)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Atualiza o tamanho do array
	 * 
	 * @param produtosOriginal
	 *            O array original
	 * @return novoProdutos O novo array, com tamanho atualizado
	 */
	public Produto[] atualizaTamanho(Produto[] produtosOriginal) {

		int tamanho = produtosOriginal.length;
		tamanho = tamanho * 2;

		Produto[] novoProdutos = new Produto[tamanho];

		for (int i = 0; i < produtosOriginal.length; i++) {
			novoProdutos[i] = produtosOriginal[i];
		}

		return novoProdutos;
	}

	/**
	 * Cadastra produtos no supermercado
	 */
	public void cadastraProds() {

		String novoCadastro = "Sim";

		System.out.println("= = = = Cadastro de Produtos = = = =");

		while (novoCadastro.toLowerCase().equals("sim")) {

			System.out.print("Digite o nome do produto: ");
			String nomeProduto = MainSupermercado.ler.nextLine();

			System.out.print("Digite o preco unitario do produto: ");
			double precoProduto = MainSupermercado.ler.nextDouble();
			MainSupermercado.ler.nextLine();

			System.out.print("Digite o tipo do produto: ");
			String tipoProduto = MainSupermercado.ler.nextLine();

			System.out.print("Digite a quantidade no estoque: ");
			int quantidadeProduto = MainSupermercado.ler.nextInt();
			MainSupermercado.ler.nextLine();

			Produto novoProduto = new Produto(nomeProduto, precoProduto,
					tipoProduto, quantidadeProduto);

			if (posicao < produtos.length) {
				produtos[posicao] = novoProduto;
				posicao = posicao + 1;
			} else {
				produtos = atualizaTamanho(produtos);
				produtos[posicao] = novoProduto;
				posicao = posicao + 1;
			}

			System.out.println();
			System.out.println(novoProduto.getQuantidade() + " "
					+ novoProduto.getNome() + "(s) cadastrado com sucesso.");
			System.out.println();

			System.out.print("Deseja cadastrar outro produto? ");
			novoCadastro = MainSupermercado.ler.nextLine();

		}
	}

	/**
	 * Vende produtos do supermercado
	 */
	public void venda() {

		if (!temProdsCadastrados()) {
			System.out
					.println("Nao foi possivel realizar venda pois nao ha produtos cadastrados.");

		} else {
			String outroCadastro = "sim";
			System.out.println("= = = = Venda de Produtos = = = =");

			while (outroCadastro.toLowerCase().equals("sim")) {

				System.out.print("Digite o nome do produto: ");
				String nome = MainSupermercado.ler.nextLine();

				if (!estaCadastrado(nome)) {
					System.out.println(nome + " nao cadastrado no sistema.");

				} else {
					for (int i = 0; i < produtos.length; i++) {
						if (!(produtos[i] == null)
								&& produtos[i].getNome().equals(nome)) {
							System.out.println(produtos[i]);
							System.out.println();

							System.out.print("Digite a quantidade que deseja vender: ");
							int quantidadeVendido = MainSupermercado.ler.nextInt();
							MainSupermercado.ler.nextLine();

							totalArrecadado = totalArrecadado + produtos[i].vendeQuantidade(quantidadeVendido);
						}
					}
				}

				System.out.print("Deseja vender outro produto? ");
				outroCadastro = MainSupermercado.ler.nextLine();
			}
		}
	}

	/**
	 * Imprime o balanco do supermercado
	 */
	public void imprimeBalanco() {

		if (!temProdsCadastrados()) {
			System.out
					.println("Nao foi possivel imprimir o balanco pois nao ha produtos cadastrados");

		} else {
			System.out.println("= = = = Impressao de Balanco = = = =");
			System.out.println("Produtos cadastrados:");

			for (int i = 0; i < produtos.length; i++) {
				if (!(produtos[i] == null)) {
					System.out.println("  " + (i + 1) + ") " + produtos[i]);
				}
			}

			System.out.println();
			System.out.println(String.format(
					"Total arrecadado em vendas: R$ %.2f", totalArrecadado));
			System.out.println(String.format(
					"Total que pode ser arrecadado: R$ %.2f", podeArrecadar()));
			System.out.println();
		}
	}
}
