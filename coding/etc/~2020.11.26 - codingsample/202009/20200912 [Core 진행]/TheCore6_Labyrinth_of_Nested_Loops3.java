public class TheCore6_Labyrinth_of_Nested_Loops3 {
    private static int d(int n) {
        if(n==1) return 1;
        int count = 2;
        for(int i=2;i<=(n/2);i++) if(n%i==0) count++;
        return count;
    }
    private static int[] weakNumbers(int n) {
        int[] define = new int[1000];
        Arrays.fill(define,0);
        ArrayList<Boolean> ar = new ArrayList<Boolean>();
        int max= 0, maxC = 0, curr, temp;
        for(int i=1;i<=n;i++){
            temp = 0;
            curr = d(i);
            define[curr]++;
            if(maxC < curr) maxC = curr;
            for(int j = maxC; j >curr; j--) temp += define[j];
            if(max < temp) {
                ar.clear();
                ar.add(true);
                max = temp;
            }
            else if(max == temp) ar.add(true);
        }
        int[] output = new int[2];
        output[0] = max;
        output[1] = ar.size();
        return output;
    }
    

    public static void main(String[] args) {

    }
    
}
