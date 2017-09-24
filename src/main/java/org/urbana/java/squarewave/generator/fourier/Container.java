package org.urbana.java.squarewave.generator.fourier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.urbana.java.criteria.generator.Criteria;
import org.urbana.java.criteria.generator.SimpleVariable;
import org.urbana.java.taylor.expansion.TaylorSeries;

public class Container {
	
	Map<String, Integer> variableMap = new HashMap<String, Integer>();
	Map<String, Integer> variableFourierWaveMap = new HashMap<String, Integer>();
	List<Criteria> criteriaList = new ArrayList<Criteria> ();
	
	public void init(List<Criteria> criteriaList){
		this.criteriaList = criteriaList;
		calculateNumberOfIndependentVariables();
	}
	
	private Integer calculateNumberOfIndependentVariables() {
		for (Criteria criteria : criteriaList) {
			for (SimpleVariable simpleVariable : criteria.getVarList()) {
				variableMap.put(simpleVariable.getVariableName(), 1);
			}
		}
		return variableMap.size();
	 }
		
	public void generateFourierSquareWaveForEachVariable(FourierSquareWave fourierSquareWave){
		
		
	}
	
    public void expandSineTermsUsingTaylorSeries(TaylorSeries taylorseries){
		
		
	}
    
    public void combineCriteria(){
    	
    	
    }
    
    public void generatePolynomialEquations() {
    	
    	
    }
	public void solvePolynomialEquations(){
    	
    	
    }
	
  }
