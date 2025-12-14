package bt.codingInterviewQuestions;

import java.util.Arrays;
import java.util.List;

public class DistributeEquallyMorganStanley {

	public static void main(String[] args) {
		List<Integer> l = Arrays.asList(5,10,15,20,	5);
		int evenCout=0;
		for(int s :l) {
			if(s%2!=0) {
				evenCout++;
			}
		}
		System.out.println(evenCout);
	}
}
