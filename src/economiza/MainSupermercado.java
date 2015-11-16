package economiza;

import java.util.Scanner;

//114110443 - Gabriela Motta Oliveira: LAB 3 - Turma 3

public class MainSupermercado { // Vai executar o programa, criando um supermercado, um menu, e inicializando o menu

	static Scanner ler = new Scanner(System.in);

	public static void main(String[] args) {

		Supermercado economizaP2 = new Supermercado();
		Menu menu = new Menu();
		menu.inicializaMenu(economizaP2);
	}
}
