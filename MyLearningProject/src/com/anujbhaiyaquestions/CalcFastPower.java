package com.anujbhaiyaquestions;



// I want to calculate fast power and large number - 504890^5 like that
public class CalcFastPower {

	public static void main(String[] args) {
		
		int input=2;
		int power=34;
		int mod = (int) (Math.pow(10, 9)+7);
		
		System.out.println(calcFastpower(input,power)); // this wont work for 2^34 as the value will over flow. 
//		thus for that we have to do modulu operation
		System.out.println(calcFastpower(input, power, mod));
		
		
	}

	private static int calcFastpower(int input, int power, int mod) {
		long result = 1;
		if(power==0) {
			return (int)result;
		}
		
		
		while(power>0) {
			
			if((power&1)!=0) {
				result = (result%mod *input%mod)%mod;
			}
			
			input=(input%mod*input%mod)%mod;
			power = power>>1;
		}
		
		return (int)result;
		
	}

	private static int calcFastpower(int input, int power) {
		int result = 1;
		if(power==0) {
			return result;
		}
		
		
		while(power>0) {
			
			if((power&1)!=0) {
				result = result *input;
			}
			
			input=input*input;
			power = power>>1;
		}
		
		return result;
	}
}
