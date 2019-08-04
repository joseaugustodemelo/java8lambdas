/*
 * https://rinaldo.dev/java-8-streams-pare-de-usar-for-e-simplifique-seu-codigo/
 * */
package java8lambdas;

import java.util.Arrays;
import java.util.List;

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
		
	}

}
