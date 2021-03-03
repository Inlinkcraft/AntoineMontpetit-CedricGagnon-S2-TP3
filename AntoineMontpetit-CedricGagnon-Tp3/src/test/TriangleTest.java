package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import exceptions.FormeException;
import formes.Couleur;
import formes.Triangle;
import formes.TypeTriangle;

public class TriangleTest
{

	Triangle t1, t2, t3, t4, t5, t6, t7, t8, t9, t10;

	@Before
	public void setUp()
	{
		try
		{
			t1 = new Triangle(1, 1, 1);
			t2 = new Triangle(30, 30, 30);
			t3 = new Triangle(20, 20, 5);
			t4 = new Triangle(3, 4, 5);
			t5 = new Triangle(4, 3, 5);
			t6 = new Triangle(5, 6, 3);
			t7 = new Triangle(31, 32, 33);
			t8 = new Triangle(-1, -2, -3);
			t9 = new Triangle(2, 2, 4);
			t10 = new Triangle(2, 2, 10);
			fail("Les mesure entre 1 et 30 devrait être invalide");
		}
		catch (FormeException e)
		{
		}
	}

	@After
	public void tearDown()
	{
		t1 = null;
		t2 = null;
		t3 = null;
		t4 = null;
		t5 = null;
		t6 = null;
		t7 = null;
		t8 = null;
		t9 = null;
		t10 = null;
	}

	@Test
	public void testCalculerSurface()
	{
		assertEquals(t1.calculerSurface(), 0);
		assertEquals(t2.calculerSurface(), 389);
		assertEquals(t3.calculerSurface(), 49);
		assertEquals(t4.calculerSurface(), 6);
		assertEquals(t5.calculerSurface(), 6);
		assertEquals(t6.calculerSurface(), 7);
	}

	@Test
	public void testCalculerPerimetre()
	{
		assertEquals(t1.calculerPerimetre(), 3);
		assertEquals(t2.calculerPerimetre(), 90);
		assertEquals(t3.calculerPerimetre(), 45);
		assertEquals(t4.calculerPerimetre(), 12);
		assertEquals(t5.calculerPerimetre(), 12);
		assertEquals(t6.calculerPerimetre(), 14);
	}

	@Test
	public void testToString()
	{
		t2.setCouleur(Couleur.BLEU);
		t3.setCouleur(Couleur.JAUNE);
		t4.setCouleur(Couleur.NOIR);
		t5.setCouleur(Couleur.ORANGE);
		t6.setCouleur(Couleur.VERT);
		assertEquals(t1.toString(), "Triangle rouge equilateral 1 1 1");
		assertEquals(t2.toString(), "Triangle bleu equilateral 30 30 30");
		assertEquals(t3.toString(), "Triangle jaune isocele 20 20 5");
		assertEquals(t4.toString(), "Triangle noir rectangle 3 4 5");
		assertEquals(t5.toString(), "Triangle orange rectangle 4 3 5");
		assertEquals(t6.toString(), "Triangle vert scalene 5 6 3");
	}

	@Test
	public void testGetCoteA()
	{
		assertEquals(t1.getCoteA(), 1);
		assertEquals(t2.getCoteA(), 30);
		assertEquals(t3.getCoteA(), 20);
		assertEquals(t4.getCoteA(), 3);
		assertEquals(t5.getCoteA(), 4);
		assertEquals(t6.getCoteA(), 5);
	}

	@Test
	public void testGetCoteB()
	{
		assertEquals(t1.getCoteB(), 1);
		assertEquals(t2.getCoteB(), 30);
		assertEquals(t3.getCoteB(), 20);
		assertEquals(t4.getCoteB(), 4);
		assertEquals(t5.getCoteB(), 3);
		assertEquals(t6.getCoteB(), 6);
	}

	@Test
	public void testGetCoteC()
	{
		assertEquals(t1.getCoteC(), 1);
		assertEquals(t2.getCoteC(), 30);
		assertEquals(t3.getCoteC(), 5);
		assertEquals(t4.getCoteC(), 5);
		assertEquals(t5.getCoteC(), 5);
		assertEquals(t6.getCoteC(), 3);
	}

	@Test
	public void testGetType()
	{
		assertEquals(t1.getType(), TypeTriangle.EQUILATERAL);
		assertEquals(t2.getType(), TypeTriangle.EQUILATERAL);
		assertEquals(t3.getType(), TypeTriangle.ISOCELE);
		assertEquals(t4.getType(), TypeTriangle.RECTANGLE);
		assertEquals(t5.getType(), TypeTriangle.RECTANGLE);
		assertEquals(t6.getType(), TypeTriangle.SCALENE);
	}

}
