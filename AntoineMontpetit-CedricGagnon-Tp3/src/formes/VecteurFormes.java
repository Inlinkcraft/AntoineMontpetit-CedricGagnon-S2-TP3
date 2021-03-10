package formes;

import java.util.ArrayList;
import exceptions.*;

/**
 * Vecteur permettant d'être rempli, mélangé et trié d'objets de la classe Forme.
 * @author Cédric Gagnon
 * @version 10 Mar 2021
 */
public class VecteurFormes implements ManipulerVecteur
{
	/**
	 * Vecteur contenant les formes 
	 */
	ArrayList<Forme> vecteur;

	/**
	 * Construit un vecteur
	 */
	public VecteurFormes()
	{
		vecteur = new ArrayList<Forme>();
	}

	/**
	 * Valide un nombre comme étant positif ou 0
	 * @param pNbr : nombre à valider
	 * @return true si le nombre est positif ou 0
	 */
	private static boolean validerNbrFormes(int pNbr)
	{
		return (pNbr >= 0);
	}

	/**
	 * Remplit le vecteur d'un nombre de formes
	 * @param pNbr : le nombre de formes à mettre dans le vecteur
	 */
	public void remplir(int pNbr)
	{
		if (validerNbrFormes(pNbr))
		{
			while (vecteur.size() < pNbr)
			{
				try
				{
					if (vecteur.size() % 3 == 0)
					{
						vecteur.add(new Cercle(10));
					}
					else if (vecteur.size() % 3 == 1)
					{
						vecteur.add(new Rectangle(10, 10));
					}
					else
					{
						vecteur.add(new Triangle(10, 10, 10));
					}
					vecteur.get(vecteur.size() - 1).setCouleur(
							Couleur.values()[((vecteur.size() - 1) / 3) % 6]);
				}
				catch (FormeException e)
				{
					try
					{
						vecteur.add(new Cercle(Forme.MIN_VAL));
					}
					catch (Exception f)
					{
						System.out.println("Comment on est rendu là???");
					}
				}
			}

		}
	}

	/**
	 * Retourne le vecteur
	 * @return le vecteur
	 */
	public ArrayList<Forme> getVecteur()
	{
		return (vecteur);
	}

	
	/**
	 * Remplace le toString  de la classe Object
	 * @return la représentation String du vecteur
	 */
	@Override
	public String toString()
	{
		String out = "";
		for (int i = 0; i < vecteur.size(); i++)
		{
			out += ((Forme) vecteur.get(i)).toStringCourt() + "\n";
		}
		return (out);
	}

	/**
	 * Trie le vecteur
	 */
	public void trier()
	{
		for (int i = 0; i < vecteur.size(); i++)
		{
			int temp = i;
			for (int j = i; j < vecteur.size(); j++)
			{
				if (vecteur.get(j).compareTo(vecteur.get(temp)) < 0)
				{
					temp = j;
				}
			}
			permuter(i, temp);
		}
	}

	/**
	 * Mélange le vecteur
	 */
	public void melanger()
	{
		for (int i = 0; i < vecteur.size(); i++)
		{
			permuter(i, (int) (Math.random() * (vecteur.size() - i)) + i);
		}
	}

	/**
	 * Permute deux formes dans le vecteur
	 * @param pPremier : L'index du premier élément à permuter
	 * @param pDeuxieme : L'index du deuxième élément à permuter
	 */
	private void permuter(int pPremier, int pDeuxieme)
	{
		if (pPremier >= 0 && pDeuxieme >= 0 && pPremier <= vecteur.size()
				&& pDeuxieme <= vecteur.size())
		{
			Forme temp = vecteur.get(pPremier);
			vecteur.set(pPremier, vecteur.get(pDeuxieme));
			vecteur.set(pDeuxieme, temp);
		}
	}
}
