package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
	public static List<Integer> solution(int money) {
		List<Integer> answer = new ArrayList<>();
		
		int[] arr = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
		for (int i = 0; i < arr.length; i++) {
			int count = 0;
			
			count = money / arr[i];
			money %= arr[i];
			
			answer.add(i, count);
		}
		
		return answer;
	}
}
