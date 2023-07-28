package Smooth_Sailing;

import java.util.Arrays;
import java.util.HashSet;

public class hashset {
	public static void main(String[] args) {
		//집합 set의 성지를 갖는 HashSet
		HashSet<Integer> set1 = new HashSet<Integer>();//HashSet생성
		HashSet<Integer> set2 = new HashSet<>();//new에서 타입 파라미터 생략가능
		HashSet<Integer> set3 = new HashSet<Integer>(set1);//set1의 모든 값을 가진 HashSet생성
		HashSet<Integer> set4 = new HashSet<Integer>(10);//초기 용량(capacity)지정
		HashSet<Integer> set5 = new HashSet<Integer>(10, 0.7f);//초기 capacity,load factor지정
		HashSet<Integer> set6 = new HashSet<Integer>(Arrays.asList(1,2,3));//초기값 지정
		
		set1.add(1);
		System.out.println(set1.contains(1));
		System.out.println(set6.contains(4));
	}

}
