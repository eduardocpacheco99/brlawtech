package brlaw.tech.decisionTree;

public class rule {

	private int fromBranch;
	private int toBranch;
	private String variable;
	private String operation;
	private String value;
	
	public rule() {
	
	}

	public int getFromBranch() {
		return fromBranch;
	}

	public void setFromBranch(int fromBranch) {
		this.fromBranch = fromBranch;
	}

	public int getToBranch() {
		return toBranch;
	}

	public void setToBranch(int toBranch) {
		this.toBranch = toBranch;
	}

	public String getVariable() {
		return variable;
	}

	public void setVariable(String variable) {
		this.variable = variable;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
