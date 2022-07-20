package it.unica.pr2.ristoranti;

import java.util.Map;

public class Ristorante{
	
	private String nomeR;
	private int numP;
	private Menu menuR;
	static int numR;
	static int totPostiR;
	int totOrdini=0;
	
	
	public Ristorante(String nomeR, int numP, Menu menuR) {
		
		this.nomeR=nomeR;
		this.numP=numP;
		this.menuR=menuR;
		numR++;
		totPostiR+=numP;
	}
	
	public static int numeroRistoranti() {
		return numR;
	}
	
	public int posti() {
		return this.numP;
	}
	
	public static int totalePosti() {
		
		return Ristorante.totPostiR;
	}
	
	public Menu menu() {
		return this.menuR;
	}
	
	public String mostExpensive() {
		double costoso=0;
		String piattoC="";
		
		for(Map.Entry<String, Double> entries: menuR.entrySet()) {
				if(entries.getValue() > costoso) {
					costoso=entries.getValue();
					piattoC=entries.getKey();
				}
		}
		return piattoC;
	}
	
	public boolean isInTheMenu(String unNomePiatto) {
		
		for(Map.Entry<String, Double> entries: menuR.entrySet()) {
			
			if(entries.getKey().equals(unNomePiatto)) {
				return true;
			}			
		}
		
		return false;
	}
	
	public Order order(String...ordini) {
		
		double scontrino=0;
		
		
		totOrdini+=ordini.length;
		//System.out.println("totOrdiniPresi: "+totOrdini);
		if(totOrdini > numP) {
			throw new TooMuchPeopleException();
		}
		
		for(String entries: ordini) {
			
			if(menuR.containsKey(entries)) {
				scontrino+=menuR.get(entries);
			}			
		}
		
		
		
		return new Order(ordini.length, scontrino);
	}
}