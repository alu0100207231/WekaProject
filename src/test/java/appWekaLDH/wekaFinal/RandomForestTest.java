package appWekaLDH.wekaFinal;

import java.io.File;
import junit.framework.TestCase;
import weka.classifiers.trees.RandomForest;

/**
 * Apply RandomForest from Weka to the data set.
 * @author Miguel Aurelio Garcia Gonzalez
 *
 */
public class RandomForestTest extends TestCase {
	
	/**
	 * Metodo para comprobar que no falla la ejecucion del metodo al importar un fichero.
	 */
	public final void testRandomForestTree() {
		File file_import = new File("datasheets/cpu.arff");
		RandomForest_Tree tester = new RandomForest_Tree(file_import);
		assertNotNull(tester);
	}
	
	/**
	 * Metodo para comprobar que el resultado que se muestra por pantalla tiene un contenido distinto al definido al comienzo.
	 *
	 * @throws Exception the exception
	 */
	public final void testPrintResult() throws Exception {
		File file_import = new File("datasheets/cpu.arff");
		RandomForest_Tree tester = new RandomForest_Tree(file_import);	
		String resultado = tester.PrintResult();
		assertTrue(resultado != "Algoritmo RandomForest");	
	}
	
	
	/**
	 * Metodo para comprobar que se crea la instancia del objeto RandomForest de weka.
	 *
	 * @throws InstantiationException the instantiation exception
	 * @throws IllegalAccessException the illegal access exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	public final void testClassWekaRandomForestTree() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		RandomForest randomForest = (RandomForest)Class.forName("weka.classifiers.trees.RandomForest").newInstance();
		assertNotNull(randomForest);
	}

}
