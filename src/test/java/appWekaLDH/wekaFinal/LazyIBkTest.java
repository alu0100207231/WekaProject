package appWekaLDH.wekaFinal;

import java.io.File;

import junit.framework.TestCase;

/**
 * Test simple de la clase LinearRegressionWeka
 * @author Hilario Pérez
 *
 */
public class LazyIBkTest extends TestCase {
	
	/**
	 * Comprueba que el fichero de datos existe
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 */
	public final void testFileExists() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		File file = new File("datasheets/iris.arff");
		assertTrue(file.exists());
	}

	/**
	 * Comprueba que no falle la ejecucion del metodo al importar el fichero
	 * @param datasheet iris.arff
	 */
	public final void testLazyIBk() {
		File file_import = new File("datasheets/iris.arff");
		LazyIBk tester = new LazyIBk(file_import);
		assertNotNull(tester);
	}
	
	/**
	 * Metodo para ver si el resultado al mostrar por pantalla tiene contenido distinto del defininido en la clase como predeterminado
	 * @throws Exception
	 * @param datasheet iris.arff
	 */
	public final void testPrintResult() throws Exception {
		File file_import = new File("datasheets/iris.arff");
		LazyIBk tester = new LazyIBk(file_import);	
		String resultado = tester.PrintResult();
		assertTrue(resultado != "IBk\n");	
	}

	/**
	 * Metodo para ver si el resultado al mostrar por pantalla tiene contenido distinto del defininido en la clase como predeterminado
	 * @throws Exception
	 * @param datasheet cpu.arff
	 */
	/*public final void testPrintResult2() throws Exception {
		File file_import = new File("datasheets/cpu.arff");
		LazyIBk tester = new LazyIBk(file_import);	
		assertNotNull(tester.PrintResult());	
	}*/

}