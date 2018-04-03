package Jogo;

import java.util.Random;

public class Baralho
{

	public Cartas[] Generate()
	{
		int k = 0, t = 0;
		Cartas[] baralho = new Cartas[52];
		String vetor[] = new String[]
		{ "Copas", "Paus", "Ouros", "Espadas" };
		String vetora[] = new String[]
		{ "Ás", "Dois", "Três", "Quatro", "Cinco", "Seis", "Sete", "Oito", "Nove", "Dez", "Jack", "Queen", "King" };
		for (int i = 0; i < 4; i++)
		{
			for (int j = 1; j <= 13; j++)
			{
				t = j - 1;
				Cartas c = new Cartas();
				c.nomecompleto = (vetora[t] + " de " + vetor[i]);
				c.numeracao = j;
				if (j < 10)
					c.valor = j;
				else
					c.valor = 10;
				baralho[k] = c;
				k++;
			}
		}
		return baralho;
	}

	public Cartas[] Embaralhar(Cartas[] baralho)
	{
		int j, k, w, l;
		Random random = new Random();
		Cartas aux = new Cartas();
		for (int i = 0; i < 999999; i++)
		{

			// sorteia quatro índices
			j = random.nextInt(baralho.length);
			k = random.nextInt(baralho.length);

			while (k == j) // se for igual pega outro
			{
				k = random.nextInt(baralho.length);
			}

			w = random.nextInt(baralho.length);
			l = random.nextInt(baralho.length);

			while (l == w) // se for igual pega outro
			{
				l = random.nextInt(baralho.length);
			}

			// troca o conteudo dos indices k e j e tambem dos indices w e l do vetor

			// ( update 1.1 do metodo Embaralhar )
			aux = baralho[j];
			baralho[j] = baralho[k];
			baralho[k] = aux;

			aux = baralho[l];
			baralho[l] = baralho[w];
			baralho[w] = aux;
		}
		return baralho;
	}
}