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
		vecteurFormes.remplir(LIGNE*COLONNE);
		vecteurFormes.melanger();
	}

	private void preparerGrilleDeJeu() {
		grilleDeJeu = new Forme[LIGNE][COLONNE];
		ArrayList<Forme> listFormes = vecteurFormes.getVecteur();
		for(int ligne = 0; ligne < LIGNE; ligne++) {
			for(int colonne = 0; colonne < COLONNE; colonne++) {
				grilleDeJeu[ligne][colonne] = listFormes.get(ligne*COLONNE + colonne);
			}
		}
	}
	
	public String toString() {
		String st = "";
		for(int ligne = 0; ligne < LIGNE; ligne++) {
			for(int colonne = 0; colonne < COLONNE; colonne++) {
				st += ajouterEspaces(LONGUEUR_CHAINE,grilleDeJeu[ligne][colonne].toStringCourt()) + "|";
			}
			st += "\n";
		}
		return st;
	}
	
	private String ajouterEspaces(int pLongueur, String pNom) {
		do {
			pNom += " ";
		}while(pNom.length() < pLongueur);
		return pNom;
	}
	
	public String getNomForme(int pX, int pY) {
		return "";
	}
	
	public ArrayList<Point> jouerOrdi(){
		return new ArrayList<Point>();
	}
	
	private Point choisirForme() {
		return new Point();
	}
	
	public boolean jouerHumain(int pX, int pY) {
		return false;
	}
	
	public int getNiveau() {
		return 0;
	}
	
	public VecteurFormes getVecteur() {
		return vecteurFormes;
	}
	
	public Forme[][] getGrille(){
		return grilleDeJeu;
	}
	
	public void setNiveauPlusUn() {
		
	}

	public static void main(String[] args) {
		JeuMemoire jm = new JeuMemoire();
		System.out.println(jm);
		System.out.println(jm.vecteurFormes);
	}
	
}
