package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import entities.Product;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		ArrayList<Product> products = new ArrayList<>();
		String path = "C:\\Users\\thiag\\Documents\\Udemy\\Java 2020 Completo\\ws-eclipse\\exercicio_file_io\\out\\summary.csv";
		// C:\\Users\\thiag\\Documents\\Udemy\\Java 2020
		// Completo\\ws-eclipse\\exercicio_file_io\\out\\summary.csv
		/*
		 * TV LED,1290.99,1 Video Game Chair,350.50,3 Iphone X,900.00,2 Samsung Galaxy
		 * 9,850.00,2
		 */
		Product product1 = new Product("TV LED", 1290.99, 1);
		Product product2 = new Product("Iphone X", 900.00, 2);
		Product product3 = new Product("Samsung Galaxy 9", 850.00, 2);
		products.add(product1);
		products.add(product2);
		products.add(product3);

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
			for (Product product : products) {
				bw.write(product.getProductName() + "," + String.format("%.2f", product.total()));
				bw.newLine();
			}
			System.out.println("CREATED FILE summary.csv with Sucess");
		} catch (IOException e) {
			System.out.println("Falha ao escrever o arquivo!!!");
			e.printStackTrace();
		} finally {
			sc.close();
		}
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
