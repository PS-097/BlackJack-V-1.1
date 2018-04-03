package Jogo;

import java.util.Scanner;
import Jogo.Dealer;

public class Partida
{

	public void Player_Turn(Cartas[] baralho, Jogador j1, Jogador j2)
	{
		Dealer dealer = new Dealer();
		Scanner input = new Scanner(System.in);
		int opcao = -1;
		System.out.println("\nTurno do jogador " + j1.nome);
		do // jogador 1
		{
			if (j1.somatorio < 22)
			{
				System.out.println("\n1-Pegar uma carta\n2-Mostra cartas na mao\n0-Parar");
				opcao = input.nextInt();
				switch (opcao)
				{
					case 1:
						baralho = dealer.getCarta(baralho, j1);
						System.out.println("Voce pegou um " + j1.mostrarUltimaCartaPuxada(j1));
						j1.somatorio = j1.soma(j1);
						System.out.println("Total de pontos : " + j1.somatorio);
						break;
					case 2:
						j1.mostrarMao(j1);
						break;
					case 0:
						System.out.println("Parando\nTotal de pontos do Jogador " + j1.nome + " :" + j1.somatorio);
						break;
					default:
						System.out.println("Opcao invalida");
						break;
				}
			}
			else
			{
				System.out.println("ESTOROU!\nJogador " + j2.nome + " venceu!\n");
				opcao = 0;
			}
			if (j1.somatorio == 21)
			{
				System.out.println("BlackJack!\n");
				opcao = 0;
			}
		}
		while (opcao != 0);

		if (j1.somatorio < 21)
		{
			System.out.println("Turno do Jogador " + j2.nome);
			do // jogador 2
			{
				if (j2.somatorio < 22)
				{
					if (j2.somatorio > j1.somatorio)
					{
						opcao = 0;
					}
					else
					{
						System.out.println("\n1-Pegar uma carta\n2-Mostrar cartas na mao\n0-Parar");
						opcao = input.nextInt();
						switch (opcao)
						{
							case 1:
								baralho = dealer.getCarta(baralho, j2);
								System.out.println("Voce pegou um " + j2.mostrarUltimaCartaPuxada(j2));
								j2.somatorio = j2.soma(j2);
								System.out.println("Total de pontos : " + j2.somatorio);
								break;
							case 2:
								j2.mostrarMao(j2);
								break;
							case 0:
								System.out.println("Parando\nTotal de pontos do Jogador " + j2.nome + " :" + j2.somatorio);
								break;
							default:
								System.out.println("Opcao invalida");
								break;
						}
					}

				}
				if (j2.somatorio == 21)
				{
					System.out.println("BlackJack!\n");
					opcao = 0;
				}
				if (j2.somatorio > j1.somatorio)
				{
					if (j2.somatorio > 21)
					{
						System.out.println("ESTOROU!\nJogador " + j1.nome + " venceu!");
						opcao = 0;
					}
					else
					{
						opcao = 0;
					}
				}
			}
			while (opcao != 0);
		}

		if (j1.somatorio < 22 && j2.somatorio < 22)
		{
			if (j1.somatorio > j2.somatorio)
			{
				System.out.println("Jogador " + j1.nome + " venceu!");
			}
			else
			{
				if (j1.somatorio == j2.somatorio)
				{
					System.out.println("Empate!");
				}
				else
				{
					System.out.println("Jogador " + j2.nome + " venceu!");
				}
			}
		}
	}
}