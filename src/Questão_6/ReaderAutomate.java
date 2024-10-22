package Questão_6;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReaderAutomate {
    public static void main(String[] args) {
        Set<Estado> estados = new HashSet<>();
        Estado q0 = new Estado("q0");

        estados.add(q0);

        Set<Estado> estadosFinais = new HashSet<>();
        estadosFinais.add(q0);

        Set<Character> alfabeto = new HashSet<>();
        alfabeto.addAll(Arrays.asList('0', '1'));

        AutomatoFinitoDeterministico automato = new AutomatoFinitoDeterministico(estados, alfabeto, q0, estadosFinais);

        automato.definirTransicoes(q0, '0', q0 );
        automato.definirTransicoes(q0, '1', q0 );

        automato.verificaCadeira("0");
        automato.verificaCadeira("1");
        automato.verificaCadeira("");

    }
}
