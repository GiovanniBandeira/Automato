package Questão_10;

import java.util.*;

public class AutomatoFinitoNaoDeterministico {
    private Set<Estado> estados;
    private Set<Character> alfabeto;
    private Estado estadoInicial;
    private Set<Estado> estadosFinais;
    private Map<Estado, Map<Character, Set<Estado>>> transicoes;

    public AutomatoFinitoNaoDeterministico(Set<Estado> estados, Set<Character> alfabeto, Estado estadoInicial, Set<Estado> estadosFinais) {
        this.alfabeto = alfabeto;
        this.estados = estados;
        this.estadoInicial = estadoInicial;
        this.estadosFinais = estadosFinais;
        this.transicoes = new HashMap<>();

        for (Estado estado : estados) {
            this.transicoes.put(estado, new HashMap<>());
        }
    }

    public void definirTransicoes(Estado estadoOrigem, Character simbolo, Set<Estado> estadoDestino) {
        this.transicoes.get(estadoOrigem).put(simbolo, Collections.unmodifiableSet(estadoDestino));
    }

    public void verificaCadeia(String cadeia) {
        Set<Estado> estadosAtuais = Set.of(this.estadoInicial);

        for (char c : cadeia.toCharArray()) {
            if (!this.alfabeto.contains(c)) {
                throw new IllegalArgumentException("Cadeia inválida");
            }

            Set<Estado> novosEstados = new HashSet<>();
            for (Estado estadoAtual : estadosAtuais) {
                Set<Estado> estadosDestino = this.transicoes.get(estadoAtual).get(c);
                if (estadosDestino != null) {
                    novosEstados.addAll(estadosDestino);
                }
            }
            estadosAtuais = novosEstados;

            if (estadosAtuais.isEmpty()) {
                break;
            }
        }

        for (Estado estadoAtual : estadosAtuais) {
            if (estadosFinais.contains(estadoAtual)) {
                System.out.println("Cadeia Aceita");
                return;
            }
        }
        System.out.println("Cadeia inválida!");
    }
}
