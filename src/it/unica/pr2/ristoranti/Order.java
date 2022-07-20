package it.unica.pr2.ristoranti;

public class Order{
	
	private int p;  
	
	private double c;
	
	public Order(int p,  double c) {
		this.p=p;
		this.c=c;
	}
	public int people() {
		return p;
	}
	
	
	public double cost() {
		return c;
	}
}