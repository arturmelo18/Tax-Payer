package entities;

public class CompanyTaxPayer extends TaxPayer {

	private Integer employees;

	public CompanyTaxPayer() {
		super();
	}

	public CompanyTaxPayer(String name, Double anualIncome, Integer employees) {
		super(name, anualIncome);
		this.employees = employees;
	}

	public Integer getEmployees() {
		return employees;
	}

	public void setEmployees(Integer employees) {
		this.employees = employees;
	}

	@Override
	public double taxCalculation() {
		double sum = 0;
		if (employees <= 10) {
			sum += (getAnualIncome() * 0.16);
		} else {
			sum += (getAnualIncome() * 0.14);
		}
		return sum;
	}
	
	@Override
	public String toString() {
		return getName()
			   + "$ "
		       + String.format("%.2f", taxCalculation());
	}
}
