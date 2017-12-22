package appWekaLDH.wekaFinal;

import java.io.File;

import junit.framework.TestCase;
import weka.classifiers.lazy.KStar;

/**
 * Test simple de la clase LazyKStar
 * @author Héctor Figueras
 *
 */

public class LazyKStarTest extends TestCase {

	/**
	 * Metodo que comprueba si el contenido de la clase LazyKStar es correcto
	 * @param datasheet iris.arff
	 */
	public final void testLazyKStar() {
		File file_import = new File("datasheets/iris.arff");
		LazyKStar tester = new LazyKStar(file_import);
		assertNotNull(tester);
	}
	
	/**
	 * Metodo para ver si el resultado al mostrar por pantalla tiene contenido distinto del defininido en la clase como predeterminado
	 * @throws Exception
	 * @param datasheet iris.arff
	 */
	public final void testPrintResult() throws Exception {
		File file_import = new File("datasheets/iris.arff");
		LazyKStar tester = new LazyKStar(file_import);	
		String resultado = tester.PrintResult();
		assertTrue(resultado != "");	
	}
	
	/**
	 * Comprueba que la clase de Weka lazy.KStar esta disponible para su utilizacion
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 */
	public final void testClassWekaLazyKStar() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		KStar star = (KStar)Class.forName("weka.classifiers.lazy.KStar").newInstance();
		assertNotNull(star);
	}

}
