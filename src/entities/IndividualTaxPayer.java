package entities;

public class IndividualTaxPayer extends TaxPayer {

	private Double healthExpenses;

	public IndividualTaxPayer() {
		super();
	}

	public IndividualTaxPayer(String name, Double anualIncome, Double healthExpenses) {
		super(name, anualIncome);
		this.healthExpenses = healthExpenses;
	}

	public Double getHealthExpenses() {
		return healthExpenses;
	}

	public void setHealthExpenses(Double healthExpenses) {
		this.healthExpenses = healthExpenses;
	}

	@Override
	public double taxCalculation() {
		double sum = 0;
		if (getAnualIncome() < 20000) {
			if (healthExpenses > 0) {
				sum += (getAnualIncome() * 25 / 100) - (healthExpenses * 50 / 100);
			} else {
				sum += (getAnualIncome() * 25 / 100);
			}
		} else {
			if (healthExpenses > 0) {
				sum += (getAnualIncome() * 0.25) - (healthExpenses * 0.5);
			} else {
				sum += (getAnualIncome() * 0.25);
			}
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
