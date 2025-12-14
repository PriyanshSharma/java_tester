package com.anujbhaiyaquestions;

public class MatrixPathFinder {

	public static void main(String[] args) {
		int mat[][] = {{1,2,3},{3,4,5},{45,221,435},{11,44,55}};
		int row =3,col=3;
		
		int allpaths = calculatePossiblePaths(row-1,col-1); // zero based indexing for rows and columns
		
		System.out.println(allpaths);
	}

	private static int calculatePossiblePaths(int i, int j) {

		int result = 1;
		if(i==0 || j==0) {
		return result;
	}
		
		
		return calculatePossiblePaths(i-1, j) + calculatePossiblePaths(i, j-1);
	}
}
