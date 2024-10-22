package Questão_9;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReaderAutomate {
    public static void main(String[] args) {

        Set<Character> alfabeto = new HashSet<>();
        alfabeto.addAll(Arrays.asList('0', '1'));

        AutomatoFinitoDeterministico automato = new AutomatoFinitoDeterministico(alfabeto);

        // Testes
        automato.verificaCadeira("");
        automato.verificaCadeira("0");
        automato.verificaCadeira("1");
        automato.verificaCadeira("101");
        automato.verificaCadeira("100");
        automato.verificaCadeira("1010010");
        automato.verificaCadeira("10100");
        automato.verificaCadeira("010010");

    }
}
