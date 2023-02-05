package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.CompanyTaxPayer;
import entities.IndividualTaxPayer;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<TaxPayer> list = new ArrayList<>();

		System.out.println("Enter the number of tax payers:");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Tax payer #" + i + " data: ");
			System.out.println("Individual or company (i/c)? ");
			sc.nextLine();
			char type = sc.nextLine().charAt(0);
			System.out.println("Name:");
			String name = sc.nextLine();
			System.out.println("Anual income:");
			double anualIncome = sc.nextDouble();
			if (type == 'i') {
				System.out.println("Do you have health expenses (y/n)?");
				sc.nextLine();
				char response = sc.nextLine().charAt(0);
				if (response == 'y') {
					System.out.println("Health expenditures:");
					double healthExpenditures = sc.nextDouble();
					list.add(new IndividualTaxPayer(name, anualIncome, healthExpenditures));
				} else {
					list.add(new IndividualTaxPayer(name, anualIncome, 0.0));
				}
			} else {
				System.out.println("Number of employees:");
				int employees = sc.nextInt();
				list.add(new CompanyTaxPayer(name, anualIncome, employees));
			}
		}

		System.out.println();
		System.out.println("TAXES PAID:");
		for (TaxPayer tp : list) {
			System.out.println(tp);
		}

		double sum = 0;
		System.out.println();
		System.out.print("TOTAL TAXES: $");
		for (TaxPayer tp : list) {
			sum += tp.taxCalculation();
		}

		System.out.printf("%.2f",sum);

		sc.close();
	}
}
