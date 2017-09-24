package org.urbana.java.criteria.generator;

public class Variable {
	
	private Variable variable1;
	private Variable variable2;
	private Operand operand;
	
	public Variable getVariable1() {
		return variable1;
	}
	public void setVariable1(Variable variable1) {
		this.variable1 = variable1;
	}
	public Variable getVariable2() {
		return variable2;
	}
	public void setVariable2(Variable variable2) {
		this.variable2 = variable2;
	}
	public Operand getOperand() {
		return operand;
	}
	public void setOperand(Operand operand) {
		this.operand = operand;
	}
	public Variable() {
	// TODO Auto-generated constructor stub
	}
	
	public Variable(Variable variable1, Variable variable2, Operand operand) {
		super();
		this.variable1 = variable1;
		this.variable2 = variable2;
		this.operand = operand;
	}
	
    
	
	
}
