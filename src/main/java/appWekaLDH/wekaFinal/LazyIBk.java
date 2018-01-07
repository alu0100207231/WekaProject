package appWekaLDH.wekaFinal;

import java.io.File;
import java.util.Random;

import weka.classifiers.Evaluation;
import weka.classifiers.lazy.IBk;
import weka.core.Instances;
import weka.core.converters.ArffLoader;

/**
 * Apply IBk from Weka to the data set
 * @author Hilario Pérez
 *
 */
public class LazyIBk {
	
	private Evaluation eval; /// Variable Evaluadora
	
	/**
	 * Constructor de la clase LazyIBk
	 * @param file_data
	 */
	public LazyIBk(File file_data) {
		Instances trainIns = null;
		IBk knn;
		
		try {
			ArffLoader loader = new ArffLoader();
	           
	        loader.setFile(file_data);
	        trainIns = loader.getDataSet();
	           
	        trainIns.setClassIndex(trainIns.numAttributes()-1);
	        
	        knn = (IBk)Class.forName("weka.classifiers.lazy.IBk").newInstance();
	           
	        knn.buildClassifier(trainIns);
	           
	        eval = new Evaluation(trainIns);
	           
	        eval.crossValidateModel(knn, trainIns, 10, new Random(1));
	                 
	} catch(Exception e) {
		e.printStackTrace();
	}

}

	/**
	 * Método que formatea el resultado del Algoritmo IBk
	 * @return String
	 * @throws Exception
	 */
	String PrintResult() throws Exception {
	
		String resultado = "IBk";
		resultado = eval.toClassDetailsString();
		resultado += "\n";
		resultado += eval.toCumulativeMarginDistributionString();
		resultado += "\n";
		resultado += eval.toSummaryString();
		resultado += "\n";
		resultado += eval.toMatrixString();
		resultado += "\n";
 
		return resultado;
	}
}