package appWekaLDH.wekaFinal;

import java.io.File;
import junit.framework.TestCase;
import weka.classifiers.rules.ZeroR;

/**
 * Apply ZeroR from Weka to the data set.
 * @author Miguel Aurelio Garcia Gonzalez
 *
 */
public class ZeroRTest extends TestCase {
	
	/**
	 * Metodo para comprobar que no falla la ejecucion del metodo al importar un fichero.
	 */
	public final void testZeroR() {
		File file_import = new File("datasheets/iris.arff");
		ZeroR_Alg tester = new ZeroR_Alg(file_import);
		assertNotNull(tester);
	}
	
	/**
	 * Metodo para comprobar que el resultado que se muestra por pantalla tiene un contenido distinto al definido al comienzo.
	 *
	 * @throws Exception the exception
	 */
	public final void testPrintResult() throws Exception {
		File file_import = new File("datasheets/iris.arff");
		ZeroR_Alg tester = new ZeroR_Alg(file_import);	
		String resultado = tester.PrintResult();
		assertTrue(resultado != "Algoritmo ZeroR");	
	}
	
	
	/**
	 * Metodo para comprobar que se crea la instancia del objeto ZeroR de weka.
	 *
	 * @throws InstantiationException the instantiation exception
	 * @throws IllegalAccessException the illegal access exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	public final void testClassWekaZeroR() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		ZeroR zeror = (ZeroR)Class.forName("weka.classifiers.rules.ZeroR").newInstance();
		assertNotNull(zeror);
	}

}
