package it.polito.tdp.AlienTraslator;

import java.util.*;

public class Traduttore {
    private final TreeMap<String, HashSet<String>> dizionario;

    public Traduttore() {
        dizionario = new TreeMap<>();
    }

    public void aggiungi(String s, String s1) {
        dizionario.computeIfAbsent(s, k -> new HashSet<>()).add(s1);
    }

    public String traduci(String s) {
        StringBuilder significati = new StringBuilder();
        HashSet<String> set = dizionario.get(s);
        if (set != null) {
            for (String p : set) {
                significati.append(p).append("\n");
            }
        } else {
            significati.append("La parola non esiste nel dizionario");
        }
        return significati.toString();
    }
}
