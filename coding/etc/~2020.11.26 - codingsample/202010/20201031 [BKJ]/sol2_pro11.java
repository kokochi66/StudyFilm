public class sol2_pro11 {

    public String solution(int n, int[][] delivery) {
        StringBuilder output = new StringBuilder("");
        char[] arr = new char[n+1];
        for(int i=0;i<n;i++) output.append("?");
        for(int i=0;i<delivery.length;i++){
            if(delivery[i][2] == 1){
                arr[delivery[i][0]] = 'O';
                output.replace(delivery[i][0]-1, delivery[i][0], "O");
                arr[delivery[i][1]] = 'O';
                output.replace(delivery[i][1]-1, delivery[i][1], "O");
            } 
            // O인 재고 체크 10만연산
        }
        for(int i=0;i<delivery.length;i++){
            if(delivery[i][2] == 0){
                if(arr[delivery[i][0]] == 'O') {
                    arr[delivery[i][1]] = 'X';
                    output.replace(delivery[i][1]-1, delivery[i][1], "X");

                } else if(arr[delivery[i][1]] == 'O'){
                    arr[delivery[i][0]] = 'X';
                    output.replace(delivery[i][0]-1, delivery[i][0], "X");
                }
            }
            // X인 재고 체크 10만연산
        }
        return output.toString();
    }
    
    public static void main(String[] args) throws Exception {
    }
}
