package java8lambdas;

import java.util.stream.IntStream;

public class FuncoesLambda {

	public static void main(String[] args) {

		// Parẽnteses obrigatórios
		Runnable runnable = () -> System.out.println("Se inscreva no canal!");

		IntStream.range(0, 5).filter((int n) -> n % 2 == 0).reduce((int n1, int n2) -> n1 + n2)
				.ifPresent(System.out::println);

		// Chaves
		IntStream.range(0, 5)
		.filter((int n) -> {
			System.out.println("Se inscreva no canal!");
			return n % 2 == 0;
		}).forEach(System.out::println);
	}
}
