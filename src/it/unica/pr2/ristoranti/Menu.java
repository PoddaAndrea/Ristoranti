package it.unica.pr2.ristoranti;
import java.util.HashMap;
import java.util.Map;

public class Menu extends HashMap<String, Double>{
	
	public Menu() {
		
	}
	
	
	public String mostExpensive() {
		double costoso=0;
		String piattoC="";
		
		for(Map.Entry<String, Double> entries: this.entrySet()) {
			
			if(entries.getValue() > costoso) {
				costoso=entries.getValue();
				piattoC=entries.getKey();
				
			}
			
		}
		return piattoC;
	}
}