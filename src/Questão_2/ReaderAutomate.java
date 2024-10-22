package Questão_2;

import Questão_3.AutomatoFinitoDeterministico;
import Questão_3.Estado;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReaderAutomate {
    public static void main(String[] args) {
        Set<Questão_3.Estado> estados = new HashSet<>();
        Questão_3.Estado q0 = new Questão_3.Estado("q0");
        Questão_3.Estado q1 = new Questão_3.Estado("q1");
        Questão_3.Estado q2 = new Questão_3.Estado("q2");

        estados.add(q0);
        estados.add(q1);
        estados.add(q2);

        Set<Questão_3.Estado> estadosFinais = new HashSet<>();
        estadosFinais.add(q2);

        Set<Character> alfabeto = new HashSet<>();
        alfabeto.addAll(Arrays.asList('0', '1'));

        Questão_3.AutomatoFinitoDeterministico automato = new AutomatoFinitoDeterministico(estados, alfabeto, q0, estadosFinais);

        automato.definirTransicoes(q0, '0', q1 );
        automato.definirTransicoes(q0, '1', q0 );
        automato.definirTransicoes(q1, '0', q2 );
        automato.definirTransicoes(q1, '1', q0 );
        automato.definirTransicoes(q2, '0', q2 );
        automato.definirTransicoes(q2, '1', q2 );

        automato.verificaCadeira("10100");

    }
}
