package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import formes.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import exceptions.FormeException;

public class VecteurFormesTest {

	 VecteurFormes v1;

	@Before
	public void setUp()
	{
		v1 = new VecteurFormes();
	}

	@After
	public void tearDown()
	{
		v1 = null;
	}

	@Test
	public void testRemplir() throws FormeException{
		
		v1.remplir(-1);
		assertEquals(v1.getVecteur().size(), 0);
		
		Forme[] testForme1 = {
			new Cercle(10),
			new Rectangle(10,10),
			new Triangle(10,10,10),
			new Cercle(10),
			new Rectangle(10,10),
			new Triangle(10,10,10),
		};
		
		testForme1[0].setCouleur(Couleur.ROUGE);
		testForme1[1].setCouleur(Couleur.ROUGE);
		testForme1[2].setCouleur(Couleur.ROUGE);
		testForme1[3].setCouleur(Couleur.VERT);
		testForme1[4].setCouleur(Couleur.VERT);
		testForme1[5].setCouleur(Couleur.VERT);
		
		v1.remplir(6);
		Object[] v1test = v1.getVecteur().toArray();
		for (int i = 0; i < v1test.length; i++) {
			assertEquals(v1test[i], testForme1[i]);
		}
		
		v1.getVecteur().clear();
		
		Forme[] testForme2 = {
				new Cercle(10),
				new Rectangle(10,10),
				new Triangle(10,10,10),
				new Cercle(10),
				new Rectangle(10,10),
				new Triangle(10,10,10),
				new Cercle(10),
				new Rectangle(10,10),
				new Triangle(10,10,10),
				new Cercle(10),
		};
			
		testForme2[0].setCouleur(Couleur.ROUGE);
		testForme2[1].setCouleur(Couleur.ROUGE);
		testForme2[2].setCouleur(Couleur.ROUGE);
		testForme2[3].setCouleur(Couleur.VERT);
		testForme2[4].setCouleur(Couleur.VERT);
		testForme2[5].setCouleur(Couleur.VERT);
		testForme2[6].setCouleur(Couleur.BLEU);
		testForme2[7].setCouleur(Couleur.BLEU);
		testForme2[8].setCouleur(Couleur.BLEU);
		testForme2[9].setCouleur(Couleur.JAUNE);
			
		v1.remplir(10);
		v1test = v1.getVecteur().toArray();
		for (int i = 0; i < v1test.length; i++) {
			assertEquals(v1test[i], testForme2[i]);
		}
		
	}

	@Test
	public void testGetVecteur() {
		assertEquals(v1.getVecteur() instanceof ArrayList<?>, true);
	}

	@Test
	public void testToString() {
		v1.remplir(6);
		assertEquals(v1.toString(), "Cercle rouge\n"
				+ "Rectangle rouge\n"
				+ "Triangle rouge\n"
				+ "Cercle vert\n"
				+ "Rectangle vert\n"
				+ "Triangle vert\n");
	}

	@Test
	public void testTrier() {
		v1.remplir(25);
		VecteurFormes v2 = new VecteurFormes();
		v2.remplir(25);
		v2.trier();
		v1.melanger();
		v1.trier();
		assertEquals(v1.getVecteur(),v2.getVecteur());
	}

	@Test
	public void testMelanger() {
		VecteurFormes v2 = new VecteurFormes();
		v1.remplir(100);
		v1.melanger();
		v2.remplir(100);
		v2.melanger();
		int j = 0;
		for (int i = 0; i < v1.getVecteur().size(); i++) {
			j += v1.getVecteur().get(i).equals(v2.getVecteur().get(i)) ? 1:0;
		}
		
		assertTrue(j < 15);
	}

}
