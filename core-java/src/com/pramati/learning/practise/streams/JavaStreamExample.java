package com.pramati.learning.practise.streams;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Product {
	int id;
	String name;
	float price;

	public Product(int id, String name, float price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	}

}

public class JavaStreamExample {
	public static void main(String[] args) {
		List<Product> productsList = new ArrayList<Product>();
		productsList.add(new Product(1, "HP Laptop", 25000f));
		productsList.add(new Product(2, "Dell Laptop", 30000f));
		productsList.add(new Product(3, "Lenevo Laptop", 28000f));
		productsList.add(new Product(4, "Sony Laptop", 28000f));
		productsList.add(new Product(5, "Apple Laptop", 90000f));

		System.out.println(productsList);
		Map<String, Float> map = new HashMap<>();
		map = productsList.stream().filter(p -> p.price >= 30000f).collect(Collectors.toMap(p -> p.name, p -> p.price));
		for (Map.Entry<String, Float> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}

		map.forEach((k, v) -> System.out.println(k + " " + v));

		productsList.stream().filter(p -> p.price >= 30000f).forEach(p -> System.out.println(p.name + " " + p.price));
	}

}