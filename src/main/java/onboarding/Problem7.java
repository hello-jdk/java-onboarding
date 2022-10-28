package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		List<String> answer = Collections.emptyList();
		
		List<String> myFriendList = findFriends(user, friends);
		List<List<String>> exceptFriendList = findnoFriends(user, friends);
		
		HashMap<String, Integer> scoreList = new HashMap<>();
		for (List<String> relation : exceptFriendList) {
			if(myFriendList.contains(relation.get(0))){
				scoreList = calculateScore(scoreList, relation.get(1));
			};
			
			if (myFriendList.contains(relation.get(1))) {
				scoreList = calculateScore(scoreList, relation.get(0));
			}
		}
		
		return answer;
	}
	
	private static HashMap<String, Integer> calculateScore(HashMap<String, Integer> scoreList, String s) {
		boolean flag = scoreList.containsKey(s);
		if(!flag){
			scoreList.put(s, 10);
		}else{
			int beforeScore = scoreList.get(s);
			scoreList.put(s, beforeScore + 10);
		}
		return scoreList;
	}
	
	private static List<List<String>> findnoFriends(String user, List<List<String>> friends) {
		List<List<String>> exceptFriendList = new ArrayList<>();
		
		for (List<String> relationship : friends) {
			if (!relationship.get(0).equals(user) && !relationship.get(1).equals(user)) {
				exceptFriendList.add(relationship);
			}
		}
		
		return exceptFriendList;
	}
	
	private static List<String> findFriends(String user, List<List<String>> friends) {
		
		List<String> myFriendList = new ArrayList<>();
		
		for (List<String> relationship : friends) {
			if (relationship.get(0).equals(user)) {
				myFriendList.add(relationship.get(1));
			} else if (relationship.get(1).equals(user)) {
				myFriendList.add(relationship.get(0));
			}
		}
		
		return myFriendList;
	}
}
