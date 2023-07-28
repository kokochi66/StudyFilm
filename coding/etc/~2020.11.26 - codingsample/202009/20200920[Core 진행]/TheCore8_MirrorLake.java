import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class TheCore8_MirrorLake {
    private static int stringsConstruction(String a, String b) {
        int[] numB = new int[26];
        boolean check = false;
        Arrays.fill(numB,0);
        int count = 0;
        for(int i=0;i<b.length();i++){
            numB[b.charAt(i) - 'a']++;
        }
        while(!check){
            for(int i=0;i<a.length();i++){
                if(numB[a.charAt(i)-'a']==0) {
                    check = true;
                    break;
                }
                else numB[a.charAt(i)-'a']--;
            }
            if(!check) count++;
        }
        return count;
    }
    private static boolean isSubstitutionCipher(String string1, String string2) {
        if(string1.length() != string2.length()) return false;
        char[] s1 = new char[26];
        boolean[] s2 = new boolean[26];
        Arrays.fill(s1,'0');
        Arrays.fill(s2,false);
        for(int i=0;i<string1.length();i++){
            if(s1[string1.charAt(i) - 'a'] >= 'a' && s1[string1.charAt(i) - 'a'] <= 'z'){
                if(string2.charAt(i) != s1[string1.charAt(i) - 'a']) return false;
            }
            else {
                s1[string1.charAt(i) - 'a'] = string2.charAt(i);
                if(s2[string2.charAt(i) - 'a']) return false;
                s2[string2.charAt(i) - 'a'] = true;
            }
        }
        return true;
    }
    
    private static int createAnagram(String s, String t) {
        int[] tempS = new int[26];
        int[] tempT = new int[26];
        Arrays.fill(tempS,0);
        Arrays.fill(tempT,0);
        for(int i=0;i<s.length();i++){
            tempS[s.charAt(i) - 'A']++;
            tempT[t.charAt(i) - 'A']++;
        }
        int count = 0;
        for(int i=0;i<26;i++){
            count += Math.abs(tempS[i] - tempT[i]);
        }
        return count/2;
    }
    
    private static int constructSquare(String s) {
        int[] num = new int[26];
        Arrays.fill(num,0);
        for(int i=0;i<s.length();i++) num[s.charAt(i) - 'a']++;
        Arrays.sort(num);
        int output = 2;
        int max = -1;
        String outTemp;
        boolean check = false;
        int[] temp = new int[10];
        while((output*output) < Math.pow(10,s.length())){
            check = false;
            Arrays.fill(temp,0);
            outTemp = (output*output)+"";
            for(int i=0;i<outTemp.length();i++) temp[outTemp.charAt(i) - '0']++;
            Arrays.sort(temp);
            for(int i=0;i<10;i++){
                if(temp[temp.length-1-i] != num[num.length-1-i]) {
                    check = true;
                    break;
                }
            }
            if(!check && max < (output*output)) max = output*output;
            output++;
        }
        return max;
    }
    
    private static int numbersGrouping(int[] a) {
        HashSet<Integer> set = new HashSet<Integer>();
        int temp, count = 0;
        for(int i=0;i<a.length;i++){
            temp = (a[i]-1)/10000;
            if(!set.contains(temp)){
                set.add(temp);
                count++;
            }
        }
        count += a.length;
        return count;
    }
    
    private static int differentSquares(int[][] matrix) {
        HashSet<String> set = new HashSet<String>();
        int count = 0;
        String temp;
        for(int i=0;i<matrix.length-1;i++){
            for(int j=0;j<matrix[0].length-1;j++){
                temp = (matrix[i][j]+"")+(matrix[i+1][j]+"")+(matrix[i][j+1]+"")+(matrix[i+1][j+1]+"");
                if(!set.contains(temp)){
                    set.add(temp);
                    count++;
                }
            }
        }
        return count;
    }
    
    private static int mostFrequentDigitSum(int n) {
        ArrayList<String> temp = new ArrayList<String>();
        int digit, nTemp;
        int varA, varB;
        int[] max = new int[2];
        Arrays.fill(max,0);
        boolean nothing = true;
        String[] tempToken;
        while(n>0){
            nothing = true;
            nTemp = n;
            digit = 0;
            while(nTemp!=0){
                digit += nTemp%10;
                nTemp /= 10;
            }
            for(int i=0;i<temp.size();i++){
                tempToken = temp.get(i).split("-");
                varA = Integer.parseInt(tempToken[0]);
                varB = Integer.parseInt(tempToken[1]);
                if(max[1] == varB && max[0] < varA) {
                        max[0] = varA;
                        max[1] = varB;
                }
                if(varA == digit) {
                    varB++;
                    temp.set(i, (varA+"")+"-"+((varB)+""));
                    if(max[1] < varB) {
                        max[0] = varA;
                        max[1] = varB;
                    }
                    nothing = false;
                    break;
                }
            }
            if(nothing) {
                if(temp.isEmpty()) {
                    max[0] = digit;
                    max[1] = 1;
                }
                temp.add((digit+"")+"-"+"1");
                if(max[1] == 1 && max[0] < digit) {
                        max[0] = digit;
                        max[1] = 1;
                }
            }
                
            n -= digit;
        }
        return max[0];
    }
    
    private static int numberOfClans(int[] divisors, int k) {
        HashSet<String> set = new HashSet<String>();
        HashSet<Integer> div = new HashSet<Integer>();
        for(int i=0;i<divisors.length;i++) div.add(divisors[i]);
        Object[] divTemp = div.toArray();
        Arrays.sort(divTemp);
        String outTemp;
        int count = 0;
        for(int n=1;n<=k;n++){
            outTemp = "0";
            for(int j=0;j<divTemp.length;j++){
                if(n%(int)(divTemp[j])==0) outTemp += (divTemp[j]+"");
            }
            if(!set.contains(outTemp)){
                count++;
                set.add(outTemp);
            }
        }
        return count;
    }
    
    public static void main(String[] args){
        System.out.println("A");
        
    }
    
}
