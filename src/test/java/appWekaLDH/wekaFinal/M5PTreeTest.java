package appWekaLDH.wekaFinal;


import java.io.File;



import junit.framework.TestCase;
import weka.classifiers.trees.M5P;


// TODO: Auto-generated Javadoc
/**
 * The Class M5PTreeTest.
 */
public class M5PTreeTest extends TestCase {


	
	/**
	 * Test M5P tree.
	 */
	public final void testM5PTree() {
		File file_import = new File("datasheets/cpu.arff");
		M5PTree tester = new M5PTree(file_import);
		assertNotNull(tester);
	}
	
	/**
	 * Test print result.
	 *
	 * @throws Exception the exception
	 */
	public final void testPrintResult() throws Exception {
		File file_import = new File("datasheets/cpu.arff");
		M5PTree tester = new M5PTree(file_import);	
		String resultado = tester.PrintResult();
		assertTrue(resultado != "");	
	}
	
	
	/**
	 * Test class weka M5P tree.
	 *
	 * @throws InstantiationException the instantiation exception
	 * @throws IllegalAccessException the illegal access exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	public final void testClassWekaM5PTree() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		M5P m5p = (M5P)Class.forName("weka.classifiers.trees.M5P").newInstance();
		assertNotNull(m5p);
	}

}