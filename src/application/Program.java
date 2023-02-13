package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

import model.entities.Sale;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		String path = sc.next();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			
			List<Sale> list = new ArrayList<>();
			Sale sale;
			String line = br.readLine();
			
			while (line != null) {
				
				String[] fields = line.split(",");
				
				int month = Integer.parseInt(fields[0]);
				int year = Integer.parseInt(fields[1]);
				String seller = fields[2];
				int itens = Integer.parseInt(fields[3]);
				double total = Double.parseDouble(fields[4]);
				
				list.add(new Sale(seller, total));
				
				line = br.readLine();
				
			}			
			
			Map<String, Double> totalSales = new TreeMap<>(
						list.stream().collect(
						Collectors.groupingBy(Sale::getSeller, Collectors.summingDouble(Sale::getTotal))));

			totalSales.entrySet().forEach(p -> System.out.println(p.getKey() + ", " + p.getValue()));

			
		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
		}

		
	}

}
