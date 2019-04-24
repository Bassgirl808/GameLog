package edu.hpu.esportsgamelog;


/**
 *
 * @author Joecelyn Saloma, Cherlyn Kay Alejandro
 */
public class EsportsGameLog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static DatabaseConnector dbc = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	System.out.println("Started Application");
    	dbc = new DatabaseConnector();
    	System.out.println("Docky-nee");
    }
}
