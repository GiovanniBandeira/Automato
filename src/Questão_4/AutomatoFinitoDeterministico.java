package Questão_4;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AutomatoFinitoDeterministico {
    private Set<Estado> estados;
    private Set<Character> alfabeto;
    private Estado estadoInicial;
    private Set<Estado> estadosFinais;
    private Map<Estado, Map<Character, Estado>> transicoes;

    public void definirTransicoes(Estado estadoOrigem, Character simbolo, Estado estadoDestino) {
        this.transicoes.get(estadoOrigem).put(simbolo, estadoDestino);
    }

    public AutomatoFinitoDeterministico(Set<Estado> estados, Set<Character> alfabeto, Estado estadoInicial, Set<Estado> estadosFinais) {
        this.alfabeto = alfabeto;
        this.estados = estados;
        this.estadoInicial = estadoInicial;
        this.estadosFinais = estadosFinais;
        this.transicoes = new HashMap<>();

        for (Estado estado : estados) {
            this.transicoes.put(estado, new HashMap<>());
        }
    }

    public void verificaCadeira(String cadeia) {
        Estado estadoAtual = this.estadoInicial;

        for (char c : cadeia.toCharArray()) {
            if(!this.alfabeto.contains(c)) {
                throw new IllegalArgumentException("Cadeira inválida");
            }

            estadoAtual = transicoes.get(estadoAtual).get(c);
        }
        if(estadosFinais.contains(estadoAtual)) {
            System.out.println("Cadeia Aceita");
        } else {
            System.out.println("Cadeia inválida!");
        }
    }
}

