package exceptions;

/**
 * Erreur suplémentaire pour les forme
 * 
 * @author Antoine
 * @version 0.0.1 (hiver 2021)
 * 
 */
public class FormeException extends Exception
{

	/**
	 * Construit un erreur par default
	 */
	public FormeException()
	{
		super();
	}

	/**
	 * Construit un error lier d'un message
	 * 
	 * @param message - le message
	 */
	public FormeException(String message)
	{
		super(message);
	}

}
