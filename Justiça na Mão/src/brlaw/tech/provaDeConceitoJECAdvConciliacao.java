package brlaw.tech;
/*
 * brlaw.tech
 * @author Eduardo Pacheco
 * prova de conceito sobre a criação de classificador e seu emprego em um novo dataset com J48
 * recomenda ou advogado ou jec ou conciliaçao
 *  
 */
import java.util.Scanner;
import weka.classifiers.trees.J48;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class provaDeConceitoJECAdvConciliacao {

	public static void main(String[] args) throws Exception {
		// abre a base de dados no formato arff
		DataSource ds = new DataSource("src/brlaw/tech/data/ConciliacaoJECouADV.arff");
		Instances trainingSet = ds.getDataSet();
		
		// ler o dataset de treiino
		 System.out.println(trainingSet.toString());
		
		// diz que a classe é o quarto índice do arquivo que foi carregado
		trainingSet.setClassIndex(3);
		
		// vamos usar um algoritmo de árvore, o J48
		J48 classificador = new J48();
		classificador.buildClassifier(trainingSet);
		
		//opções de saída
		// 1. ver gráfico em forma de regra
		//String resultado = classificador.graph();
		//System.out.println(resultado);
		
		// ver gráfico em forma de desenho
		String resultado = classificador.toString();
		System.out.println(resultado);
		
		//cria a instância de teste
		DenseInstance novoCaso = new DenseInstance(4);
		novoCaso.setDataset(trainingSet); //relaciona o training set com o testSet

		Scanner reader = new Scanner(System.in);  // Reading from System.in
		System.out.println("Qual o valor da causa? ");
		int valordacausa = reader.nextInt(); 
		System.out.println("Vc esta muito bravo? ");
		String muitobravo = reader.next(); 
		System.out.println("Vc tem pressa? ");
		String pressa = reader.next(); 
		
		//once finished
		reader.close();
		
		//valores para o caso
		novoCaso.setValue(0,valordacausa);
		novoCaso.setValue(1,muitobravo);
		novoCaso.setValue(2,pressa);
		
		
		//ver quais atributos são possíveis
		System.out.println("classes possíveis: " + novoCaso.classAttribute());
		System.out.println("valores do atributo: " + novoCaso.attribute(2));

	    //classifica a instância	
		double classificacao = classificador.classifyInstance(novoCaso);	
		System.out.println(novoCaso.classAttribute().value((int) classificacao));
		
		double probabilidade[] = classificador.distributionForInstance(novoCaso);
		System.out.println("Probabilidade de ser jec : " +probabilidade[0]);
		System.out.println("Probabilidade de ser Conciliacao : " +probabilidade[1]);
		System.out.println("Probabilidade de ser Advogado : " +probabilidade[2] );
		
	}
}
