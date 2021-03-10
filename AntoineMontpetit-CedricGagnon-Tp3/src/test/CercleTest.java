package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import exceptions.FormeException;
import formes.Cercle;
import formes.Couleur;

public class CercleTest
{

	public Cercle c1, c2, c3, c4, c5, c6;

	@Before
	public void setUp()
	{
		try
		{
			c1 = new Cercle(1);
			c2 = new Cercle(30);
			c3 = new Cercle(10);
			c4 = new Cercle(20);
			c5 = new Cercle(10);
			c6 = new Cercle(50);
			fail("Les mesure entre 1 et 30 devrait être invalide");
		}
		catch (FormeException e)
		{
		}
	}

	@After
	public void tearDown()
	{
		c1 = null;
		c2 = null;
		c3 = null;
		c4 = null;
		c5 = null;
		c6 = null;
	}

	@Test
	public void testGetRayon()
	{
		assertEquals(c1.getRayon(), 1);
		assertEquals(c2.getRayon(), 30);
		assertEquals(c3.getRayon(), 10);
		assertEquals(c4.getRayon(), 20);
		assertEquals(c5.getRayon(), 10);
	}

	@Test
	public void testGetNom()
	{
		assertEquals(c1.getNom(), "Cercle");
		assertEquals(c2.getNom(), "Cercle");
		assertEquals(c3.getNom(), "Cercle");
		assertEquals(c4.getNom(), "Cercle");
		assertEquals(c5.getNom(), "Cercle");
	}

	@Test
	public void testGetCouleur()
	{
		assertEquals(c1.getCouleur(), Couleur.ROUGE);
		c2.setCouleur(Couleur.BLEU);
		assertEquals(c2.getCouleur(), Couleur.BLEU);
		c3.setCouleur(Couleur.JAUNE);
		assertEquals(c3.getCouleur(), Couleur.JAUNE);
		c4.setCouleur(Couleur.NOIR);
		assertEquals(c4.getCouleur(), Couleur.NOIR);
		c5.setCouleur(Couleur.ORANGE);
		assertEquals(c5.getCouleur(), Couleur.ORANGE);
	}

	@Test
	public void testSetRayon()
	{
		c1.setRayon(0);
		c2.setRayon(31);
		c3.setRayon(15);
		c4.setRayon(30);
		c5.setRayon(1);
		assertEquals(c1.getRayon(), 1);
		assertEquals(c2.getRayon(), 30);
		assertEquals(c3.getRayon(), 15);
		assertEquals(c4.getRayon(), 30);
		assertEquals(c5.getRayon(), 1);
	}

	@Test
	public void testSetCouleur()
	{
		assertEquals(c1.getCouleur(), Couleur.ROUGE);
		c2.setCouleur(Couleur.BLEU);
		assertEquals(c2.getCouleur(), Couleur.BLEU);
		c3.setCouleur(Couleur.JAUNE);
		assertEquals(c3.getCouleur(), Couleur.JAUNE);
		c4.setCouleur(Couleur.NOIR);
		assertEquals(c4.getCouleur(), Couleur.NOIR);
		c5.setCouleur(Couleur.ORANGE);
		assertEquals(c5.getCouleur(), Couleur.ORANGE);
	}

	@Test
	public void testCalculerSurface()
	{
		assertEquals(c1.calculerSurface(), 3);
		assertEquals(c2.calculerSurface(), 2827);
		assertEquals(c3.calculerSurface(), 314);
		assertEquals(c4.calculerSurface(), 1256);
		assertEquals(c5.calculerSurface(), 314);
	}

	@Test
	public void testCalculerPerimetre()
	{
		assertEquals(c1.calculerPerimetre(), 6);
		assertEquals(c2.calculerPerimetre(), 188);
		assertEquals(c3.calculerPerimetre(), 62);
		assertEquals(c4.calculerPerimetre(), 125);
		assertEquals(c5.calculerPerimetre(), 62);

	}

	@Test
	public void testToString()
	{
		c2.setCouleur(Couleur.BLEU);
		c3.setCouleur(Couleur.JAUNE);
		c4.setCouleur(Couleur.NOIR);
		c5.setCouleur(Couleur.ORANGE);
		assertEquals(c1.toString(), "Cercle rouge 1");
		assertEquals(c2.toString(), "Cercle bleu 30");
		assertEquals(c3.toString(), "Cercle jaune 10");
		assertEquals(c4.toString(), "Cercle noir 20");
		assertEquals(c5.toString(), "Cercle orange 10");
	}

	@Test
	public void testEqualsObject()
	{
		assertEquals(c3.equals(c5), true);
		c4.setCouleur(Couleur.JAUNE);
		c2.setCouleur(Couleur.JAUNE);
		c4.setRayon(30);
		assertEquals(c2.equals(c4), true);
		assertEquals(c1.equals(c4), false);
	}

}
