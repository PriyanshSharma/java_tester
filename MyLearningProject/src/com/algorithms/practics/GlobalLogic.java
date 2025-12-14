package com.algorithms.practics;



import java.util.Arrays;
public class GlobalLogic {
	public static void main (String [] args){
		int[] arr = {1, 19, -4, 31, 38, 25, 100};

		Arrays.sort(arr);
		int minDifference = Integer.MAX_VALUE;
		for(int i =0 ; i < arr.length-1 ; i ++){
			int temp = arr[i+1]-arr[i];
			if(temp<minDifference){
				minDifference = temp;
			}


		}
		System.out.println(minDifference);
	}
	
}



class MyThread extends Thread
{
public void run()
{
System.out.println("Running");
}
}
class ThreadTest {

}


class OrderInit {



	static TestOrder obj1 = new TestOrder(1);
	TestOrder obj2 = new TestOrder(10);
	public OrderInit(){
		System.out.println("OrderInit");
	}
}



class SubOrder extends OrderInit {
	static TestOrder obj3 = new TestOrder(20);
	SubOrder(){
		System.out.println("Suborder ");
	}

}
class TestOrder {
	TestOrder ( int i){
		System.out.println("Test Order " +i);
	}
}






	
	
	//// empid,managerid,name
	//100 ,200,johny
	//200 300, nacny
	//}
	
	
	

	
	
	
	