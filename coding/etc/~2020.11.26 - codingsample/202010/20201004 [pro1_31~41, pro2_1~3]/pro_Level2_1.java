public class pro_Level2_1 {
    public static long solution(int w, int h) {
        long tempW = w, tempH = h;
        long answer = tempW*tempH;
        long gcdS = gcd(tempW,tempH);
        tempW /= gcdS;
        tempH /= gcdS;
        long sum = 0;
        long tempC =0, tempF=0;
        for(long i=1;i<=tempW;i++){
            if(i!=tempW) tempC = ((tempH*i)/tempW)+1;
            else if(i==tempW) tempC = ((tempH*i)/tempW);
            tempF = ((tempH*(i-1))/tempW);
            sum += (tempC - tempF);
        }
        return answer-(sum*gcdS);
    }
    public static long gcd(long a,long b){
        long temp = 1;
        while(temp!=0){
            temp = b%a;
            b=a;
            a=temp;
        }
        return b;
    }
}
