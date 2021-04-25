import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2573 {
    static int N,M;
    static int[][] iceberg;
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static Queue<Iceberg>q = new LinkedList<>();

    private static class Iceberg {
        int x,y;

        public Iceberg(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String NM = br.readLine();
        StringTokenizer stk = new StringTokenizer(NM," ");
        N=Integer.parseInt(stk.nextToken());
        M=Integer.parseInt(stk.nextToken());

        iceberg = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0;i<N;i++){
            String s = br.readLine();
            stk = new StringTokenizer(s," ");
            for(int j=0;j<M;j++){
                iceberg[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        /**
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                System.out.print(iceberg[i][j]+" ");
            }
            System.out.println();
        }
         **/

        int year = 0;
        while(true){
            //빙산 개수 세기
            for(boolean i[]: visited) Arrays.fill(i,false);
            int icebergCnt = countingIceberg();
            if(icebergCnt>=2)break;
            else if(icebergCnt==0){
                year=0;
                break;
            }
            q.clear();
            //빙산녹음
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(iceberg[i][j]!=0){
                        q.add(new Iceberg(i,j));
                    }
                }
            }
            melt();
            year++;

        }

        System.out.println(year);
    }

    private static void melt() {
        while(!q.isEmpty()){
            Iceberg tmp = q.poll();
            for(int i=0;i<4;i++){
                int cnt = 0;
                int mx = tmp.x+dx[i];
                int my = tmp.y+dy[i];
                if(!visited[mx][my] && iceberg[mx][my]==0){
                    cnt++;
                }
                iceberg[tmp.x][tmp.y] -= cnt;
                if(iceberg[tmp.x][tmp.y]<0)
                    iceberg[tmp.x][tmp.y]=0;
            }
        }
    }

    private static int countingIceberg() {
        int count = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(iceberg[i][j]!=0 && !visited[i][j]){
                    q.add(new Iceberg(i,j));
                    visited[i][j] = true;
                    count++;
                    bfs();

                }
            }
        }
        return count;
    }

    private static void bfs() {
        while(!q.isEmpty()){
            Iceberg tmp = q.poll();
            for(int i=0;i<4;i++){
                int mx = tmp.x + dx[i];
                int my = tmp.y + dy[i];
                if(mx<0||my<0||mx>=N||my>=M)continue;
                if(iceberg[mx][my]!=0 && !visited[mx][my]){
                    q.add(new Iceberg(mx,my));
                    visited[mx][my]=true;
                }
            }
        }
    }


}

