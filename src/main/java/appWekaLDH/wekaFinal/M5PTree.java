package appWekaLDH.wekaFinal;

import java.io.File;
import weka.core.Instances;
import weka.core.converters.ArffLoader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;

import weka.classifiers.Evaluation;
import weka.classifiers.trees.M5P;

// TODO: Auto-generated Javadoc
/**
 * Apply M5P from Weka to the data set.
 *
 * @author Elliott Dorta
 */
public class M5PTree {
	
	
	/** The eval. */
	private Evaluation eval;
	
	/**
	 * class constructor .
	 *
	 * @param file_data the file data
	 */
	public M5PTree(File file_data) {
			
			M5P model;
			//Instance me = null;
		
			try{
				ArffLoader loader = new ArffLoader();
		           
		        loader.setFile(file_data);
				
		        Instances data = new Instances(
						new BufferedReader(
								new FileReader(file_data)));
				data.setClassIndex(data.numAttributes() - 1);
				
				
				model = new M5P();
				model.buildClassifier(data);
				//me = data.lastInstance();
				
				eval = new Evaluation(data);
				eval.crossValidateModel(model, data, 10, new Random(1));
		        
				//System.out.println(eval.toSummaryString());
				
		} catch(Exception e) {
	        e.printStackTrace();
	    }

	}
	
	/**
	 * Prints the result.
	 *
	 * @return the string
	 * @throws Exception the exception
	 */
	String PrintResult() throws Exception {
		
		String resultado = "Algoritmo M5P";
		resultado += "\n";
		resultado += eval.toSummaryString();
		resultado += "\n";
		
        
        return resultado;
	}

}