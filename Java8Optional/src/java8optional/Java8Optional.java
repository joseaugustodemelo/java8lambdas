package java8optional;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Stream;

public class Java8Optional {

	public static void main(String[] args) {
		
		//String s = "Inscreva-se!";
		String s = "1";
		
		//converteEmNumero(s).ifPresent(n -> System.out.println(n));
		
		//converteEmNumero(s).orElse(5);
		
		//converteEmNumero(s).orElseGet(() -> 5);
		
		//converteEmNumero(s).orElseThrow(() -> new NullPointerException("Valor vazio."));
		
		//Stream.of(1, 2, 3).findFirst().ifPresent(n -> System.out.println(n));
		
		//Stream.of(1, 2, 3).findFirst().ifPresent(System.out::println);
		
		int numero = converteEmNumero(s)
				.orElseThrow(() -> new NullPointerException("Valor vazio."));
		
		System.out.println(numero);
	}

	/*private static Optional<Integer> converteEmNumero(String s) {
		try {
			Integer integer = Integer.valueOf(s);
			return Optional.of(integer);
		} catch (Exception e) {
			return Optional.empty();
		}
	}*/
	
	private static OptionalInt converteEmNumero(String s) {
		try {
			int integer = Integer.valueOf(s);
			return OptionalInt.of(integer);
		} catch (Exception e) {
			return OptionalInt.empty();
		}
	}
	
}
