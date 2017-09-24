package org.urbana.java.squarewave.generator.fourier;

import java.math.BigDecimal;
import java.math.BigInteger;

public class SineTerm {

	
	private Integer n;
	private BigDecimal x;
	private BigInteger L;
	private Double constant;
	
	public Integer getN() {
		return n;
	}
	public void setN(Integer n) {
		this.n = n;
	}
	public BigDecimal getX() {
		return x;
	}
	public void setX(BigDecimal x) {
		this.x = x;
	}
	public BigInteger getL() {
		return L;
	}
	public void setL(BigInteger l) {
		L = l;
	}
	public Double getConstant() {
		return constant;
	}
	public void setConstant(Double constant) {
		this.constant = constant;
	}
	public SineTerm(Integer n, BigDecimal x, BigInteger l, Double constant) {
		super();
		this.n = n;
		this.x = x;
		L = l;
		this.constant = constant;
	}
	
	
	
}
