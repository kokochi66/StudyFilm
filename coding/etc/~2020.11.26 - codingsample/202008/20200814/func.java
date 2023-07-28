package Smooth_Sailing;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.stream.IntStream;

public class func {
	String[] allLongestStrings(String[] inputArray) {
		String output="";
		int max=0;
		for(String s : inputArray) {
			if(max<s.length()) {
				max=s.length();
				output=s+"-";
			}
			else if(max==s.length()) output+=s+"-";
		}
		return output.split("-");
	}
//	나의 답안
	String[] allLongestStrings2(String[] inputArray) {
	    return Arrays.stream(inputArray)
	        .filter(i->i.length()==IntStream.range(0,inputArray.length).map(j->inputArray[j].length())
	        .max().getAsInt()).toArray(String[]::new);}
//	스트림을 이용한 모범답안1
	String[] allLongestStrings3(String arr[]) {
	    int max_len = Arrays.stream(arr).max(Comparator.comparingInt(String::length)).get().length();
	    return Arrays.stream(arr).filter(x -> x.length() == max_len).toArray(String[]::new);
	}
// 비교기(Comparator)를 이요한 모범답안2
// 상세 설명은 Stream.java에서 서술	
	
	int commonCharacterCount(String s1, String s2) {
	    int[] a = new int[26], 
	            b = new int[26];
	        for (char c: s1.toCharArray())
	            a[c - 'a']++;
	        for (char c: s2.toCharArray())
	            b[c - 'a']++;
	        int s = 0;
	        for (int i = 0; i < 26; ++i) 
	            s +=Math.min(a[i],b[i]);
	        return s;
	}
//c-'a'라는 구문을 통해 알파벳의 개수를 저장하는 배열을 통해 알파벳 공통개수를 확인하는 함수를 만듦
	int commonCharacterCount2(String s1, String s2) {
	    int counter = 0;
	    for(int i = 0; i < s1.length(); i++){
	        if(s2.contains(String.valueOf(s1.charAt(i)))){
	            counter++;
	            s2 = s2.replaceFirst(String.valueOf(s1.charAt(i)), "");
	        }
	    }
	    return counter;
	}
//일반적인 함수를 사용한 방법.
//String에서 특정 String을 갖고있는지 조사하는 contains
//char를 String으로 변환하는 String.valueOf으로 contain에 집어넣음
//String에서 원하는 해당 원소값을 두번쨰 인자값으로 대체하는 replaceFirst
	int commonCharacterCount3(String s1, String s2) {
	    Object[] a = new HashSet<String>(Arrays.asList(s1.split(""))).toArray();
	    return IntStream.range(0,a.length).map(i->Math.min(
	           (int)Arrays.stream(s1.split("")).filter(x->x.equals(a[i].toString())).count(),
	           (int)Arrays.stream(s2.split("")).filter(x->x.equals(a[i].toString())).count())).sum();}
//복잡해보이지만, 집합을 이용하는 Hashset에 s1요소를 넣어두고,
//IntStream-> range 반복에 map, Math.min을 통해 집합에 있는 값과 일치하는 값들의 개수(count)의 합 sum을 구하는 식을 이루고있다.
//파이썬에서 이용한 공식을 자바 Hashset을 이용해 구현함.
	boolean isLucky(int n) {
		String a = String.valueOf(n);
		return IntStream.range((a.length()/2),a.length()).map(i->Integer.parseInt(String.valueOf(a.charAt(i)))).sum() == IntStream.range(0,(a.length())/2).map(i->Integer.parseInt(String.valueOf(a.charAt(i)))).sum();
	}
	int[] sortByHeight(int[] a) {
		int[] out = new int[a.length];
		int outNum=0;
		for(int s: a) {
			if(s!=-1) {
				out[outNum]=s;
				outNum++;
			}
		}
		Arrays.parallelSort(out);
		outNum=out.length-outNum;
		for(int i =0;i<a.length;i++) {
			if(a[i]!=-1) {
				a[i]=out[outNum];
				outNum++;
			}
		}
		return a;
	}


}
