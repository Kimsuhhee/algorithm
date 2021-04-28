import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class bj2667 {
    static int N;
    static int map[][];
    static boolean visited[][];
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static Queue<Point>q = new LinkedList<>();
    static int cnt;

    private static class Point {
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<N;j++){
                map[i][j] = s.charAt(j)-'0';
            }
        }

        ArrayList<Integer> list = new ArrayList();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j]==1 && !visited[i][j]){
                    q.add(new Point(i,j));
                    visited[i][j] = true;
                    cnt = 0;
                    bfs();
                    list.add(cnt);
                }
            }
        }

        Collections.sort(list);
        bw.write(list.size()+"\n");
        for(int a : list)bw.write(a+"\n");

        bw.flush();
        br.close();
        bw.close();

    }

    private static void bfs() {
        while(!q.isEmpty()){
            cnt++;
            Point tmp = q.poll();
            for(int i=0;i<4;i++){
                int mx = tmp.x+dx[i];
                int my = tmp.y+dy[i];
                if(mx<0||my<0||mx>=N||my>=N)continue;
                if(map[mx][my]==1 && !visited[mx][my]){
                    q.add(new Point(mx,my));
                    visited[mx][my] = true;
                }
            }
        }
    }

}
