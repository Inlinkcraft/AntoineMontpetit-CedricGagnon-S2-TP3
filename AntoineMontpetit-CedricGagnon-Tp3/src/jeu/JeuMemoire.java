package jeu;

import java.util.ArrayList;
import java.awt.Point;
import formes.Forme;
import formes.VecteurFormes;

public class JeuMemoire implements Memorisable{

	public static final int LIGNE = 6;
	public static final int COLONNE = 6;
	public static final int NBR_ELEMENTS_GRILLE = LIGNE * COLONNE;
	private static final int LONGUEUR_CHAINE = 17;

	private VecteurFormes vecteurFormes;
	private Forme[][] grilleDeJeu;
	private ArrayList<Point> vecteurPoints;
	private int niveau;

	public JeuMemoire() {
		preparerVecteurFormes();
		preparerGrilleDeJeu();
	}

	private void preparerVecteurFormes() {
		vecteurFormes = new VecteurFormes();
		vecteurFormes.melanger();
	}

	private void preparerGrilleDeJeu() {
		grilleDeJeu = new Forme[LIGNE][COLONNE];
		ArrayList<Forme> listFormes = vecteurFormes.getVecteur();
		for(int ligne = 0; ligne < LIGNE; ligne++) {
			for(int colonne = 0; colonne < COLONNE; colonne++) {
				grilleDeJeu[ligne][colonne] = listFormes.get(ligne*colonne + colonne);
			}
		}
	}
	
	public String toString() {
		
	}
	
	private String ajouterEspaces(int pLongueur, String pNom) {
		
	}
	
	public String getNomForme(int pX, int pY) {
		
	}
	
	public ArrayList<Point> jouerOrdi(){
		
	}
	
	private Point choisirForme() {
		
	}
	
	public boolean jouerHumain(int pX, int pY) {
		
	}
	
	public int getNiveau() {
		
	}
	
	public VecteurFormes getVecteur() {
		
	}
	
	public Forme[][] getGrille(){
		return grilleDeJeu;
	}
	
	public void setNiveauPlusUn() {
		
	}

}
