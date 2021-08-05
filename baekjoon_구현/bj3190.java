import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj3190 {
    static int N,K,L,x,y,m,dir,cx,cy;
    static Queue<commands>q = new LinkedList<>();
    static Deque<Point>snake = new LinkedList<>();
    static int[] dx ={-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N+1][N+1];
        K = Integer.parseInt(br.readLine());
        for(int i=0;i<K;i++){
            StringTokenizer stk = new StringTokenizer(br.readLine()," ");
            x = Integer.parseInt(stk.nextToken());
            y = Integer.parseInt(stk.nextToken());
            board[x][y] = 1; //사과 위치 표시
        }
        L = Integer.parseInt(br.readLine());
        for(int i=0;i<L;i++){
            StringTokenizer stk = new StringTokenizer(br.readLine()," ");
            q.add(new commands(Integer.parseInt(stk.nextToken()),stk.nextToken().charAt(0)));
        }

        snake.add(new Point(1,1,3)); //동쪽
        board[1][1] = 3;
        int time = 0;

        while(true){
            x = snake.peekLast().x;
            y = snake.peekLast().y;
            dir = snake.peekLast().dir;
            time++;
            cx = x+dx[dir];
            cy = y+dy[dir];

            if(cx<1 || cy<1 || cx>N || cy>N||board[cx][cy]==3){
                break;
            }
            if(board[cx][cy]==1){
                board[cx][cy]=3;
            }else if(board[cx][cy]==0){
                board[cx][cy] = 3;
                board[snake.peekFirst().x][snake.peekFirst().y] = 0;
                snake.pollFirst();
            }

            if(!q.isEmpty() && q.peek().m==time){
                if(dir==0){ //북
                    if(q.peek().dir=='D'){
                        dir = 3;
                    }else{
                        dir = 2;
                    }
                }else if(dir==1){ //남
                    if(q.peek().dir=='D'){
                        dir = 2;
                    }else{
                        dir = 3;
                    }
                }else if(dir==2){ //서
                    if(q.peek().dir=='D'){
                        dir = 0;
                    }else{
                        dir = 1;
                    }
                }else if(dir==3){ //동
                    if(q.peek().dir=='D'){
                        dir = 1;
                    }else{
                        dir = 0;
                    }
                }
                q.poll();
            }
            snake.addLast(new Point(cx,cy,dir));
        }
        System.out.println(time);
    }

    private static class commands {
        int m;
        char dir;

        public commands(int m, char dir) {
            this.m = m;
            this.dir = dir;
        }
    }

    private static class Point {
        int x,y;
        int dir;

        public Point(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
}
