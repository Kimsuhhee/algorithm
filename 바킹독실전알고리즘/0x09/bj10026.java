import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class bj10026 {
    static int N;
    static char[][]area;
    static boolean[][]visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static Queue<Area>q = new LinkedList<>();

    private static class Area {
        int x,y;
        char word;

        public Area(int x, int y, char word) {
            this.x = x;
            this.y = y;
            this.word = word;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        area = new char[N][N];
        visited = new boolean[N][N];

        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<N;j++){
                area[i][j] = s.charAt(j);
            }
        }
        int cnt = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j]) {
                    q.add(new Area(i, j, area[i][j]));
                    visited[i][j] = true;
                    cnt++;
                    bfs();
                }
            }
        }
        bw.write(cnt+" ");
        for(boolean i[]:visited) Arrays.fill(i,false);
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(area[i][j]=='G'){
                    area[i][j]='R';
                }
            }
        }
        cnt=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j]){
                    q.add(new Area(i, j, area[i][j]));
                    visited[i][j] = true;
                    cnt++;
                    bfs();
                }
            }
        }
        bw.write(cnt+" ");
        bw.flush();
        br.close();
        bw.close();
    }

    private static void bfs() {
        while(!q.isEmpty()){
            Area tmp = q.poll();
            for(int i=0;i<4;i++){
                int mx = tmp.x+ dx[i];
                int my = tmp.y+ dy[i];
                if(mx<0||my<0||mx>=N||my>=N)continue;
                if(area[mx][my]==tmp.word && !visited[mx][my]){
                    q.add(new Area(mx,my,area[mx][my]));
                    visited[mx][my] = true;
                }
            }
        }
    }

}
