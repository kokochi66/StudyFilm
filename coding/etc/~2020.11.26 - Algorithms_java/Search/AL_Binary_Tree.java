
public class AL_Binary_Tree {

    public static void main(String[] args){
        Binary_tree<Integer> bt = new Binary_tree<>();
        int[] opt = {8,4,12,2,6,10,14,1,3,5,7,9,11,13,15};
        for(int i=0;i<opt.length;i++) bt.add(opt[i]);
        bt.print_tree(2);
        // 0은 inorder, 1은 preorder, 2는 postorder

    }
    static class Binary_tree<Integer> {
        private class Node {
            private int data;
            private Node Left;
            private Node Right;
            Node(int d) {
                this.data = d;
                this.Left = null;
                this.Right = null;
            }
        }
        private Node root;
        public int size;
        public Binary_tree(){
            size = 0;
        }
        public void add(int input){
            if(this.root == null) root = new Node(input);
            else addNode(root, input);
        }
        private void addNode(Node n, int input){
            if(n.data >= input){
                if(n.Left == null){
                    n.Left = new Node(input);
                    return;
                } else addNode(n.Left,input);
            } else {
                if(n.Right == null) {
                    n.Right = new Node(input);
                    return;
                } else addNode(n.Right,input);
            }
        }

        public void print_tree(int n) {
            if(n==0) InOrderTraverse(root);
            else if(n==1) PreOrderTraverse(root);
            else if(n==2) PostOrderTraverse(root);
            else {
                System.out.println("오류발생 :: 다음 숫자 중 하나를 입력해주세요.");
                System.out.println("0 : Inorder (Left -> root -> right");
                System.out.println("1 : Preorder (root -> Left -> right");
                System.out.println("2 : Postorder (Left -> Right -> root");
            }
        }
        private void InOrderTraverse(Node n){
            if(n.Left != null) InOrderTraverse(n.Left);
            System.out.print(n.data+" ");
            if(n.Right != null) InOrderTraverse(n.Right);
        }
        private void PreOrderTraverse(Node n){
            System.out.print(n.data+" ");
            if(n.Left != null) PreOrderTraverse(n.Left);
            if(n.Right != null) PreOrderTraverse(n.Right);
        }
        private void PostOrderTraverse(Node n){
            if(n.Left != null) PostOrderTraverse(n.Left);
            if(n.Right != null) PostOrderTraverse(n.Right);
            System.out.print(n.data+" ");
        }

    }
}
