package Questão_9;

import java.util.Set;

public class AutomatoFinitoDeterministico {
    private Set<Character> alfabeto;

    public AutomatoFinitoDeterministico(Set<Character> alfabeto) {
        this.alfabeto = alfabeto;
    }

    public void verificaCadeira(String cadeia) {

        int zero = 0;
        int um = 0;

        for (char c : cadeia.toCharArray()) {

            if(!this.alfabeto.contains(c)) {
                throw new IllegalArgumentException("Cadeira inválida");
            } else if(c == '1'){
                um += 1;
            } else{
                zero += 1;
            }

        }
        if(um < zero) {
            System.out.println("Cadeia Aceita");
        } else {
            System.out.println("Cadeia inválida!");
        }
    }
}