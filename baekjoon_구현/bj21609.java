import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj21609 {
    static int N,M,sum;
    static int[][] block;
    static boolean[][] visited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static PriorityQueue<Group>pq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        block = new int[N][N];
        for(int i=0;i<N;i++){
            stk = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                block[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        while(true) {
            if(!findBlock())break;
            remove();
            gravity();
            rotate();
            gravity();
        }
        System.out.println(sum);

    }

    private static boolean findBlock() {
        pq = new PriorityQueue<>();
        visited = new boolean[N][N];
        ArrayList<Point>zero;
        Queue<Point>q;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(block[i][j]>=1 && !visited[i][j]){
                    q = new LinkedList<>();
                    q.add(new Point(i,j,block[i][j]));
                    visited[i][j] = true;
                    zero = new ArrayList<>();
                    int group = 0, rainbow = 0;
                    while(!q.isEmpty()){
                        Point p = q.poll();
                        group++;
                        if(block[p.x][p.y]==0){
                            zero.add(new Point(p.x,p.y,block[p.x][p.y]));
                            rainbow++;
                        }
                        for(int d=0;d<4;d++){
                            int nx = p.x + dx[d];
                            int ny = p.y + dy[d];
                            if(nx<0||ny<0||nx>=N||ny>=N)continue;
                            if(visited[nx][ny])continue;
                            if(block[nx][ny]==0 || block[nx][ny]==p.color){
                                q.add(new Point(nx,ny,p.color));
                                visited[nx][ny] = true;
                            }
                        }
                    }

                    //무지개 블록은 다음번에도 탐색 가능 하도록 방문안함처리
                    for(Point p:zero){
                        visited[p.x][p.y] = false;
                    }

                    //블록그룹조건에 안맞으면 순서 넘기기
                    if(group<2 || (group - rainbow)<1) continue;

                    //블록그룹조건에 맞으면 우선순위큐에 넣기
                    pq.add(new Group(i,j,group,rainbow));
                }
            }
        }

        if(pq.size()==0)return false;
        else return true;
    }

    private static void remove() {
        Queue<Point>q = new LinkedList<>();
        visited = new boolean[N][N];

        Group g = pq.poll(); //크기가 가장 큰 그룹
        q.add(new Point(g.x,g.y,block[g.x][g.y]));
        visited[g.x][g.y] = true;
        while(!q.isEmpty()){
            Point p = q.poll();
            block[p.x][p.y] = -7;
            for(int i=0;i<4;i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx<0||ny<0||nx>=N||ny>=N)continue;
                if(visited[nx][ny])continue;
                if(block[nx][ny]==0 || block[nx][ny]==p.color){
                    q.add(new Point(nx,ny,p.color));
                    visited[nx][ny] = true;
                }
            }
        }
        sum+=(g.cnt*g.cnt);
    }

    private static void rotate() {
        int[][] temp = new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                temp[i][j] = block[i][j];
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                block[i][j] = temp[j][N-1-i];
            }
        }
    }

    private static void gravity() {
        for(int y=0;y<N;y++){
            int x = N;
            while(x-- > 0){
                if(block[x][y]>=-1)continue;
                if(block[x][y]==-7){
                    int i = x;
                    while(i-- > 0){
                        if(block[i][y]>=0){
                            int temp = block[i][y];
                            block[i][y] = -7;
                            block[x][y] = temp;
                            break;
                        }
                        if(block[i][y]==-1)break;
                    }
                }
            }
        }
    }


    private static class Point {
        int x,y,color;

        public Point(int x, int y, int color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }
    }

    private static class Group implements Comparable<Group>{
        int x,y,cnt,rainbow;

        public Group(int x, int y, int cnt, int rainbow) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.rainbow = rainbow;
        }

        @Override
        public int compareTo(Group o) {
            if(this.cnt==o.cnt){
                if(this.rainbow==o.rainbow){
                    if(this.x==o.x){
                        return o.y - this.y;
                    }else return o.x - this.x;
                }else return o.rainbow - this.rainbow;
            }else return o.cnt - this.cnt;
        }
    }
}
