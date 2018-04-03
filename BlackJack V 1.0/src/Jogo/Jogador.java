package Jogo;

public class Jogador
{
	protected String nome;
	protected Cartas[] mao = new Cartas[11];
	protected int somatorio = 0;
	protected int aspecial = 0;

	public int soma(Jogador j)
	{
		int soma = 0, i;
		for (i = 0; i < 11; i++)
		{
			if (j.mao[i] != null)
				soma = soma + j.mao[i].valor;
		}
		return soma;
	}

	public void mostrarMao(Jogador j)
	{
		int i;
		if (j.somatorio != 0)
		{
			System.out.println("Cartas do jogador " + j.nome + ":");
			for (i = 0; i < 11; i++)
			{
				if (j.mao[i] != null)
					System.out.println(j.mao[i].nomecompleto + " = " + j.mao[i].valor);
			}
			System.out.println("Total de pontos: " + j.somatorio);
		}
		else
		{
			System.out.println(j.nome + " nao pegou nenhuma carta!");
		}
	}

	public String mostrarUltimaCartaPuxada(Jogador j)
	{
		int i;
		String aux = " ";
		for (i = 1; i < j.mao.length; i++)
		{
			if (j.mao[i] == null)
			{
				aux = j.mao[i - 1].nomecompleto;
				break;
			}
		}
		return aux;
	}
}