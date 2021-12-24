import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj2580 {
    static int[][] board;
    static int[]p;
    static ArrayList<Point>blank;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new int[9][9];
        blank = new ArrayList<>();

        StringTokenizer stk;
        for(int i=0;i<9;i++){
            stk = new StringTokenizer(br.readLine());
            for(int j=0;j<9;j++){
                board[i][j] = Integer.parseInt(stk.nextToken());
                if(board[i][j] == 0)blank.add(new Point(i,j));
            }
        }
        int N = blank.size();
        permutation(0,N);
    }

    private static void permutation(int n, int N) {
        if(n==N){
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    sb.append(board[i][j]+" ");
                }
                sb.append("\n");
            }
            System.out.print(sb);
            System.exit(0);
            return;
        }
        Point cur = blank.get(n);
        for(int i=1;i<=9;i++){
            if(checkX(cur,i) && checkY(cur,i) && checkSquare(cur,i)) {
                board[cur.x][cur.y] = i;
                permutation(n + 1, N);
                board[cur.x][cur.y] = 0;
            }
        }
    }

    private static boolean checkX(Point p, int num) {

        for(int y=0;y<9;y++){
            if(board[p.x][y]==num)return false;
        }
        return true;
    }

    private static boolean checkY(Point p, int num) {

        for(int x=0;x<9;x++){
            if(board[x][p.y]==num)return false;
        }
        return true;
    }

    private static boolean checkSquare(Point p, int num) {
        int x = p.x/3*3;
        int y = p.y/3*3;

        for(int i=x;i<x+3;i++){
            for(int j=y;j<y+3;j++){
                if(board[i][j]==num) return false;
            }
        }

        return true;
    }

    private static class Point {
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
