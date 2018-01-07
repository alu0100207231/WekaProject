package appWekaLDH.wekaFinal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Random;

import weka.classifiers.Evaluation;
import weka.classifiers.trees.RandomForest;
import weka.core.Instances;
import weka.core.converters.ArffLoader;

/**
 * Apply RandomForest from weka to the data set
 * @author Miguel Aurelio Garcia Gonzalez
 */
public class RandomForest_Tree {

	/** The eval. */
	private Evaluation eval;
	
	/**
	 * class constructor.
	 *
	 * @param file_data the file data
	 */
	public RandomForest_Tree(File file_data) {
			
			RandomForest model;
		
			try{
				ArffLoader loader = new ArffLoader();
		           
		        loader.setFile(file_data);
				
		        Instances data = new Instances(
						new BufferedReader(
								new FileReader(file_data)));
				data.setClassIndex(data.numAttributes() - 1);
				
				
				model = new RandomForest();
				model.buildClassifier(data);
				
				eval = new Evaluation(data);
				eval.crossValidateModel(model, data, 10, new Random(1));
				
		} catch(Exception e) {
	        e.printStackTrace();
	    }

	}
	
	/**
	 * Prints the result of the Algorithm RandomForest.
	 *
	 * @return the string
	 * @throws Exception the exception
	 */
	String PrintResult() throws Exception {
		
		String resultado = "Algoritmo RandomForest";
		resultado += "\n";
		resultado += eval.toSummaryString();
		resultado += "\n";		
        
        return resultado;
	}
	
}
