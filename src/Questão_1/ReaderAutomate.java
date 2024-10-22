package Questão_1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReaderAutomate {
    public static void main(String[] args) {
        Set<Estado> estados = new HashSet<>();
        Estado q0 = new Estado("q0");
        Estado q1 = new Estado("q1");

        estados.add(q0);
        estados.add(q1);

        Set<Estado> estadosFinais = new HashSet<>();
        estadosFinais.add(q1);

        Set<Character> alfabeto = new HashSet<>();
        alfabeto.addAll(Arrays.asList('0', '1'));

        AutomatoFinitoDeterministico automato = new AutomatoFinitoDeterministico(estados, alfabeto, q0, estadosFinais);

        automato.definirTransicoes(q0, '0', q0 );
        automato.definirTransicoes(q0, '1', q1 );
        automato.definirTransicoes(q1, '0', q1 );
        automato.definirTransicoes(q1, '1', q1 );

        automato.verificaCadeira("0000");

    }
}
