package com.designPatterns.creational.factory;

public class TaxCalculator {

	public static Double taxCalc (TaxRegime taxRegime, SalaryDetails salryDetails) {
		
		switch (taxRegime) {
		
		case OLD: {
			
				return 0.4*salryDetails.getBaseSal() + 0.3 * salryDetails.getHra();
				
		}
		
		case NEW : {
					return 0.4*salryDetails.getBaseSal() + 0.3*salryDetails.getHra() + 0.2* salryDetails.getLta();
				
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + taxRegime);
		}
	}
}
