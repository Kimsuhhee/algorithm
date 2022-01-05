import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj16932 {
    static int N,M;
    static int[][] arr;
    static int[] groups;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static ArrayList<Point>zeroList;
    static Queue<Point>q;
    static boolean[][]visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        arr = new int[N][M];
        for(int i=0;i<N;i++){
            stk = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                arr[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        zeroList = new ArrayList<>();
        groups = new int[1000001];
        int idx = 1;
        visited = new boolean[N][M];
        q = new LinkedList<>();

        //그룹화
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(arr[i][j]==0)zeroList.add(new Point(i,j));
                if(arr[i][j]!=0 && !visited[i][j]){
                    visited[i][j] = true;
                    arr[i][j] = idx;
                    q.add(new Point(i,j));
                    groups[idx] = grouping(idx);
                    idx++;
                }
            }
        }

        int max = -1;
        for(Point p:zeroList){
            int cnt = 1;
            HashSet<Integer>set = new HashSet<>();
            for(int i=0;i<4;i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx<0||ny<0||nx>=N||ny>=M)continue;
                if(arr[nx][ny]==0)continue;
                set.add(arr[nx][ny]);
            }
            Iterator<Integer>it = set.iterator();
            while(it.hasNext()){
                cnt += groups[it.next()];
            }
            max = Math.max(max,cnt);
        }

        System.out.println(max);
    }

    private static int grouping(int g) {
        int cnt = 1;
        while(!q.isEmpty()){
            Point p = q.poll();
            for(int i=0;i<4;i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx<0||ny<0||nx>=N||ny>=M)continue;
                if(visited[nx][ny])continue;
                if(arr[nx][ny]==0)continue;
                arr[nx][ny] = g;
                visited[nx][ny] = true;
                q.add(new Point(nx,ny));
                cnt++;
            }
        }
        return cnt;
    }

    private static class Point {
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
