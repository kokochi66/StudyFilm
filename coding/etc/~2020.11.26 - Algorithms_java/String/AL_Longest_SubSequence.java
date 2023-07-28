package Algorithms_java.String;

public class AL_Longest_SubSequence {
    public static void main(String[] args){
        String a = "bbbbabab";
        String b = "bbbabaaaaa";
        LCS(a,b);
    }

    public static int LCS(String a, String b){
        char[] arr1 = a.toCharArray();
        char[] arr2 = b.toCharArray();
        char[][] darr = new char[arr1.length+1][arr2.length+1];
        for(int i=1;i<arr1.length;i++){
            for(int j=1;j<arr2.length;j++){
                System.out.println(i+" "+j);
                if(arr1[i-1] == arr2[j-1]) darr[i][j] = (char)(darr[i-1][j-1]+1);
                else darr[i][j] = (char)Math.max(darr[i-1][j],darr[i][j-1]);
            }
        }
        for(int i=0;i<arr1.length;i++){
            for(int j=0;j<arr2.length;j++){
                System.out.print((int)darr[i][j]+" ");
            }
            System.out.println();
        }
        return 0;
    }
}
