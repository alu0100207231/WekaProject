package appWekaLDH.wekaFinal;



import java.io.File;


import junit.framework.TestCase;
import weka.classifiers.trees.J48;


// TODO: Auto-generated Javadoc
/**
 * The Class J48TreeTest.
 */
public class J48TreeTest extends TestCase {


	
	/**
	 * Test J 48 tree.
	 */
	public final void testJ48Tree() {
		File file_import = new File("datasheets/iris.arff");
		J48Tree tester = new J48Tree(file_import);
		assertNotNull(tester);
	}
	
	/**
	 * Test print result.
	 *
	 * @throws Exception the exception
	 */
	public final void testPrintResult() throws Exception {
		File file_import = new File("datasheets/iris.arff");
		J48Tree tester = new J48Tree(file_import);	
		assertTrue(tester.resultado != "");	
	}
	
	/**
	 * Test class weka J 48 tree.
	 *
	 * @throws InstantiationException the instantiation exception
	 * @throws IllegalAccessException the illegal access exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	public final void testClassWekaJ48Tree() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		J48 j48 = (J48)Class.forName("weka.classifiers.trees.J48").newInstance();
		assertNotNull(j48);
	}

}