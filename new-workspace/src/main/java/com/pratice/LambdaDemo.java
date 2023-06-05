package com.pratice;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LambdaDemo{
	public static void main(String[] args) {
//		System.out.println(add(3,5));
		
		BiConsumer<Integer,Double> biConsumer = (Integer a,Double b) -> System.out.println(a+b);
		biConsumer.accept(10, 5.0);

		Stream.generate(() -> new Random().nextInt(100))
				.limit(10)
				.collect(Collectors.toList())
				.forEach(System.out::println);

		Integer min = Stream.of(4,2,7,9,3,6,5).min(Comparator.comparingInt(Integer::valueOf)).get().intValue();
		System.out.println("min int is:: " +min);
	}
	
//	public static int add(int a, int b)
//	{
//		int c = a+b;
//		return c;
//	}
}