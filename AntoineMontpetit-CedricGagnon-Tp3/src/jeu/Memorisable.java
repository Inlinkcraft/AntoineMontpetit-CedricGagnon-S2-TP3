package jeu;
import java.util.ArrayList;
import java.awt.Point;

/**
 * Interface pour une classe contenant des mécaniques de jeu de mémorisation.
 * @author Antoine Montpetit
 * @version 10 Mar 2021
 */
public interface Memorisable {

	public static final int NIVEAU_MAX = 6;
	
	ArrayList<Point> jouerOrdi();
	boolean jouerHumain(int pX, int pY);
	String getNomForme(int pX, int pY);
	int getNiveau();
	void setNiveauPlusUn();
}
