package javaSpeedCoding20200901;

import java.util.Scanner;

public class the3npls1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean clear;
		while(sc.hasNextInt()) {
			clear = false;
			int point = sc.nextInt();
			int sub = sc.nextInt();
			while(point != 1) {
				if(point%2==0) point/=2;
				else point = (3*point)+1;
				if(point==sub) clear = true;
			}
			if(clear) System.out.println("Y");
			else System.out.println("N");
		}
	}

}
