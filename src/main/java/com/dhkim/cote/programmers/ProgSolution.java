package com.dhkim.cote.programmers;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class ProgSolution {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("test start.");
		String result;
		String[] participant = {"mislav", "stanko", "mislav", "ana"};
		String[] completion = {"stanko", "ana", "mislav"};
		
		result = hash_1_solution(participant, completion);
		System.out.println("#### " + result + " ####");
	}

	
	/*
	 * 프로그래머스 해쉬 활용 1번
	 * 완주하지 못한 선수
	 * 21.10.23 19:14
	 */
	
	/*	Question
		수많은 마라톤 선수들이 마라톤에 참여하였습니다. 
		단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
		마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 
		완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
	 */
	
	/*	Restrinctions
	 	마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
		completion의 길이는 participant의 길이보다 1 작습니다.
		참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
		참가자 중에는 동명이인이 있을 수 있습니다.
	 */
	public static String hash_1_solution(String[] participant, String[] completion) {
		String answer = "";
		Map<String, Integer> runners_result = new HashMap<String, Integer>();
		for(String runner : participant) {
			if(runners_result.get(runner) == null) {
				runners_result.put(runner, 1);
			}else {
				runners_result.put(runner, ((Integer)runners_result.get(runner)) + 1);
			}
		}
		for(String completion_runner : completion) {
			int runner_status = (Integer)runners_result.get(completion_runner);
			runners_result.put(completion_runner, runner_status - 1);
		}
		Set<Entry<String, Integer>> entrySet = runners_result.entrySet();
		for (Entry<String, Integer> entry : entrySet) {
			if (entry.getValue() >= 1) {
				answer = entry.getKey();
				return answer;
			}
		}
		return answer;
	}
	
	public static boolean hash_2_solution(String[] phone_book) {
		boolean answer = true;
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (String number : phone_book) {
			map.put(number, 0);
		}
		for (String number : phone_book) {
			for (int i = 0; i < number.length(); i++) {
				if (map.containsKey(number.substring(0, i)))
					return false;
			}
		}
		return answer;
	}
	
	public static boolean hash_3_solution(String[] phone_book) {
		boolean answer = true;
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (String number : phone_book) {
			map.put(number, 0);
		}
		for (String number : phone_book) {
			for (int i = 0; i < number.length(); i++) {
				if (map.containsKey(number.substring(0, i)))
					return false;
			}
		}
		return answer;
	}
}
