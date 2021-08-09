import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj15683 {
    static int N,M;
    static int min = Integer.MAX_VALUE;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int[] combination;
    static int[][] temp;
    static List<Point>cctvList = new ArrayList<>();
    static int[][] room;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        room = new int[N][M]; //0:빈칸, 6:벽, 1-5:cctv
        for(int i=0;i<N;i++){
            stk = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                room[i][j] = Integer.parseInt(stk.nextToken());
                if(room[i][j]!=0 && room[i][j]!=6)
                    cctvList.add(new Point(i,j,room[i][j],directionSize(room[i][j])));
            }
        }

        combination = new int[cctvList.size()];
        permutation(0);
        System.out.println(min);
    }

    private static void permutation(int n) {
        if(n==cctvList.size()){

            //사각지대 영역 구하기
            temp = new int[N][M];
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    temp[i][j] = room[i][j];
                }
            }
            for(int i=0;i< cctvList.size();i++){
                spread(cctvList.get(i),combination[i]);
            }
            min = Math.min(min,cntArea());

            /**
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    System.out.print(temp[i][j]+" ");
                }
                System.out.println();
            }
             **/

            return;
        }

        for(int i=0;i<cctvList.get(n).size;i++){
            combination[n] = i;
            permutation(n + 1);
        }
    }

    private static int cntArea() {
        int cnt=0;
        for(int i=0;i<N;i++) {
            for (int j = 0; j < M; j++) {
                if(temp[i][j]==0)cnt++;
            }
        }
        return cnt;
    }

    private static void spread(Point cctv, int d) {
        if(cctv.cctv==1){
            if(d==0)bfs(cctv,1,0);
            if(d==1)bfs(cctv,1,1);
            if(d==2)bfs(cctv,1,2);
            if(d==3)bfs(cctv,1,3);
        }else if(cctv.cctv==2){
            if(d==0){
                bfs(cctv,2,0);
                bfs(cctv,2,2);
            }
            if(d==1){
                bfs(cctv,2,1);
                bfs(cctv,2,3);
            }
        }else if(cctv.cctv==3){
            if(d==0){
                bfs(cctv,3,0);
                bfs(cctv,3,1);
            }
            if(d==1){
                bfs(cctv,3,1);
                bfs(cctv,3,2);
            }
            if(d==2){
                bfs(cctv,3,2);
                bfs(cctv,3,3);
            }
            if(d==3){
                bfs(cctv,3,3);
                bfs(cctv,3,0);
            }
        }else if(cctv.cctv==4){
            if(d==0){
                bfs(cctv,4,0);
                bfs(cctv,4,1);
                bfs(cctv,4,2);
            }
            if(d==1){
                bfs(cctv,4,1);
                bfs(cctv,4,2);
                bfs(cctv,4,3);
            }
            if(d==2){
                bfs(cctv,4,2);
                bfs(cctv,4,3);
                bfs(cctv,4,0);
            }
            if(d==3){
                bfs(cctv,4,3);
                bfs(cctv,4,0);
                bfs(cctv,4,1);
            }
        }else{
            bfs(cctv,5,0);
            bfs(cctv,5,1);
            bfs(cctv,5,2);
            bfs(cctv,5,3);
        }
    }

    private static void bfs(Point cctv, int cctvNum, int d) {
        Queue<Point>q = new LinkedList<>();
        q.add(cctv);
        while(!q.isEmpty()){
            Point point = q.poll();
            int x = point.x;
            int y = point.y;
            int cx = x+dx[d];
            int cy = y+dy[d];
            if(cx<0||cy<0||cx>=N||cy>=M)continue;
            if(temp[cx][cy]==6)continue;
            if(temp[cx][cy]==0){
                temp[cx][cy] = -1;
            }
            q.add(new Point(cx,cy,cctvNum,d));
        }
    }

    private static int directionSize(int d) {
        if(d==1||d==3||d==4) d = 4;
        else if(d==2) d = 2;
        else if(d==5) d = 1;

        return d;
    }


    private static class Point {
        int x,y,cctv,size;

        public Point(int x, int y, int cctv, int size) {
            this.x = x;
            this.y = y;
            this.cctv = cctv;
            this.size = size;
        }
    }
}
