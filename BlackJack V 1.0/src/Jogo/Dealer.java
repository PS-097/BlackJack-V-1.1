package Jogo;

import java.util.Scanner;

public class Dealer
{

	public void gerarPartida()
	{
		Baralho dealer = new Baralho();
		Cartas[] deck = new Cartas[52];
		deck = dealer.Generate();
		deck = dealer.Embaralhar(deck);
		for (Cartas s : deck)
		{
			System.out.print(s.valor + " ");
		}
		Jogador j1 = new Jogador();
		System.out.println("Digite o nome do primeiro jogador!");
		Scanner input = new Scanner(System.in);
		j1.nome = input.nextLine();
		Jogador j2 = new Jogador();
		System.out.println("Digite o nome do segundo jogador!");
		j2.nome = input.nextLine();
		Partida jogo = new Partida();
		jogo.Player_Turn(deck, j1, j2);
	}

	public Cartas[] getCarta(Cartas[] baralho, Jogador j)
	{
		Cartas[] newbaralho = new Cartas[(baralho.length - 1)];

		if ((baralho[0].valor == 1) && j.somatorio <= 10) // AS VALE 11 SE A MAO NAO ESTOURA!!
		{
			baralho[0].valor += 10;
			j.aspecial = 1;
		}

		for (int i = 1; i <= j.mao.length; i++)
		{
			if (j.mao[i] == null)
			{
				j.mao[i] = baralho[0];
				break;
			}
		}
		for (int i = 1; i <= baralho.length - 1; i++)
		{
			newbaralho[i - 1] = baralho[i];
		}
		return newbaralho;
	}
}
