package java8DebugLambda;

import java.util.Arrays;
import java.util.List;

public class Java8DebugLambda {

	public static void main(String[] args) {
		List<Integer> asList = Arrays.asList(1, 2, 3, 5, 8, 9);

		asList.stream()
		.peek(n -> System.out.println(n + "Feito para debugar!"))
		.map((n) -> converteParaStringBuilder(n)).forEach(System.out::println);
	}

	private static StringBuilder converteParaStringBuilder(Integer n) {
		StringBuilder builder = new StringBuilder();
		builder.append(n);
		builder.append("s");
		builder.append("a");
		return builder;
	}
}
