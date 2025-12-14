package com.anujbhaiyaquestions;

public class JosePheusProblem {
	
	public static void main(String[] args) {
		
		int person =5,gun =3;
		
		int result = calcJose(person,gun);
		System.out.println(result);
	}

	private static int calcJose(int person, int gun) {
		if(person==1) {
			return 0;
		}
		return ((calcJose(person-1, gun)+gun)%person);
	}
}
