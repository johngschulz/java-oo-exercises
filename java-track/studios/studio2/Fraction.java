package studio2;

public class Fraction {
	private Integer numerator;
	private Integer denominator;
	
	public Fraction(Integer numerator, Integer denominator){
		this.numerator = numerator;
		this.denominator = denominator;
	}
	public Integer getNumerator(){
		return this.numerator;
	}
	public Integer getDenominator(){
		return this.denominator;
	}
	public Fraction add(Fraction otherFraction){
		Integer newNumerator = this.numerator * otherFraction.getDenominator();
		Integer newDenominator = this.denominator * otherFraction.getDenominator();
		newNumerator = newNumerator + (otherFraction.getNumerator() * this.denominator);
		Fraction newFraction = new Fraction(newNumerator, newDenominator);
		return newFraction;
		
	}

	public Fraction multiply(Fraction otherFraction){
		Integer newNumerator = this.numerator * otherFraction.getNumerator();
		Integer newDenominator = this.denominator * otherFraction.getDenominator();
		Fraction newFraction = new Fraction(newNumerator, newDenominator);
		return newFraction;
	}
	public Fraction reciprocal(){
		Integer newNumerator = this.denominator;
		Integer newDenominator = this.numerator;
		Fraction newFraction = new Fraction(newNumerator, newDenominator);
		return (newFraction);
	}
/*
	public Fraction simplify(){
		Integer newNumerator = this.numerator;
		Integer newDenominator = this.denominator;
		boolean isFactored = false;
		while (isFactored == false){
			
		}

	}
*/
	public String toString(){
		return this.numerator + "/" + this.denominator;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Fraction myFraction = new Fraction(3, 4);
	Fraction yourFraction = new Fraction(4,3);
	System.out.println(myFraction);
	System.out.println(myFraction.add(yourFraction));
	System.out.println(myFraction.multiply(yourFraction));
	System.out.println(myFraction.reciprocal());
	}

}
