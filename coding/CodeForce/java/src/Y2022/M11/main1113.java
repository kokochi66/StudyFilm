package src.Y2022.M11;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class main1113 {
    static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tok;

    public static void main(String[] args) throws Exception {
        solution();
    }

    public static void solution() throws Exception {
        // preorder = 중 - 왼 - 오
        // inorder - 왼 - 중 - 오
        // postorder - 왼 - 오 - 중


        int n = Integer.parseInt(rd.readLine());
        tok = new StringTokenizer(rd.readLine());
        int[] inorder = new int[n];
        int[] postorder = new int[n];
        int[] preorder = new int[n];
        for (int i = 0; i < n; i++) {
            inorder[i] = Integer.parseInt(tok.nextToken());
        }
        tok = new StringTokenizer(rd.readLine());
        for (int i = 0; i < n; i++) {
            postorder[i] = Integer.parseInt(tok.nextToken());
        }

        // postorder 의 root는 무조건 마지막에 온다

        // inorder에서 root를 중심으로 왼쪽은 전부 왼쪽으로 간다. 나머지는 오른쪽
        // 루트를 찾고, 왼쪽 오른쪽을 각각 배치한다. (반복)
        // 그 다음 루트를 어떻게 찾을 것인가?
        // inorder의 연속된 왼쪽 값은 postorder에서도 왼쪽으로 연속되어 있다. (왼쪽 우선이기 떄문)

 /*        숫자 하나씩 찾으면서
         in과 post가 같다면 => 왼쪽값
         다르다면
         1. inorder의 값이 root인 경우
         그 다음부터 오른쪽으로 쳐서, 탐색을 재차 진행한다.

         root 일려면, 해당 root 왼쪽의 값과 오른쪽값이 post에서도 연속되있음을 확인해야한다.

         2. 둘다 left인 경우
         다음 값도 추가로 검증한다.
*/

        dc(inorder, postorder, preorder, 0, n - 1, 0, 0);
        for (int i=0;i<n;i++) {
            System.out.print(preorder[i] +" ");
        }
    }

    public static int dc(int[] inorder, int[] postorder, int[] preorder, int left, int right, int postIndex, int preIndex) {
        if (left > right) return preIndex - 1;

//        System.out.println("pre = " + Arrays.toString(preorder));
//        System.out.println("left = " + left);
//        System.out.println("right = " + right);
//        System.out.println("preIndex = " + preIndex);
//        System.out.println("postIndex = " + postIndex);
        int root = postorder[postIndex + (right - left)];
        preorder[preIndex] = root;

        int inRootIndex = -1;
        for (int i=left;i<=right;i++) {
            if (inorder[i] == root) {
                inRootIndex = i;
                break;
            }
        }
//        System.out.println("inRootIndex = " + inRootIndex);
//        System.out.println("left ======================");
        preIndex = dc(inorder, postorder, preorder, left, inRootIndex - 1, postIndex, preIndex + 1);
        if (inRootIndex + 1 <= right) {
//            System.out.println("right =============================");
            preIndex = dc(inorder, postorder, preorder, inRootIndex + 1, right, postIndex + (inRootIndex - left), preIndex + 1);
        }
        return preIndex;
    }

}
