package appWekaLDH.wekaFinal;

import java.io.File;

import junit.framework.TestCase;

/**
 * Class for test the interfaz.
 * @author Miguel Aurelio Garcia Gonzalez
 *
 */
public class InterfazGraficaTest extends TestCase {
	
	/**
	 *  Methods for test the upload files.
	 */
	public final void testCargaFicheroCpu() {
		
		File file_input = new File("datasheets/cpu.arff");
		
		assertTrue(file_input.exists());
		
	}
	
	public final void testCargaFicheroIris() {
		
		File file_input = new File("datasheets/iris.arff");
		
		assertTrue(file_input.exists());
		
	}
	
	public final void testCargaFichero() {
		
		File file_input = new File("datasheets/glass.arff");
		
		assertTrue(file_input.exists());
		
	}

}
