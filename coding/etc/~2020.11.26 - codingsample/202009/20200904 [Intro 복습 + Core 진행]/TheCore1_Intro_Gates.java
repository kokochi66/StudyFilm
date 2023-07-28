import java.util.stream.IntStream;

public class TheCore1_Intro_Gates {
    private static int addTwoDigits(int n) {
        return n/10 + n%10;
    }
    //입력된 두자릿 수를 각 자릿수를 더한 값을 출력한다.

    private static int largestNumber(int n) {
        int output = 9;
        for(int i=1;i<n;i++){
            output *= 10;
            output += 9;
        }
        return output;
    }
    //입력된 값만큼의 자릿수의 최댓값을 출력한다.    

    private static int candies(int n, int m) {
        return (m/n)*n;
    }
    // n명의 아이들이 m개의 캔디를 똑같이 나눠먹을때, 총 먹은 캔디 수를 출력
    
    private static int seatsInTheater(int nCols, int nRows, int col, int row) {
        return (nCols-col+1)*(nRows-row);
    }
    //영화관의 가로열 세로열이 주어졌을때, 출구까지 가는데 뒤에있는 사람의 수를 출력한다.
    
    private static int maxMultiple(int divisor, int bound) {
        int temp = divisor;
        while(temp<=bound) temp += divisor;
        temp -= divisor;
        return temp;
    }
    // divisor로 나눠지고, bound보다 작거나 같으며 0보다 큰 가장 큰 정수 n을 출력
    private static int circleOfNumbers(int n, int firstNumber) {
        return ((n/2)+firstNumber)%n;
    }
    //원의 반대편 숫자를 출력
    private static int lateRide(int n) {
        return (n/60)/10 + (n/60)%10 + (n%60)/10 + (n%60)%10;
    }
    //지난 분을 시간:분 으로 바꾼 뒤, digit으로 모두 더한값을 출력
    private static int phoneCall(int min1, int min2_10, int min11, int s) {
        if(min1>s) return 0;
        int count = min1;
        int minn = 1;
        while(count<s){
            minn++;
            if(minn<=10) count += min2_10;
            else if(minn>10) count += min11;
            if(count>s) minn--;
        }
        return minn;
    }
    //최대 사용할 수 있는 통화시간을 출력
    public static void main(String[] args){
        System.out.println(addTwoDigits(26));
        System.out.println(largestNumber(4));
        System.out.println(candies(5,13));
        System.out.println(seatsInTheater(16,11,5,3));
        System.out.println(maxMultiple(3,10));
        System.out.println(circleOfNumbers(10,2));
        System.out.println(lateRide(1439));
        System.out.println(phoneCall(2,2,1,2));
    }
    
}
