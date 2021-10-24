import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj17836 {
    static int N,M,T;
    static int[][]castle;
    static int[][][]d;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        T = Integer.parseInt(stk.nextToken());

        castle = new int[N][M];
        for(int i=0;i<N;i++){
            stk = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                castle[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        d = new int[N][M][2]; //0: 그람x, 1: 그람o

        Queue<Point>q = new LinkedList<>();
        q.add(new Point(0,0,0,0));
        d[0][0][0] = 1;

        int answer = 0;

        while(!q.isEmpty()){
            Point p = q.poll();
            int gram = p.gram;
            if(p.time>T)break; //T시간을 넘음
            if(p.x==N-1 && p.y==M-1){ //공주를 찾음
                answer = p.time;
                break;
            }
            if(castle[p.x][p.y]==2)gram = 1;

            for(int i=0;i<4;i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx<0||nx>=N||ny<0||ny>=M)continue;
                if(gram==0){ //그람을 찾지못함
                    if(d[nx][ny][gram]==0 && castle[nx][ny]!=1){ //방문여부와 벽이아닌지 확인
                        d[nx][ny][gram] = p.time + 1;
                        q.add(new Point(nx,ny,p.time+1,gram));
                    }
                }else if(gram==1){ //그람을 사용
                    if(d[nx][ny][gram]==0){ //벽이 있어도 가능함 방문여부만 확인
                        d[nx][ny][gram] = p.time + 1;
                        q.add(new Point(nx,ny,p.time+1,gram));
                    }
                }
            }
        }

        if(answer==0) System.out.println("Fail");
        else System.out.println(answer);

    }

    private static class Point {
        int x,y,time,gram;

        public Point(int x, int y, int time, int gram) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.gram = gram;
        }
    }
}
