import java.util.Arrays;

public class sol4_pro11 {

    public static int[] solution(int[][] v){
        int[] output = new int[3];
        // 0 = 무 , 1= 고구마, 2= 감자
        for(int i=0;i<v.length;i++){
            for(int j=0;j<v[0].length;j++){
                if(v[i][j] == 0) {
                    output[0]++;
                    func(v,i,j,0);
                    // System.out.println("0  "+i+" "+j);
                } else if(v[i][j] == 1) {
                    output[1]++;
                    func(v,i,j,1);
                    // System.out.println("1  "+i+" "+j);
                } else if(v[i][j] == 2) {
                    output[2]++;
                    func(v,i,j,2);
                    // System.out.println("2  "+i+" "+j);
                }
            }
        }


        return output;
    }

    public static void func(int[][] v, int h, int w, int Curr){
        if(h>=0 && h<v.length && w>=0 && w<v[0].length && v[h][w] == Curr){
            v[h][w] = -1;
            func(v,h+1,w,Curr);
            func(v,h-1,w,Curr);
            func(v,h,w+1,Curr);
            func(v,h,w-1,Curr);
        }
    }
    public static void main(String[] args) throws Exception {
        int[][] a = {
            {0,0,1,1}, 
            {1,1,1,1},
            {2,2,2,1},
            {0,0,0,2}
        };
        System.out.println(Arrays.toString(solution(a)));
    }
}
