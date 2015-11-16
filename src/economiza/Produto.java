package economiza;

// 114110443 - Gabriela Motta Oliveira: LAB 3 - Turma 3

public class Produto {
	private String nome;
	private String tipo;
	private double preco;
	private int quantidade;

	/**
	 * Construtor de Produto
	 * 
	 * @param nome
	 *            O nome do produto
	 * @param preco
	 *            O preco do produto
	 * @param tipo
	 *            O tipo do produto
	 * @param quantidade
	 *            A quantidade em estoque do produto
	 */
	public Produto(String nome, double preco, String tipo, int quantidade) {
		this.nome = nome;
		this.preco = preco;
		this.tipo = tipo;
		this.quantidade = quantidade;
	}

	/**
	 * Retorna uma String com informacoes do produto
	 */
	public String toString() {
		String mensagem = String.format("%s (%s) R$ %.2f Restante: %d", nome,
				tipo, preco, quantidade);
		return mensagem;
	}

	public String getNome() {
		return nome;
	}

	public String getTipo() {
		return tipo;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	/**
	 * Altera a quantidade em estoque do produto
	 * 
	 * @param quantidade
	 *            A quantidade a ser removida
	 * @return O total arrecadado pela venda
	 */
	public double vendeQuantidade(int quantidade) {
		double arrecadado = 0.0;
		if (quantidade <= this.quantidade) {
			this.quantidade = this.quantidade - quantidade;
			arrecadado = arrecadado + (quantidade * this.preco);
			System.out.println("Total arrecadado: R$ " + arrecadado);
		} else{
			System.out.println("Nao foi possivel vender pois nao ha " + this.nome + " suficiente.");
		}
		return arrecadado;
	}

}
