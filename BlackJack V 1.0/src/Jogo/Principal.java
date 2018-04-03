package Jogo;

import java.util.Scanner;

public class Principal
{

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int opcao = 0;
		do
		{
			System.out.println("Digite uma opcao:\n1-Novo Jogo\n0-Sair");
			opcao = input.nextInt();
			switch (opcao)
			{
				case 1:
					Dealer dealer = new Dealer();
					dealer.gerarPartida();
					break;
				case 0:
					System.out.println("Obrigado por jogar BlackJack, o 21 de RYCKO!");
					break;
				default:
					System.out.println("Opcao invalida");
					break;
			}
		}
		while (opcao != 0);
		input.close();
	}
}