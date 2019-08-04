/*
 * https://rinaldo.dev/java-8-streams-pare-de-usar-for-e-simplifique-seu-codigo/
 * */
package java8lambdas;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Java8Streams {

	public static void main(String[] args) {
		List<Integer> lista = Arrays.asList(1, 5, 8, 9, 1, 4, 7, 6, 6, 9, 9);

		// Java *
		// stream = fluxo de dados
		System.out.println("Exemplo de Stream imprimindo a lista completa.");
		lista.stream().forEach(e -> System.out.println(e));

		System.out.println("");
		
		// skip
		System.out.println("Exemplo de Stream com Skip.");
		lista.stream()
			.skip(2) //pula ou ignora os primeiros elementos
			.forEach(e -> System.out.println(e));
		
		System.out.println("");
		
		// limit
		System.out.println("Exemplo de Stream com Limit.");
		lista.stream()
			.limit(2) // limitando a quantidade de elementos
			.forEach(e -> System.out.println(e));
		
		System.out.println("");
		
		// distinct
		System.out.println("Exemplo de Stream com Distinct.");
		lista.stream()
			.distinct() // ignora a repetição, utilizando o equals e hashcode para diferencias os elementos
			.forEach(e -> System.out.println(e));
		
		System.out.println("");
		
		// filter
		System.out.println("Exemplo de Stream com Filter.");
		lista.stream()
			.filter(e -> e % 2 ==0) // filtrando os elementos.
			.forEach(e -> System.out.println(e));
		
		System.out.println("");
		
		// map
		System.out.println("Exemplo de Stream com Map.");
		lista.stream()
			.map(e -> e * 2) // Transformando os elementos. NÃO ALTERA A LISTA ORIGINAL
			.forEach(e -> System.out.println(e));
		
		System.out.println("");
		
		// count
		System.out.println("Exemplo de Stream com Count.");
		long count = lista.stream()
			.filter(e -> e % 2 == 0) 
			.count(); // Método terminal que retorna a contagem de elementos
		System.out.println(count);
		
		System.out.println("");
		
		// min
		System.out.println("Exemplo de Stream com Min.");
		Optional<Integer> min = lista.stream()
			.min(Comparator.naturalOrder()); // Método terminal que retorna Menor elemento
		System.out.println(min.get());
		
		System.out.println("");
		
		// max
		System.out.println("Exemplo de Stream com Max.");
		Optional<Integer> max = lista.stream()
			.max(Comparator.naturalOrder()); // Método terminal que retorna Máximo elemento
		System.out.println(max.get());
		
		System.out.println("");
		
		// collect
		System.out.println("Exemplo de Stream com Collect.");
		List<Integer> novaLista = lista.stream()
			.filter(e -> e % 2 == 0)
			.collect(Collectors.toList()); // Método terminal que retorna um coleção de elementos
		
		System.out.println(novaLista);
		
		System.out.println("");
		
		// collect
		System.out.println("Exemplo de Stream com Collect.");
		Map<Boolean, List<Integer>> mapa = lista.stream()
			.map(e -> e * 3)
			.collect(Collectors.groupingBy(e -> e % 2 == 0)); // Método terminal que retorna um coleção de elementos de forma agrupada
		
		System.out.println(mapa);
		
		// collect
		System.out.println("Exemplo de Stream com Collect.");
		Map<Integer, List<Integer>> mapaInteger = lista.stream()
			.collect(Collectors.groupingBy(e -> e % 2)); // Método terminal que retorna um coleção de elementos de forma agrupada
		
		System.out.println(mapaInteger);
		
		System.out.println("");
		
		// collect
		System.out.println("Exemplo de Stream com Collect.");
		String collect = lista.stream()
			.map(e -> String.valueOf(e))
			.collect(Collectors.joining(";")); // Método terminal que retorna um coleção de elementos de forma agrupada utilizando Strings
		
		System.out.println(collect);
	}

}
