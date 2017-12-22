package appWekaLDH.wekaFinal;

import java.io.File;

import junit.framework.TestCase;


/**
 * Test simple de la clase LinearRegressionWeka
 * @author Hector Figueras
 *
 */

public class LinearRegressionTest extends TestCase {
	
	/**
	 * Comprueba que el fichero de datos existe
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 */
	public final void testFileExists() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		File file = new File("datasheets/cpu.arff");
		assertTrue(file.exists());
	}

	/**
	 * Comprueba que no falle la ejecucion del metodo al importar el fichero
	 * @param datasheet cpu.arff
	 */
	public final void testLinearRegressionWeka() {
		File file_import = new File("datasheets/cpu.arff");
		LinearRegressionWeka tester = new LinearRegressionWeka(file_import);
		assertNotNull(tester);
	}
	
	/**
	 * Metodo para ver si el resultado al mostrar por pantalla tiene contenido distinto del defininido en la clase como predeterminado
	 * @throws Exception
	 * @param datasheet cpu.arff
	 */
	public final void testPrintResult() throws Exception {
		File file_import = new File("datasheets/cpu.arff");
		LinearRegressionWeka tester = new LinearRegressionWeka(file_import);	
		String resultado = tester.PrintResult();
		assertTrue(resultado != "Linear Regression\n");	
	}

}
