package java8collect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Java8StreamsCollect1 {

	public static void main(String[] args) {

		List<Integer> asList = Arrays.asList(1, 2, 3, 4, 5, 6);

		// Os argumentos são: fornecedor (supplier), acumulação (acumulator), combinação
		// (combiner)
		ArrayList<Integer> colecao = asList.stream().collect(() -> new ArrayList<>(), (l, e) -> l.add(e),
				(l1, l2) -> l1.addAll(l2));
		System.out.println(colecao);

		Set<Integer> colecaoSet = asList.stream().collect(() -> new HashSet<>(), (l, e) -> l.add(e),
				(l1, l2) -> l1.addAll(l2));

		System.out.println(colecaoSet);

		// Collectors mais simples e mais utilizados no dia a dia
		// toList();
		List<Integer> collectToList = asList.stream().collect(Collectors.toList());
		System.out.println(collectToList);

		Set<Integer> collectToSet = asList.stream().collect(Collectors.toSet());
		System.out.println(collectToSet);

		Set<Integer> collectToCollection = asList.stream().collect(Collectors.toCollection(() -> new TreeSet<>()));
		System.out.println(collectToCollection);

		// joining
		String collectJoin = asList.stream().map(n -> n.toString()).collect(Collectors.joining(";"));
		System.out.println(collectJoin);

		// averaging - média aritmética
		Double media = asList.stream().collect(Collectors.averagingInt(n -> n.intValue()));
		System.out.println(media);

		// summing - somatória de todos os valores
		Integer soma = asList.stream().collect(Collectors.summingInt(n -> n.intValue()));
		System.out.println(soma);

		// summarizing - somatória de todos os valores
		IntSummaryStatistics stats = asList.stream().collect(Collectors.summarizingInt(n -> n.intValue()));
		System.out.println("IntSummaryStatisctics:");
		System.out.println(stats.getAverage());
		System.out.println(stats.getCount());
		System.out.println(stats.getMax());
		System.out.println(stats.getMin());
		System.out.println(stats.getSum());

		// counting
		Long count = asList.stream().filter((n) -> n % 2 == 0).collect(Collectors.counting());
		System.out.println(count);

		// maxBy / minBy
		asList.stream().collect(Collectors.maxBy(Comparator.naturalOrder())).ifPresent(System.out::println);

		asList.stream().collect(Collectors.minBy(Comparator.naturalOrder())).ifPresent(System.out::println);

		// groupingBy
		Map<Integer, List<Integer>> groupingBy = asList.stream().collect(Collectors.groupingBy((n) -> n % 3));
		System.out.println(groupingBy);

		// partitionBy
		Map<Boolean, List<Integer>> partitionBy = asList.stream().collect(Collectors.partitioningBy((n) -> n % 3 == 0));
		System.out.println(partitionBy);

		// toMap
		Map<Integer, Integer> toMap = asList.stream().collect(Collectors.toMap(n -> n, n -> n * 2));
		System.out.println(toMap);
	}

}
