package jeu;

import java.util.ArrayList;
import java.awt.Point;
import formes.Forme;
import formes.VecteurFormes;

/**
 * Classe permettant l'utilisation et le fonctionnement d'un jeu de mémoire.
 * @author Cédric Gagnon
 * @author Antoine Montpetit
 * @version 10 Mar 2021
 */
public class JeuMemoire implements Memorisable{

	/**
	 * Dimensions du tableau de jeu
	 */
	public static final int LIGNE = 6;
	public static final int COLONNE = 6;
	/**
	 * Nombre de cases du tableau
	 */
	public static final int NBR_ELEMENTS_GRILLE = LIGNE * COLONNE;
	/**
	 * Longueur de string commune dans toString
	 */
	private static final int LONGUEUR_CHAINE = 17;

	/**
	 * Le vecteur de formes
	 */
	private VecteurFormes vecteurFormes;
	/**
	 * La grille de jeu contenant les formes
	 */
	private Forme[][] grilleDeJeu;
	/**
	 * Points à mémoriser pour le joueur
	 */
	private ArrayList<Point> vecteurPoints;
	/**
	 * Niveau présent du jeu
	 */
	private int niveau;

	/**
	 * Construit et initialise le jeu de mémoire
	 */
	public JeuMemoire() {
		preparerVecteurFormes();
		preparerGrilleDeJeu();
		niveau=1;
	}

	/**
	 * Remplit et mélange le vecteur de formes avec le nombre demandé par la taille de la grille.
	 */
	private void preparerVecteurFormes() {
		vecteurFormes = new VecteurFormes();
		vecteurFormes.remplir(NBR_ELEMENTS_GRILLE);
		vecteurFormes.melanger();
	}

	/**
	 * Prépare la grille de jeu à partir des formes dans le vecteur de formes
	 */
	private void preparerGrilleDeJeu() {
		grilleDeJeu = new Forme[LIGNE][COLONNE];
		ArrayList<Forme> listFormes = vecteurFormes.getVecteur();
		for(int ligne = 0; ligne < LIGNE; ligne++) {
			for(int colonne = 0; colonne < COLONNE; colonne++) {
				grilleDeJeu[ligne][colonne] = listFormes.get(ligne*COLONNE + colonne);
			}
		}
	}
	
	/**
	 * Remplace le toString de la classe Object
	 * @return la représentation String de la grille du jeu de mémoire
	 */
	@Override
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
	
	/**
	 * Ajoute des espaces pour atteindre une longueur désirée sur une String
	 * @param pLongueur : longueur cible
	 * @param pNom : la String à allonger
	 * @return la string de la longueur souhaitée
	 */
	private String ajouterEspaces(int pLongueur, String pNom) {
		do {
			pNom += " ";
		}while(pNom.length() < pLongueur);
		return pNom;
	}
	
	/**
	 * Retourne le nom de la forme à la position X, Y de la grille, sans espaces
	 * @param pX : la position X de la forme
	 * @param pY : la position Y de la forme
	 * @return la string représentant le nom de la forme
	 */
	public String getNomForme(int pX, int pY) {
		return(grilleDeJeu[pX][pY].toStringCourt().replace(" ",""));
	}
	
	/**
	 * Fait choisir à l'ordinateur des formes à mémoriser
	 * @return un array contenant les formes à mémoriser
	 */
	public ArrayList<Point> jouerOrdi(){
		ArrayList<Point> out = new ArrayList<Point>();
		while(out.size()<niveau+2) {
			Point p = choisirForme();
			if(!out.contains(p)) {
				out.add(p);
			}
		}
		vecteurPoints=out;
		return out;
	}
	
	/**
	 * Choisis une position au hasard dans la grille
	 * @return le point choisis
	 */
	private Point choisirForme() {
		return new Point((int) Math.floor(Math.random()*COLONNE),(int) Math.floor(Math.random()*LIGNE));
	}
	
	/**
	 * S'assure que le joueur clique les positions attendues
	 * @return true si le joueur a cliqué la prochaine position attendue
	 */
	public boolean jouerHumain(int pX, int pY) {
		return(vecteurPoints.remove(0).equals(new Point(pX,pY)));
	}
	
	/**
	 * Retourne le niveau actuel
	 * @return le niveau actuel
	 */
	public int getNiveau() {
		return niveau;
	}
	
	/**
	 * Retourne le vecteur de formes
	 * @return le vecteur de formes
	 */
	public VecteurFormes getVecteur() {
		return vecteurFormes;
	}
	
	/**
	 * Retourne la grille de jeu
	 * @return la grille de jeu
	 */
	public Forme[][] getGrille(){
		return grilleDeJeu;
	}
	
	/**
	 * Augmente le niveau actuel de 1, jusqu'à un maximum de 6
	 */
	public void setNiveauPlusUn() {
		niveau=Math.min(niveau+1,6);
	}
	
}
