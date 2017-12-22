package appWekaLDH.wekaFinal;

import java.io.File;
import java.util.Random;

import weka.classifiers.Evaluation;
import weka.classifiers.lazy.KStar;
import weka.core.Instances;
import weka.core.converters.ArffLoader;

/**
 * Apply LazyKStar from Weka to the data set
 * @author Héctor Figueras
 *
 */
public class LazyKStar {
	
	private Evaluation eval;
	
	/**
	 * class constructor 
	 * @param file from datasheet
	 */
	public LazyKStar(File file_data) {
		
			Instances trainIns = null;
			KStar star;
			try{
		           ArffLoader loader = new ArffLoader();
		           
		           loader.setFile(file_data);
		           trainIns = loader.getDataSet();
		          
		           
		           trainIns.setClassIndex(trainIns.numAttributes()-1);
		           
		           star = (KStar)Class.forName("weka.classifiers.lazy.KStar").newInstance();
		           
		           star.buildClassifier(trainIns);
		           
		           eval = new Evaluation(trainIns);
		           
		           eval.crossValidateModel(star, trainIns, 10, new Random(1));
		                 
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
