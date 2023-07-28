import java.util.Arrays;

public class TheCore2_At_the_Crossroads {
    private static boolean reachNextLevel(int experience, int threshold, int reward) {
        return experience+reward >= threshold;
    }
    private static int knapsackLight(int value1, int weight1, int value2, int weight2, int maxW) {
        return weight1+weight2<=maxW ? value1+value2 : weight1>maxW ? weight2>maxW ? 0 : value2 : weight2>maxW ? value1 : value1>value2 ? value1 : value2;
    }

    private static int extraNumber(int a, int b, int c) {
        return a==b ? c : a==c ? b : b==c ? a : -1;
    }
    
    private static boolean isInfiniteProcess(int a, int b) {
        return (b-a)%2!=0 || a>b;
    }
    
    private static boolean arithmeticExpression(int a, int b, int c) {
        return a+b==c || a-b==c || a*b==c || (double)a/b==(double)c;
    }

    private static boolean tennisSet(int score1, int score2) {
        return Math.max(score1,score2)>7 ? false : Math.max(score1,score2)==7 ? Math.min(score1,score2)>=5 && Math.min(score1,score2)<=6 : Math.max(score1,score2)==6 ? Math.min(score1,score2)<5 : false;
    }
    
    private static boolean willYou(boolean young, boolean beautiful, boolean loved) {
        return (young&&beautiful)!=loved;
    }
    
    private static int[] metroCard(int lastNumberOfDays) {
        if(lastNumberOfDays==28||lastNumberOfDays==30) return new int[] {31};
        return new int[] {28,30,31};
    }
    
    

    public static void main(String[] args){
        System.out.println(reachNextLevel(10,15,5));
        System.out.println(knapsackLight(10,5,6,4,8));
        System.out.println(extraNumber(2,7,2));
        System.out.println(isInfiniteProcess(2,6));
        System.out.println(arithmeticExpression(2,3,5));
        System.out.println(tennisSet(3,6));
        System.out.println(willYou(true,false,true));
        System.out.println(Arrays.toString(metroCard(31)));

    }
}
