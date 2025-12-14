package com.practice;

public class WissenFinalRondFillArea {
	class PaintZone {

		static int row =5

		static int col = 9


		public static void main(String[] args) {
			
		

		int inputArr[][]=	{
							{0,0,0,0,1},
							{0,0,0,1,0},
							{0,0,1,1,0},
							{0,1,1,0,0},
							{1,0,0,0,0},
							{0,0,0,0,0},
							{0,0,0,1,1},
							{0,0,1,1,0},
							{0,1,0,0,0}};
//		WissenInput wissenInput =getWissenInput(inputArr);
//		paintUserZone(inputArr,0,2,wissenInput.row,wissenInput.col);
//		}

//		paintUserZone(int inpputArr[][],int previous, int nextcolor,int r, int c){

		 if(r<0 || r>=row || y<0 || y>=col){
				return ;
		 }
		if(previous != inputArr[r][c] ){
			return;
		}
		 inputArr[r][c]=nextColor;
		 
		 
		 previous = inputArr[r][c];
			
		 paintUserZone(inputArr,r+1,c,previous,nextColor);
		 paintUserZone(inputArr,r-1,c,previous,nextColor);
		 paintUserZone(inputArr,r,c+1,previous,nextColor);
		 paintUserZone(inputArr,r,c-1,previous,nextColor);

		}



		public getWissenInput (){
		int row =0 ;
		int col =0;
		wissenInput.setrow();
		wissen.setCol();
		return wissenInput;
		}
}
