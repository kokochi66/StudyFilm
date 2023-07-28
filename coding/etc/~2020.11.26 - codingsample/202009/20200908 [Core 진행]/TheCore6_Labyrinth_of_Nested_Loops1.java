import java.util.HashSet;

public class TheCore6_Labyrinth_of_Nested_Loops1 {
    private static boolean isPowerint(int n, int m){
        if(n==m) return true;
        int temp = 0, i = 2;
        while(temp < m){
            temp = (int)Math.pow(n,i++);
            if(temp == m) return true;
            else if(temp > m) return false;
        }
        return false;
    }
    private static boolean isPower(int n) {
        if(n==1) return true;
        int i=2;
        while(true){
            if((int)Math.pow(i,2) > n) return false;
            else if(isPowerint(i,n)) return true;
            i++;
        }
    }
    //입력된 n이 어떠한 양수의 제곱이 될 수 있는지를 출력
    private static int isSumOfConsecutive2(int n) {
        int count = 0, temp, start=0, end=1;
        while(end < n){
            temp = (end*(end+1))/2 - (start*(start+1))/2;
            if(end-start==1 && temp > n) break;
            if(temp == n) {
                count++;
                end++;
                start++;
            }
            else if(temp < n) end++;
            else if(temp > n) start++;
        }
        return count;
    }
    //연속된 숫자의 합으로 n을 만들 수 있는 경우의수를 출력
    private static int SqaureDigitsSum(int n){
        int sum = 0;
        while(n!=0){
            sum += (n%10)*(n%10);
            n /= 10;
        }
        return sum;
    }
    private static int squareDigitsSequence(int a0) {
        HashSet<Integer> set = new HashSet<Integer>();
        int temp = SqaureDigitsSum(a0), count = 2;
        while(temp != a0 && !(set.contains(temp))){
            set.add(temp);
            // System.out.println(count + " " + temp);
            count++;
            temp = SqaureDigitsSum(temp);
        }
        return count;
    }
    //이어지는 수의 digit의 제곱의 값으로 이루어진 수열이 같은값이 나올때 까지의 수
    //같은값은 이전의 모든값을 기억해야하므로 HashSet을 사용하여 기록하였음.
    private static int DigitsOfInt(int n){
        int count = 0;
        while(n != 0){
            n /= 10;
            count++;
        }
        return count;
    }
    private static int pagesNumberingWithInk(int current, int numberOfDigits) {
        while(numberOfDigits >= 0) numberOfDigits -= DigitsOfInt(current++);
        return current-2;
    }
    //주어진 잉크로 찍을 수 있는 최종 페이지를 출력(별것도 없으면서 내용만 어려운 문제)
    public static void main(String[] args){
        System.out.println(isPower(122));
        System.out.println(isSumOfConsecutive2(188));
        System.out.println(squareDigitsSequence(25));
        System.out.println(pagesNumberingWithInk(1,5));
    }

}
