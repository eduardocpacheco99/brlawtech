package brlaw.tech.decisionTree;
import java.util.ArrayList;
import java.util.List;

public class tree {

public List<branch> branches = new ArrayList<branch>();	//lista com todos os galhos da árvore
public List<rule> rules = new ArrayList<rule>(); //Lista com todas as regras da árvore
	
public tree(String decisionTree) {
	String[] lines;
	decisionTree= decisionTree.replace("digraph J48Tree {","");
	decisionTree= decisionTree.replace("}", "");
	decisionTree= decisionTree.replace("\"", "");
	lines= decisionTree.split("\n");
	branch b;
	rule r;
	System.out.println(lines[0]+"temos " + lines.length +" linhas");
	String branchId;
	String leaf;
	String fromBranch;
	String toBranch;
	String variable;
	String operation;
	String value;
	String splitter;
	
	// cria uma lista de linhas de regras
	String[] rulelines;
	
	// cria uma lista de linhas de galhos
	String[] branchlines;
	//preenche linha de regras e linha de galhos
	
	for(int i=0;i<lines.length;i++) {
		r = new rule();
		b = new branch();
		if(lines[i].contains("label=") && !lines[i].contains("->") && !lines[i].contains("shape")) {
			//então é pergunta
			branchId = lines[i].substring(1,lines[i].indexOf(" ["));
			splitter = lines[i].substring( lines[i].indexOf("label=")+6, lines[i].indexOf("]"));

			b.setBranch(Integer.parseInt(branchId));
			b.setLeaf(null);
			b.setSplitter(splitter);
			branches.add(b);

		} else if(lines[i].contains("label=") && lines[i].contains("->")) {
			//então é regra
			fromBranch = lines[i].substring(1, lines[i].indexOf("-"));
			toBranch = lines[i].substring( lines[i].indexOf(">N")+2, lines[i].indexOf(" ["));
			value = lines[i].substring( lines[i].indexOf("label=")+6, lines[i].indexOf("]"));
			
			r.setFromBranch(Integer.parseInt(fromBranch));
			r.setToBranch(Integer.parseInt(toBranch));
			r.setOperation(value.split(" ")[0]);
			r.setValue(value.split(" ")[1]);
			rules.add(r);

		} else if (lines[i].contains("shape")) {
			//então é ramo de folha
			branchId = lines[i].substring(1,lines[i].indexOf(" ["));
			leaf = lines[i].substring( lines[i].indexOf("label=")+6, lines[i].indexOf(" ("));
		
			b.setBranch(Integer.parseInt(branchId));
			b.setLeaf(leaf);
			b.setSplitter(null);
			branches.add(b);
		}
		
	}
	
	for(rule r1: rules) {
		for(branch b1 : branches) {
			if(r1.getFromBranch()==b1.getBranch() && b1.getSplitter() != null) {
				r1.setVariable(b1.getSplitter());
			}
		}
		
		
		
	}
	System.out.println("Imprimindo todas as regras ");
	for (rule r1: rules) {
	System.out.println("Origem " + r1.getFromBranch() + "| destino "+ r1.getToBranch()+ "| "+ " variavel " + r1.getVariable() +" | operação " + r1.getOperation()+" | valor " + r1.getValue());	
	}
	System.out.println("Imprimindo todos os ramos");
	for (branch b1 : branches) {
		System.out.println("Ramo " + b1.getBranch() + " | folha " + b1.getLeaf() + " | condição" + b1.getSplitter());
	}
	
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
