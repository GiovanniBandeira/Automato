package Questão_8;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReaderAutomate {
    public static void main(String[] args) {
        Set<Estado> estados = new HashSet<>();
        Estado q0 = new Estado("q0");
        Estado q1 = new Estado("q1");
        Estado q2 = new Estado("q2");
        Estado q3 = new Estado("q3");
        Estado q4 = new Estado("q4");

        estados.add(q0);
        estados.add(q1);
        estados.add(q2);
        estados.add(q3);
        estados.add(q4);

        Set<Estado> estadosFinais = new HashSet<>();
        estadosFinais.add(q2);
        estadosFinais.add(q4);

        Set<Character> alfabeto = new HashSet<>();
        alfabeto.addAll(Arrays.asList('0', '1'));

        AutomatoFinitoDeterministico automato = new AutomatoFinitoDeterministico(estados, alfabeto, q0, estadosFinais);

        automato.definirTransicoes(q0, '0', q3 );
        automato.definirTransicoes(q0, '1', q1 );
        automato.definirTransicoes(q1, '0', q1 );
        automato.definirTransicoes(q1, '1', q2 );
        automato.definirTransicoes(q2, '0', q1 );
        automato.definirTransicoes(q2, '1', q2 );
        automato.definirTransicoes(q3, '0', q4 );
        automato.definirTransicoes(q3, '1', q3 );
        automato.definirTransicoes(q4, '0', q4 );
        automato.definirTransicoes(q4, '1', q3 );

        automato.verificaCadeira("0");
        automato.verificaCadeira("1");
        automato.verificaCadeira("");
        automato.verificaCadeira("101");
        automato.verificaCadeira("010");
        automato.verificaCadeira("0100000");
        automato.verificaCadeira("0000111110101");

    }
}
