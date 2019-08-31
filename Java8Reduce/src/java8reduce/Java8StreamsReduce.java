package java8reduce;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;

public class Java8StreamsReduce {

	public static void main(String[] args) {

		List<Integer> asList = Arrays.asList(1, 2, 3, 4, 5, 6);

		// reduce - soma - Associativa
		Optional<Integer> soma = asList.stream().reduce((n1, n2) -> n1 + n2);
		System.out.println(soma.get());
		Optional<Integer> somaParallel = asList.stream().parallel().reduce((n1, n2) -> n1 + n2);
		System.out.println(somaParallel.get());

		// reduce - multiplicação - Associativa
		Optional<Integer> multiplicacao = asList.stream().reduce((n1, n2) -> n1 * n2);
		System.out.println(multiplicacao.get());
		Optional<Integer> multiplicacaoParallel = asList.stream().parallel().reduce((n1, n2) -> n1 * n2);
		System.out.println(multiplicacaoParallel.get());

		String s = "Inscreva-se no canal e compratilhe esse vídeo.";
		String[] split = s.split(" ");
		List<String> asListStr = Arrays.asList(split);

		// reduce - Concatenação
		Optional<String> concatenacao = asListStr.stream().reduce((s1, s2) -> s1.concat(s2));
		System.out.println(concatenacao.get());
		Optional<String> concatenacaoParallel = asListStr.stream().parallel().reduce((s1, s2) -> s1.concat(s2));
		System.out.println(concatenacaoParallel.get());

		// reduce - subtração - não Associativa - QUANDO EXECUTADO EM PARALELO O
		// RESULTADO PODE VARIAR - Não faça!!!
		Optional<Integer> subtracao = asList.stream().reduce((n1, n2) -> n1 - n2);
		System.out.println(subtracao.get());
		Optional<Integer> subtracaoParallel = asList.stream().parallel().reduce((n1, n2) -> n1 - n2);
		System.out.println(subtracaoParallel.get());

		// reduce - soma com Identidade usa-se 0 - Associativa
		Integer somaIdentidade = asList.stream().reduce(0, (n1, n2) -> n1 + n2);
		System.out.println(somaIdentidade);

		// reduce - multiplicação com Identidade usa-se 1 - Associativa
		Integer multiplicacaoIdentidade = asList.stream().reduce(1, (n1, n2) -> n1 * n2);
		System.out.println(multiplicacaoIdentidade);

		// reduce - Concatenação com identidade usa-se "" string vazia
		String concatenacaoIdentidade = asListStr.stream().reduce("", (s1, s2) -> s1.concat(s2));
		System.out.println(concatenacaoIdentidade);

		// Retornando o próprio valor de identidade
		List<Integer> listaVazia = Arrays.asList();
		Integer somandoListaVazia = listaVazia.stream().reduce(0, (n1, n2) -> n1 + n2);
		System.out.println(somandoListaVazia);

		// reduce - menor valor
		OptionalDouble menorValor = DoubleStream.of(1.5, 2.9, 6.7).reduce((d1, d2) -> Math.min(d1, d2));
		System.out.println(menorValor.getAsDouble());
		double menorValorIdentidade = DoubleStream.of(1.5, 2.9, 6.7).reduce(Double.POSITIVE_INFINITY,
				(d1, d2) -> Math.min(d1, d2));
		System.out.println(menorValorIdentidade);

		// reduce - combinação com SOMA
		Integer combinacao = asList.stream().reduce(0, (n1, n2) -> n1 + n2, (n1, n2) -> n1 + n2);
		System.out.println(combinacao);

		// reduce - map + combinação
		Optional<String> reduceMapCombinacao = asList.stream().map(n1 -> n1.toString()).reduce((n1, n2) -> n1 + n2);
		System.out.println(reduceMapCombinacao);

		// reduce - map + combinação 2
		String reduceMapCombinacao2 = asList.stream().reduce("", (n1, n2) -> n1.toString().concat(n2.toString()),
				(n1, n2) -> n1.concat(n2));
		System.out.println(reduceMapCombinacao2);
	}
}
