public class TheCore6_Labyrinth_of_Nested_Loops2 {
    private static int SumDigit(int n){
        int sum = 0;
        while(n!=0){
            sum += n%10;
            n /= 10;
        }
        return sum;
    }
    private static int comfortableNumbers(int l, int r){
        int Digit, maxSum, count = 0;;
        for(int i=l;i<r;i++){
            Digit = SumDigit(i);
            maxSum = i+Digit;
            while((maxSum - SumDigit(maxSum)) > i) maxSum--;
            if(maxSum >= r) count += (r - i);
            else count += (maxSum - i);
        }
        return count;
    }
    // a!=b , a<b, [a - SumDigit(a), a + SumDigit(a)] 인 관계인 (a,b)집합이 [l,r] 에 몇개존재하는지 출력
    public static void main(String[] args){
        System.out.println(comfortableNumbers(12,108));

    }
}
