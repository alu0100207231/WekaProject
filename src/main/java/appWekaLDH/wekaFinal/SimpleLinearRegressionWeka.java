package appWekaLDH.wekaFinal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Random;

import weka.classifiers.Evaluation;
import weka.classifiers.functions.SimpleLinearRegression;
import weka.core.Instances;
import weka.core.converters.ArffLoader;

/**
 * Apply IBk from Weka to the data set
 * @author HilarioJ
 *
 */
public class SimpleLinearRegressionWeka {
	
	private Evaluation eval;
	
	public SimpleLinearRegressionWeka(File file_data) {
		SimpleLinearRegression model;

		try{
			ArffLoader loader = new ArffLoader();
           
			loader.setFile(file_data);
		
			Instances data = new Instances(
				new BufferedReader(
						new FileReader(file_data)));
			data.setClassIndex(data.numAttributes() - 1);
		
		
			model = new SimpleLinearRegression();
			model.buildClassifier(data);
		
			eval = new Evaluation(data);
			eval.crossValidateModel(model, data, 10, new Random(1));
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	String PrintResult() throws Exception {
	
		String resultado = "";
		resultado += "\n";
		resultado += eval.toSummaryString();
		resultado += "\n";

		return resultado;
	}
}