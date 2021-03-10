package test;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import formes.Forme;
import formes.VecteurFormes;
import jeu.JeuMemoire;

public class JeuMemoireTest {

	public JeuMemoire j1;

	@Before
	public void setUp()
	{
		j1 = new JeuMemoire();
	}

	@After
	public void tearDown()
	{
		j1 = null;
	}

	@Test
	public void testToString() {
		String[] noms = j1.toString().split("[|]");
		for (int i = 0; i < noms.length -1; i++) {
			assertEquals(noms[i].trim().replace("\n", "").replace("|", ""),j1.getGrille()[Math.floorDiv(i, JeuMemoire.COLONNE)][i % JeuMemoire.COLONNE].toStringCourt());
		}
		
	}

	@Test
	public void testGetNomForme() {
		
		for (int x = 0; x < JeuMemoire.COLONNE; x++) {
			for (int y = 0; y < JeuMemoire.LIGNE; y++) {
				assertEquals(j1.getNomForme(x, y),j1.getGrille()[x][y].toStringCourt().replace(" ", ""));
			}
		}
		
	}

	@Test
	public void testJouerOrdi() {
		for (int j = 0; j < 10; j++) {
			ArrayList<Point> points = j1.jouerOrdi();
			assertEquals(points.size(),j1.getNiveau() + 2);
			for (int i = 0; i < points.size(); i++) {
				Point temp = points.remove(0);
				assertFalse(points.contains(temp));
				points.add(temp);
			}
		}
	}

	@Test
	public void testJouerHumain() {
		ArrayList<Point> points = j1.jouerOrdi();
		assertTrue(j1.jouerHumain(points.get(0).x, (points.get(0).y)));
		assertFalse(j1.jouerHumain(-1, -1));
	}

	@Test
	public void testGetNiveau() {
		assertEquals(j1.getNiveau(), 1);
	}

	@Test
	public void testGetVecteur() {
		VecteurFormes v1 = j1.getVecteur();
		Forme[][] g1 = j1.getGrille();
		assertEquals(v1.getVecteur().size(),JeuMemoire.NBR_ELEMENTS_GRILLE);
		for (int i = 0; i < v1.getVecteur().size(); i++) {
			assertEquals(v1.getVecteur().get(i),g1[Math.floorDiv(i, JeuMemoire.COLONNE)][i % JeuMemoire.COLONNE]);
		}
	}

	@Test
	public void testGetGrille() {
		VecteurFormes v1 = j1.getVecteur();
		Forme[][] g1 = j1.getGrille();
		assertEquals(g1.length,JeuMemoire.COLONNE);
		assertEquals(g1[0].length,JeuMemoire.LIGNE);
		for (int x = 0; x < JeuMemoire.COLONNE; x++) {
			for (int y = 0; y < JeuMemoire.LIGNE; y++) {
				assertEquals(j1.getGrille()[x][y],v1.getVecteur().get(x*JeuMemoire.COLONNE + y));
			}
		}
	}

	@Test
	public void testSetNiveauPlusUn() {
		assertEquals(j1.getNiveau(), 1);
		j1.setNiveauPlusUn();
		assertEquals(j1.getNiveau(), 2);
	}

}
