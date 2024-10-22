package Questão_10;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ReaderAutomate {
    public static void main(String[] args) {
        Set<Estado> estados = new HashSet<>();
        Estado q0 = new Estado("q0");
        Estado q1 = new Estado("q1");
        Estado q2 = new Estado("q2");
        Estado q3 = new Estado("q3");

        estados.add(q0);
        estados.add(q1);
        estados.add(q2);
        estados.add(q3);

        Set<Estado> estadosFinais = new HashSet<>();
        estadosFinais.add(q3);

        Set<Character> alfabeto = new HashSet<>();
        alfabeto.addAll(Arrays.asList('0', '1'));

        AutomatoFinitoNaoDeterministico automato = new AutomatoFinitoNaoDeterministico(estados, alfabeto, q0, estadosFinais);

        automato.definirTransicoes(q0, '0', Set.of(q0));
        automato.definirTransicoes(q0, '1', Set.of(q0, q1));
        automato.definirTransicoes(q1, '0', Set.of(q2));
        automato.definirTransicoes(q1, '1', Set.of(q2));
        automato.definirTransicoes(q2, '0', Set.of(q3));
        automato.definirTransicoes(q2, '1', Set.of(q3));

        automato.verificaCadeia("1");
        automato.verificaCadeia("0");
        automato.verificaCadeia("10");
        automato.verificaCadeia("101");
        automato.verificaCadeia("0101010");
        automato.verificaCadeia("0111110");
        automato.verificaCadeia("1010100");

    }
}
