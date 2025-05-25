package newPackage;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductFilterExample {
	public static void main(String[] args) {

		// Step 1: Create a list of products
		List<Product> products = Arrays.asList(new Product("Laptop", 1200), new Product("Pen", 15),
				new Product("Book", 250), new Product("Phone", 800), new Product("Notebook", 60));

//		// Step 2: Define a Predicate (condition) -> Price > 100
//		Predicate<Product> priceGreaterThan100 = product -> product.getPrice() > 100;
//
//		// Step 3: Define a Consumer (action) -> Print the product name
//		Consumer<Product> printProductName = product -> System.out.println(product.getName());
//
//		// Step 4: Stream through the list
//		products.stream().filter(priceGreaterThan100) // Use Predicate
//				.forEach(printProductName); // Use Consumer

		List<Product> pr = products.stream().filter(p -> p.getPrice() > 100).collect(Collectors.toList());

		// products2.forEach(product -> System.out.println(product.getName() + " - " +
		// product.getPrice()));

		// System.out.println(products2.toString());

		for (Product p : pr)
		{
			System.out.println(p.getName() + " - " + p.getPrice());
		}
	}
}

// Product class
class Product {
	private String name;
	private int price;

	public Product(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	// ✅ Add this to make printing readable
	@Override
	public String toString() {
		return "Product{name='" + name + "', price=" + price + "}";
	}
}
