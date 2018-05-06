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
import brlaw.tech.decisionTree.*;

public class pocArvoreJECAdvConciliacao {

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
		String resultado = classificador.graph();
		System.out.println(resultado);
		tree arv = new tree(resultado);
		treeReader reader = new treeReader();
		String pedido = reader.getClaim(arv);
		System.out.println(pedido);
/*


digraph J48Tree {
N0 [label="valordacausa" ]  a primeira pergunta é valor da causa
N0->N1 [label="<= 19000"] e se o valor da primeira pergunta for menor ou igual a 19000 vá para N1
N1 [label="muitobravo" ] a segunda é sobre muito bravo
N1->N2 [label="= sim"] Vai para N2 se a resposta for sim
N2 [label="jec (2.0)" shape=box style=filled ] N2 diz que a classe é JEC
N1->N3 [label="= nao"] Vai para N3 se a resposta de muitobravo for nao
N3 [label="conciliacao (3.0)" shape=box style=filled ] N3 diz que a classe é conciliacao
N0->N4 [label="> 19000"] SE o valor da primeira pergunta for maior que 19000 vá para N4
N4 [label="advogado (3.0)" shape=box style=filled ] N4 diz que a classe é advogado
}



 * 	
 */
		
		
		
		
	}
}
