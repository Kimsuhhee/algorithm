import java.util.PriorityQueue;

public class 길찾기게임 {
    static int idx;
    public static void main(String[] args) {
        int[][] nodeinfo = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
        int[][] answer = solution(nodeinfo);
        for(int i=0;i<answer.length;i++){
            for(int j=0;j<answer[0].length;j++){
                System.out.print(answer[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][nodeinfo.length];
        PriorityQueue<Node>q = new PriorityQueue<>();
        for(int i=0;i<nodeinfo.length;i++){
            q.add(new Node(i+1,nodeinfo[i][0],nodeinfo[i][1],null,null));
        }

        Node root = q.poll();
        while(!q.isEmpty()){
            insert(root,q.poll());
        }
        preorder(root,answer);
        idx = 0;
        postorder(root,answer);

        return answer;
    }

    private static void postorder(Node root, int[][] answer) {
        if(root!=null){
            postorder(root.left,answer);
            postorder(root.right,answer);
            answer[1][idx++] = root.num;
        }
    }

    private static void preorder(Node root, int[][] answer) {
        if(root!=null){
            answer[0][idx++] = root.num;
            preorder(root.left,answer);
            preorder(root.right,answer);
        }
    }

    private static void insert(Node parent, Node child) {
        if(parent.x>child.x){
            if(parent.left==null) parent.left = child;
            else insert(parent.left,child);
        }else{
            if(parent.right==null) parent.right = child;
            else insert(parent.right,child);
        }
    }

    private static class Node implements Comparable<Node>{
        int num,x,y;
        Node left,right;

        public Node(int num, int x, int y, Node left, Node right) {
            this.num = num;
            this.x = x;
            this.y = y;
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(Node o) {
            if(o.y==this.y){
                return this.x-o.x;
            }else
                return o.y-this.y;
        }
    }
}
