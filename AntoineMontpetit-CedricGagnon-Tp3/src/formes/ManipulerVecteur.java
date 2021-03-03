package formes;

import java.util.ArrayList;

public interface ManipulerVecteur
{

	ArrayList<Forme> getVecteur();

	void remplir(int pNbr);

	void trier();

	void melanger();
}
