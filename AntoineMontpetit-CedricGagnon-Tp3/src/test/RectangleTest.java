package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import exceptions.FormeException;
import formes.Couleur;
import formes.Rectangle;

public class RectangleTest
{

	Rectangle r1, r2, r3, r4, r5, r6, r7;

	@Before
	public void setUp()
	{
		try
		{
			r1 = new Rectangle(1, 10);
			r2 = new Rectangle(10, 1);
			r3 = new Rectangle(30, 10);
			r4 = new Rectangle(10, 30);
			r5 = new Rectangle(5, 10);
			r6 = new Rectangle(1, 50);
			r7 = new Rectangle(-1, 30);
			fail("Les mesure entre 1 et 30 devrait être invalide");
		}
		catch (FormeException e)
		{
		}
	}

	@After
	public void tearDown()
	{
		r1 = null;
		r2 = null;
		r3 = null;
		r4 = null;
		r5 = null;
		r6 = null;
		r7 = null;
	}

	@Test
	public void testGetHauteur()
	{
		assertEquals(r1.getHauteur(), 1);
		assertEquals(r2.getHauteur(), 10);
		assertEquals(r3.getHauteur(), 30);
		assertEquals(r4.getHauteur(), 10);
		assertEquals(r5.getHauteur(), 5);
	}

	@Test
	public void testGetLargeur()
	{
		assertEquals(r1.getLargeur(), 10);
		assertEquals(r2.getLargeur(), 1);
		assertEquals(r3.getLargeur(), 10);
		assertEquals(r4.getLargeur(), 30);
		assertEquals(r5.getLargeur(), 10);
	}

	@Test
	public void testGetNom()
	{
		assertEquals(r1.getNom(), "Rectangle");
		assertEquals(r2.getNom(), "Rectangle");
		assertEquals(r3.getNom(), "Rectangle");
		assertEquals(r4.getNom(), "Rectangle");
		assertEquals(r5.getNom(), "Rectangle");
	}

	@Test
	public void testGetCouleur()
	{
		assertEquals(r1.getCouleur(), Couleur.ROUGE);
		r2.setCouleur(Couleur.BLEU);
		assertEquals(r2.getCouleur(), Couleur.BLEU);
		r3.setCouleur(Couleur.JAUNE);
		assertEquals(r3.getCouleur(), Couleur.JAUNE);
		r4.setCouleur(Couleur.NOIR);
		assertEquals(r4.getCouleur(), Couleur.NOIR);
		r5.setCouleur(Couleur.ORANGE);
		assertEquals(r5.getCouleur(), Couleur.ORANGE);
	}

	@Test
	public void testSetHauteur()
	{
		r1.setHauteur(-5);
		r2.setHauteur(9);
		r3.setHauteur(10);
		r4.setHauteur(3);
		r5.setHauteur(31);
		assertEquals(r1.getHauteur(), 1);
		assertEquals(r2.getHauteur(), 9);
		assertEquals(r3.getHauteur(), 10);
		assertEquals(r4.getHauteur(), 3);
		assertEquals(r5.getHauteur(), 5);
	}

	@Test
	public void testSetLargeur()
	{
		r1.setLargeur(-6);
		r2.setLargeur(15);
		r3.setLargeur(9);
		r4.setLargeur(6);
		r5.setLargeur(35);
		assertEquals(r1.getLargeur(), 10);
		assertEquals(r2.getLargeur(), 15);
		assertEquals(r3.getLargeur(), 9);
		assertEquals(r4.getLargeur(), 6);
		assertEquals(r5.getLargeur(), 10);
	}

	@Test
	public void testSetCouleur()
	{
		assertEquals(r1.getCouleur(), Couleur.ROUGE);
		r2.setCouleur(Couleur.BLEU);
		assertEquals(r2.getCouleur(), Couleur.BLEU);
		r3.setCouleur(Couleur.JAUNE);
		assertEquals(r3.getCouleur(), Couleur.JAUNE);
		r4.setCouleur(Couleur.NOIR);
		assertEquals(r4.getCouleur(), Couleur.NOIR);
		r5.setCouleur(Couleur.ORANGE);
		assertEquals(r5.getCouleur(), Couleur.ORANGE);
	}

	@Test
	public void testCalculerSurface()
	{
		assertEquals(r1.calculerSurface(), 10);
		assertEquals(r2.calculerSurface(), 10);
		assertEquals(r3.calculerSurface(), 300);
		assertEquals(r4.calculerSurface(), 300);
		assertEquals(r5.calculerSurface(), 50);
	}

	@Test
	public void testCalculerPerimetre()
	{
		assertEquals(r1.calculerPerimetre(), 22);
		assertEquals(r2.calculerPerimetre(), 22);
		assertEquals(r3.calculerPerimetre(), 80);
		assertEquals(r4.calculerPerimetre(), 80);
		assertEquals(r5.calculerPerimetre(), 30);
	}

	@Test
	public void testEqualsObject()
	{

		r4.setHauteur(5);
		r4.setLargeur(10);
		r4.setCouleur(Couleur.JAUNE);
		r5.setCouleur(Couleur.JAUNE);
		assertEquals(r5.equals(r4), true);

		r3.setHauteur(10);
		r2.setLargeur(10);
		r3.setCouleur(Couleur.ORANGE);
		r2.setCouleur(Couleur.ORANGE);

		assertEquals(r3.equals(r2), true);

		r5.setCouleur(Couleur.BLEU);
		assertEquals(r5.equals(r4), false);

		r5.setCouleur(Couleur.JAUNE);
		r5.setLargeur(2);
		assertEquals(r5.equals(r4), false);
	}

	@Test
	public void testToString()
	{
		r2.setCouleur(Couleur.BLEU);
		r3.setCouleur(Couleur.JAUNE);
		r4.setCouleur(Couleur.NOIR);
		r5.setCouleur(Couleur.ORANGE);
		assertEquals(r1.toString(), "Rectangle rouge 1 10");
		assertEquals(r2.toString(), "Rectangle bleu 10 1");
		assertEquals(r3.toString(), "Rectangle jaune 30 10");
		assertEquals(r4.toString(), "Rectangle noir 10 30");
		assertEquals(r5.toString(), "Rectangle orange 5 10");
	}

}
