package brlaw.tech.decisionTree;

import java.util.List;
import java.util.Scanner;

public class treeReader {
	
	public treeReader(){
		
	}
	
	public String getClaim(tree arv) {
		Scanner scan = new Scanner(System.in);  
		List<branch> branches = arv.getBranches();
		List<rule> rules = arv.getRules();
		String tempLeaf = "";
		branch tempBranch;
		rule tempRule;
		
		for(int i=0; i<branches.size();) {
			tempBranch = branches.get(i);
			tempLeaf = tempBranch.getLeaf() ; 
			if(tempLeaf == null) {//não é folha, verifica qual a pergunta e regra
				System.out.println(tempBranch.getSplitter()+"?");
				String answer = scan.next();
				for(int f=0; f<rules.size();f++) {//percorre array de regras
					tempRule = rules.get(f);
					if(tempRule.getFromBranch() == tempBranch.getBranch() ) {//se a regra q estou analisando tiver fromBranch igual à ID do branch
						switch(tempRule.getOperation()) {//comparar o resultado do answer com o value do branch
						case "=":
							if(tempRule.getValue().equals(answer)) {
								i = tempRule.getToBranch();
								f = rules.size();
							}
							//System.out.println(tempRule.getOperation()+ tempRule.getValue()+ tempRule.getVariable()+tempRule.getFromBranch()+tempRule.getToBranch()+tempBranch.getSplitter()+tempBranch.getBranch());
							break;
						case "<=":
							if(Integer.parseInt(answer) <= Integer.parseInt(tempRule.getValue())) {
								i = tempRule.getToBranch();
								f = rules.size();
							}
							break;
						case ">=":
							if(Integer.parseInt(answer) >= Integer.parseInt(tempRule.getValue())) {
								i = tempRule.getToBranch();
								f = rules.size();
							}
							break;
						case ">":
							if(Integer.parseInt(answer) > Integer.parseInt(tempRule.getValue())) {
								i = tempRule.getToBranch();
								f = rules.size();
							}
							break;
						case "<":
							if(Integer.parseInt(answer) < Integer.parseInt(tempRule.getValue())) {
								i = tempRule.getToBranch();
								f = rules.size();
							}
							break;
						default:
							System.out.println("deu problema no case");
						}
							
					}
				}
			}
			
			else{// é folha, informa ao usuário qual o tipo de pedido ele vai receber
				tempLeaf = branches.get(i).getLeaf();
				i = branches.size();
			}
		}
		return tempLeaf; 
		
	}	
}
