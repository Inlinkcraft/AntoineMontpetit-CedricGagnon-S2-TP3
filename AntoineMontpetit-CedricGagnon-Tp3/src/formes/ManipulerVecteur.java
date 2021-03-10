package formes;

import java.util.ArrayList;

/**
 * Interface pour manipuler un vecteur
 * @author Cédric Gagnon
 * @version 10 Mar 2021
 */
public interface ManipulerVecteur
{
	ArrayList<Forme> getVecteur();

	void remplir(int pNbr);

	void trier();

	void melanger();
}
