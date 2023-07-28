package javaSpeedCoding20200901;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FontCounting {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		while((input=br.readLine())!=null){
			int word = 0, font = 0;
			for(int i=0;i<input.length();i++) {
				if(input.charAt(i)==' ' || i==input.length()-1) word++;
				if(input.charAt(i)!=' ') font++;
			}
			System.out.println(word + " " + font);
		}
	}

}
