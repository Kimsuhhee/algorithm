import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj17837 {
    static int N,K,r,c,d;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static int[][] chess;
    static Stack<Piece>[][] cur;
    static Piece[] pieces;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());
        chess = new int[N][N];
        pieces = new Piece[K+1];
        cur = new Stack[N][N];

        for(int i=0;i<N;i++){
            stk = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                chess[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                cur[i][j] = new Stack<>();
            }
        }

        for(int i=1;i<=K;i++){
            stk = new StringTokenizer(br.readLine()," ");
            r = Integer.parseInt(stk.nextToken());
            c = Integer.parseInt(stk.nextToken());
            d = Integer.parseInt(stk.nextToken());
            pieces[i] = new Piece(i,r-1,c-1,d-1);
            cur[r-1][c-1].push(pieces[i]);
        }

        int turns = 0;
        while(turns<=1000){
            turns++;
            if(move()){
                break;
            }

        }
        if(turns>=1000) System.out.println(-1);
        else System.out.println(turns);

    }
    private static boolean move() {
        for(int i=1;i<=K;i++){
            Piece p = pieces[i];
            int mx = p.x + dx[p.d];
            int my = p.y + dy[p.d];
            if(mx<0||my<0||mx>=N||my>=N||chess[mx][my]==2){
                p.d = changeDirection(p.d);
                mx = p.x + dx[p.d];
                my = p.y + dy[p.d];
                if(mx<0||my<0||mx>=N||my>=N||chess[mx][my]==2) {
                    if(cur[p.x][p.y].size()>=4)return true;
                    continue;
                }
            }
            if(chess[mx][my]==0){
                ArrayList<Piece>temp = new ArrayList<>();

                while(cur[p.x][p.y].peek().num!=i){
                     temp.add(cur[p.x][p.y].pop());
                }
                temp.add(cur[p.x][p.y].pop());

                for(int j=temp.size()-1;j>=0;j--){
                    Piece pp = temp.get(j);
                    pp.x = mx; pp.y = my;
                    cur[mx][my].push(pp);
                }
                if(cur[mx][my].size()>=4)return true;
            }else if(chess[mx][my]==1){
                ArrayList<Piece>temp = new ArrayList<>();

                while(cur[p.x][p.y].peek().num!=i){
                    temp.add(cur[p.x][p.y].pop());
                }
                temp.add(cur[p.x][p.y].pop());

                for(int j=0;j<temp.size();j++){
                    Piece pp = temp.get(j);
                    pp.x = mx; pp.y = my;
                    cur[mx][my].push(pp);
                }
                if(cur[mx][my].size()>=4)return true;
            }

        }
        return false;

    }

    private static int changeDirection(int d) {
        if(d==0)return 1;
        else if(d==1)return 0;
        else if(d==2)return 3;
        else return 2;
    }

    private static class Piece {
        int num,x,y,d;

        public Piece(int num,int x, int y, int d) {
            this.num = num;
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
}
