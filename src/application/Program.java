package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Sale;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		String path = "c:\\temp\\in.csv";
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			
			List<Sale>list = new ArrayList<>();
			String line = br.readLine();
			
			while (line != null) {
				
				String[] fields = line.split(",");
				
				int month = Integer.parseInt(fields[0]);
				int year = Integer.parseInt(fields[1]);
				String seller = fields[2];
				int itens = Integer.parseInt(fields[3]);
				double total = Double.parseDouble(fields[4]);
				
				list.add(new Sale(month, year, seller, itens, total));
				
				line = br.readLine();
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
