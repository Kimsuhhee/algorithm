import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj1991 {
    static int N;
    static ArrayList<Node>[]node;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        node = new ArrayList[N];
        for(int i=0;i<N;i++)node[i] = new ArrayList<>();

        for(int i=0;i<N;i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            char root = stk.nextToken().charAt(0);
            char left = stk.nextToken().charAt(0);
            char right = stk.nextToken().charAt(0);
            node[root-'A'].add(new Node(root,left,right));
        }
        preorder(0);
        sb.append("\n");
        inorder(0);
        sb.append("\n");
        postorder(0);
        sb.append("\n");
        System.out.println(sb);
    }

    private static void postorder(int i) {
        Node cur = node[i].get(0);
        if(cur.left!='.')postorder(cur.left-'A');
        if(cur.right!='.')postorder(cur.right-'A');
        sb.append(cur.root);
    }

    private static void inorder(int i) {
        Node cur = node[i].get(0);
        if(cur.left!='.')inorder(cur.left-'A');
        sb.append(cur.root);
        if(cur.right!='.')inorder(cur.right-'A');
    }

    private static void preorder(int i) {
        Node cur = node[i].get(0);
        sb.append(cur.root);
        if(cur.left!='.')preorder(cur.left-'A');
        if(cur.right!='.')preorder(cur.right-'A');
    }

    private static class Node {
       char root,left,right;

        public Node(char root, char left, char right) {
            this.root = root;
            this.left = left;
            this.right = right;
        }
    }
}
