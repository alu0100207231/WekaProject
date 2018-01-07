package appWekaLDH.wekaFinal;
 
 import java.io.File;
 import java.util.Random;
 
 import weka.classifiers.Evaluation;
 import weka.classifiers.rules.ZeroR;
 import weka.core.Instances;
 import weka.core.converters.ArffLoader;
 
 /**
  * Apply ZeroR from weka to the data set
  * @author Miguel Aurelio Garcia Gonzalez
  */
 public class ZeroR_Alg {
 
	/**
	 * The eval.
	 */
 	private Evaluation eval;
 	
 	/**
 	 * class constructor 
 	 * @param file from datasheet
 	 */
 	public ZeroR_Alg(File file_data) {
 		
 			Instances trainIns = null;
 			ZeroR zero;
 			try{
 		           ArffLoader loader = new ArffLoader();
 		           
 		           loader.setFile(file_data);
 		           trainIns = loader.getDataSet();
 		          
 		           
 		           trainIns.setClassIndex(trainIns.numAttributes()-1);
		           
 		           zero = (ZeroR)Class.forName("weka.classifiers.rules.ZeroR").newInstance();
 		           
 		           zero.buildClassifier(trainIns);
 		           
 		           eval = new Evaluation(trainIns);
 		           
 		           eval.crossValidateModel(zero, trainIns, 10, new Random(1));
 		                 
 		} catch(Exception e) {
 	        e.printStackTrace();
 	    }
 
 	}
 	
 	/**
 	 * Prints the result of the Algorithm ZeroR
 	 * @return String
 	 * @throws Exception
 	 */
 	String PrintResult() throws Exception {
 		
 		String resultado = "Algoritmo ZeroR";
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