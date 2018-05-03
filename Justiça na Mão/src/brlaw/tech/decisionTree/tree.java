package brlaw.tech.decisionTree;
import java.util.List;

public class tree {

private List<branch> branches;	//lista com todos os galhos da árvore
private List<rule> rules; //Lista com todas as regras da árvore
	
public tree(String decisionTree) {
	String[] lines;
	decisionTree= decisionTree.replaceAll("digraph J48 Tree{","");
	decisionTree= decisionTree.replaceAll("}", "");
	lines= decisionTree.split("\n");
	// cria uma lista de linhas de regras
	// cria uma lista de linhas de galhos
	// preenche o objeto branch com os valores retirados da linha de galho ( id do galho e, se for folha, a folha)
	// adiciona na lista de branches
	// preenche o objeto rule com os valores da lista de galhos E do valor da lista de regras
	//adiciona na lista de rules
	
/*	
	// pega a String da árvore de decisão e preenche como conjunto de regras e galhos
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
	*/
	
}

public List<branch> getBranches() {
	return branches;
}

public void setBranches(List<branch> branches) {
	this.branches = branches;
}

public List<rule> getRules() {
	return rules;
}

public void setRules(List<rule> rules) {
	this.rules = rules;
}

}
