package formes;

/**
 * Contient les types possibles de triangles
 * 
 * @author Cédric Gagnon
 * @version 17 Fev 2021
 */
public enum TypeTriangle
{
	/**
	 * Types Possibles
	 */
	ISOCELE("isocèle"), EQUILATERAL("équilatéral"), RECTANGLE(
			"rectangle"), SCALENE("scalène");

	/**
	 * La String représentant le type du triangle
	 */
	private String type = null;

	/**
	 * Construit un type
	 * 
	 * @param pType : la String représentant le type à former
	 */
	private TypeTriangle(String pType)
	{
		type = pType;
	}

	/**
	 * Retourne la String représentant le type de triangle
	 * 
	 * @return la String représentant le type de triangle
	 */
	public String getType()
	{
		return (type);
	}

	/**
	 * Modifie la String représentant le type du triangle
	 * 
	 * @param pType : la nouvelle String à assigner
	 */
	private void setType(String pType)
	{
		type = pType;
	}

	/**
	 * Remplace la fonction toString de la classe Object
	 * 
	 * @return la représentation String du type de triangle
	 */
	public String toString()
	{
		return (type);
	}

}
