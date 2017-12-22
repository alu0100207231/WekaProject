package appWekaLDH.wekaFinal;

import java.io.File;
import java.util.Random;

import weka.classifiers.Evaluation;
import weka.classifiers.lazy.IBk;
import weka.core.Instances;
import weka.core.converters.ArffLoader;

/**
 * Apply IBk from Weka to the data set
 * @author HilarioJ
 *
 */
public class LazyIBk {
	
	private Evaluation eval;
	
	
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

	String PrintResult() throws Exception {
	
		String resultado = "";
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