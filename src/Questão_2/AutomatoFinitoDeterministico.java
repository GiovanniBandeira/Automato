package Questão_2;

import Questão_3.Estado;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AutomatoFinitoDeterministico {
    private Set<Questão_3.Estado> estados;
    private Set<Character> alfabeto;
    private Questão_3.Estado estadoInicial;
    private Set<Questão_3.Estado> estadosFinais;
    private Map<Questão_3.Estado, Map<Character, Questão_3.Estado>> transicoes;

    public void definirTransicoes(Questão_3.Estado estadoOrigem, Character simbolo, Questão_3.Estado estadoDestino) {
        this.transicoes.get(estadoOrigem).put(simbolo, estadoDestino);
    }

    public AutomatoFinitoDeterministico(Set<Questão_3.Estado> estados, Set<Character> alfabeto, Questão_3.Estado estadoInicial, Set<Questão_3.Estado> estadosFinais) {
        this.alfabeto = alfabeto;
        this.estados = estados;
        this.estadoInicial = estadoInicial;
        this.estadosFinais = estadosFinais;
        this.transicoes = new HashMap<>();

        for (Questão_3.Estado estado : estados) {
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

