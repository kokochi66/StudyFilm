public class sol1_pro11 {

    public int[] solution(int[][] v) {
        int x, y;
        x = v[0][0] == v[1][0] ? v[2][0] : v[1][0] == v[2][0] ? v[0][0] : v[0][0] == v[2][0] ? v[1][0] : -1;
        y = v[0][1] == v[1][1] ? v[2][1] : v[1][1] == v[2][1] ? v[0][1] : v[0][1] == v[2][1] ? v[1][1] : -1;

        return new int[]{x,y};
    }
    public static void main(String[] args){

    }
}
