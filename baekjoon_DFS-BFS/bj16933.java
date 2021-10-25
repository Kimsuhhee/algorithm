import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj16933 {
    static int N,M,K;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int[][] map;
    static boolean[][][][]visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());

        map = new int[N][M];
        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = s.charAt(j)-'0';
            }
        }

        visited = new boolean[2][N][M][K+1]; // 0:낮, 1:밤
        Queue<Point>q = new LinkedList<>();
        q.add(new Point(0,0,0,1,true));
        visited[0][0][0][0] = true;

        int answer = -1;
        while(!q.isEmpty()){
            Point cur = q.poll();
            int cx = cur.x;
            int cy = cur.y;
            int cnt = cur.cnt;
            boolean dayAndNight = cur.dayAndNight;
            if(cnt>K)break;
            if(cx==N-1 && cy==M-1){
                answer = cur.dist;
                break;
            }
            
            for(int i=0;i<4;i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(nx<0||ny<0||nx>=N||ny>=M)continue;

                //낮
                //벽이아닌곳 - > 방문여부 확인
                //벽인곳 - > 방문여부, 부실수 있는지 확인
                //이동X - > 현재 위치를 밤에 방문한적 있는지 확인
                if(dayAndNight){
                    if(map[nx][ny]==0 && !visited[1][nx][ny][cnt]){
                        visited[1][nx][ny][cnt] = true;
                        q.add(new Point(nx,ny,cnt,cur.dist+1,!dayAndNight));
                    }
                    if(map[nx][ny]==1 && cnt+1<=K && !visited[1][nx][ny][cnt+1]){
                        visited[1][nx][ny][cnt+1] = true;
                        q.add(new Point(nx,ny,cnt+1,cur.dist+1,!dayAndNight));
                    }
                    if(!visited[1][cx][cy][cnt]){
                        visited[1][cx][cy][cnt] = true;
                        q.add(new Point(cx,cy,cnt,cur.dist+1,!dayAndNight));
                    }
                }else{
                    //밤
                    //벽이아닌곳 - > 방문여부 확인
                    //이동X - > 현재 위치를 낮에 방문한적 있는지 확인
                    if(map[nx][ny]==0 && !visited[0][nx][ny][cnt]){
                        visited[0][nx][ny][cnt] = true;
                        q.add(new Point(nx,ny,cnt,cur.dist+1,!dayAndNight));
                    }
                    if(!visited[0][cx][cy][cnt]){
                        visited[0][cx][cy][cnt] = true;
                        q.add(new Point(cx,cy,cnt,cur.dist+1,!dayAndNight));
                    }

                }
            }
        }
        System.out.println(answer);

    }

    private static class Point {
        int x,y,cnt,dist;
        boolean dayAndNight;

        public Point(int x, int y, int cnt, int dist, boolean dayAndNight) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.dist = dist;
            this.dayAndNight = dayAndNight;
        }
    }
}
