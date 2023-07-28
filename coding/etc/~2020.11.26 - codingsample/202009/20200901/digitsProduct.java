package javaSpeedCoding20200901;

import java.util.Arrays;

public class digitsProduct {
	// 주어진 정수를 정수의 곱으로 표현할 수 있는 최소값을 출력하는 함수를 만드시오.
	// 주어진수가 16이면 28, 82, 44 중 최솟값인 28이 출력되면 됨.
	// 한자리숫자는 그대로 출력.
	static int minlength(String s) {	//입력된 약수들을 최소로 줄일 수 있는 크기를 반환
		int num2 = 0, num3 = 0;
		int count = s.length();
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='2') num2++;
			else if(s.charAt(i)=='3') num3++;
			if(num2>=3) {
				num2 -= 3;
				count -= 2;
			}
		}
		count -= (num2+num3)/2;
		return count;
	}
	static int minArray(int[] a) {	//배열 조합으로 만들어낼 수 있는 최솟값을 반환
		int temp = 0;
		Arrays.sort(a);
		temp += a[0];
		for(int i=1;i<a.length;i++) {
			temp *= 10;
			temp += a[i];
		}
		return temp;
	}
	static int caseArray(int[] a, String s) {	// 여러가지 배열의 케이스를 분석하여, 최솟값을 반환
		int num2 = 0, num3 = 0, aNum = 0;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='2') num2++;
			else if(s.charAt(i)=='3') num3++;
			else a[aNum++] = (int)(s.charAt(i)-'0');
			if(num2>=3) {
				a[aNum++] = 8;
				num2 -= 3;
			}
		}
		if(num2==1) {
			if(num3%2==0) {
				a[aNum++] = 2;
				num2--;
				while(num3>0) {
						a[aNum++] = 9;
						num3 -= 2;
				}
			}
			else {
				a[aNum++] = 6;
				num2--;
				num3--;
				while(num3>0) {
					a[aNum++] = 9;
					num3 -= 2;
				}
			}
		}
		else if(num2==2) {
			if(num3%2==0) {
				a[aNum++] = 4;
				num2-=2;
				while(num3>0) {
					a[aNum++] = 9;
					num3 -= 2;
				}
			}
			else {
				a[aNum++] = 2;
				a[aNum++] = 6;
				num2-=2;
				num3--;
				while(num3>0) {
					a[aNum++] = 9;
					num3 -= 2;
				}
				
			}
			
		}
		else {
			if(num3%2==0) {
				while(num3>0) {
					a[aNum++] = 9;
					num3 -= 2;
				}
			}
			else {
				a[aNum++] = 3;
				num3--;
				while(num3>0) {
					a[aNum++] = 9;
					num3 -= 2;
				}
				
			}
			
		}
		return minArray(a);
	}
	static int minmeasure(int a) {	//입력된 값의 최소약수값을 반환함. 10이상이면 -1을 반환
		for(int i=2;i<=9;i++) if(a%i==0) return i;
		return -1;
	}

	static int digitsProduct(int product) {
		if(product==0) return 10;
		else if(product==1) return 1;
		String output = "";
		int outputNum = 0;
		int temp;
		while(product>1) {
			temp = minmeasure(product);
			if(temp>9||temp==-1) return -1;
			output += (char)(temp+'0');
			product /= temp;
		}
		int[] print = new int[minlength(output)];
		return caseArray(print,output);
	}
	//문자열에 약수를 하나씩 저장하여 최초값을 만든 후, 최소값을 만들어냄.
	//약수가 나누어지지 않는 두자릿수(소수)값이 있다면, -1을 반환
	public static void main(String[] args) {
		int a = 4;
		System.out.println(digitsProduct(a));
	}

}
