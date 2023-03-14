package it.polito.tdp.AlienTraslator;

import java.util.*;

public class Traduttore {
	
	TreeMap<String, HashSet<String>> dizionario;
	
	public Traduttore() {
		dizionario = new TreeMap<String, HashSet<String>>();
	}
	
	public void aggiungi(String s, String s1) {
	    HashSet<String> significati = dizionario.get(s);
	    if (significati == null) {
	        significati = new HashSet<String>();
	        dizionario.put(s, significati);
	    }
	    significati.add(s1);

	}

	public String traduci (String s) {
		String significati = "";
		if (dizionario.containsKey(s)){
			for (String p : dizionario.get(s)) {
				significati += p + "\n";
			}
			}
		else {
			significati = "La parola non esiste nel dizionario";
		}
		
		return significati;
		
	}
}
