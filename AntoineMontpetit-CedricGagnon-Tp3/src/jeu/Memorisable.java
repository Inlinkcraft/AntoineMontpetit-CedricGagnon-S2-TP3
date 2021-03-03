package jeu;
import java.util.ArrayList;
import java.awt.Point;

public interface Memorisable {

	public static final int NIVEAU_MAX = 6;
	
	ArrayList<Point> jouerOrdi();
	boolean jouerHumain(int pX, int pY);
	String getNomForme(int pX, int pY);
	int getNiveau();
	void setNiveauPlusUn();
}
