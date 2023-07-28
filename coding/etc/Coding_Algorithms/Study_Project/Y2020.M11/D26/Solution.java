package D26;

import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution("E=M*C^2","e=m*c^2");

	}
	public static int solution(String str1, String str2) {
		StringBuilder st1 = new StringBuilder(str1.toLowerCase());
		StringBuilder st2 = new StringBuilder(str2.toLowerCase());
		ArrayList<String> li1 = new ArrayList<String>();
		ArrayList<String> li2 = new ArrayList<String>();
		for(int i=0;i<st1.length()-1;i++) {
			if(st1.charAt(i)>='a'&&st1.charAt(i)<='z'
					&& st1.charAt(i+1)>='a'&&st1.charAt(i+1)<='z') {
				li1.add(st1.substring(i, i+2));
			}
		}
		for(int i=0;i<st2.length()-1;i++) {
			if(st2.charAt(i)>='a'&&st2.charAt(i)<='z'
					&& st2.charAt(i+1)>='a'&&st2.charAt(i+1)<='z') {
				li2.add(st2.substring(i, i+2));
			}			
		}
		// ÀÔ·ÂºÎ O
	
		Collections.sort(li1);
		Collections.sort(li2);
		for(int i=0;i<li1.size();i++) {
			System.out.print(li1.get(i)+" ");
		}
		System.out.println(":::: li1 ::::");
		
		for(int i=0;i<li2.size();i++) {
			System.out.print(li2.get(i)+" ");
		}
		System.out.println(":::: li2 ::::");
		
		HashSet<String> set = new HashSet<String>();
		int union = 0;
		int insec = 0;
		for(int i=0;i<li1.size();i++) {
			int count1 = 1, count2 = 0;
			while(i+1<li1.size() && li1.get(i).equals(li1.get(i+1))) {
				i++;
				count1++;
			}
			for(int j=0;j<li2.size();j++) {
				if(li2.get(j).equals(li1.get(i))) count2++;
			}
			set.add(li1.get(i));
			union += Math.max(count1, count2);
			insec += Math.min(count1, count2);
		}
		
		for(int i=0;i<li2.size();i++) {
			if(!set.contains(li2.get(i))) {
				union++;
			}
		}
		System.out.println(union+" "+insec);
		double res;
		if(union != 0) res = ((double)insec / (double)union)*65536;
		else res = 65536;
        return (int)res;
    }
	
	public int solution1(int n, int a, int b)
    {
		int count = 1;
		while((a+1)/2 != (b+1)/2) {
			a = (a+1)/2;
			b = (b+1)/2;
			count++;
		}

        return count;
    }

}
