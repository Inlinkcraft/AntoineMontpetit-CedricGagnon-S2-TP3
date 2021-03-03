package formes;

import java.util.ArrayList;
import exceptions.*;

public class VecteurFormes implements ManipulerVecteur {
	ArrayList<Forme> vecteur;
	
	public VecteurFormes() {}
	
	private static boolean validerNbrFormes(int pNbr) {
		return(pNbr>=0);
	}
	
	public void remplir(int pNbr) {
		vecteur=new ArrayList<Forme>();
		if(validerNbrFormes(pNbr)) {
			while(vecteur.size()<pNbr) {
				try {
					if(vecteur.size()%3==0) {
						vecteur.add(new Cercle(10));
					}
					else if(vecteur.size()%3==1) {
						vecteur.add(new Rectangle(10,10));
					}
					else {
						vecteur.add(new Triangle(10,10,10));
					}
					vecteur.get(vecteur.size()-1).setCouleur(Couleur.values()[((vecteur.size()-1)/3)%6]);
				}
				catch(FormeException e) {
					try {
						vecteur.add(new Cercle(Forme.MIN_VAL));
					}
					catch(Exception f) {
						System.out.println("Comment on est rendu là???");
					}
				}
			}
			
		}
	}
	
	public ArrayList<Forme> getVecteur() {
		return(vecteur);
	}
	
	@Override
	public String toString() {
		String out="";
		for(int i=0;i<vecteur.size();i++) {
			out+=vecteur.get(i).getNom()+", "+vecteur.get(i).getCouleur()+" | ";
		}
		return(out);
	}
	
	public void trier() {}
	
	public void melanger() {}
	
	private void permuter(int pPremier, int pDeuxieme) {}
	
	public static void main(String[] args) {
		VecteurFormes test = new VecteurFormes();
		test.remplir(36);
		System.out.println(test);
	}
}
