import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj7569 {
    static int N,M,H; //M:가로, N:세로, H:높이
    static int[][][] tomato;
    static int[][][] visited;
    static int[] dx = {0,0,-1,+1,0,0}; 
    static int[] dy = {0,0,0,0,-1,+1}; 
    static int[] dz = {-1,+1,0,0,0,0}; 

    private static class Tomatos {
        int x;
        int y;
        int z;

        public Tomatos(int z, int y, int x) {
            this.z = z;
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(stk.nextToken());  //가로
        N = Integer.parseInt(stk.nextToken());  //세로
        H = Integer.parseInt(stk.nextToken());  //높이

        visited = new int[H + 1][N + 1][M + 1];
        tomato = new int[H + 1][N + 1][M + 1];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                stk = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < M; k++) {
                    tomato[i][j][k] = Integer.parseInt(stk.nextToken());
                }
            }
        }

        Queue<Tomatos>q = new LinkedList<>();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if(tomato[i][j][k]==1)
                        q.add(new Tomatos(i,j,k));
                }
            }
        }

        while(!q.isEmpty()){
            Tomatos tmp = q.poll();
            int oz = tmp.z;
            int ox = tmp.x;
            int oy = tmp.y;
            for(int i=0;i<6;i++){
                int cz = oz+dz[i];
                int cx = ox+dx[i];
                int cy = oy+dy[i];
                if(cz<0 || cx<0 || cy<0 || cz>=H || cx>=M || cy>=N) continue;
                    if(tomato[cz][cy][cx] == 0 && visited[cz][cy][cx] == 0) {
                        q.add(new Tomatos(cz,cy,cx));
                        visited[cz][cy][cx]=1;
                        tomato[cz][cy][cx] = tomato[oz][oy][ox]+1;
                    }
            }
        }

        int m = Integer.MIN_VALUE;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if(tomato[i][j][k]==0){
                        System.out.println(-1);return;
                    }
                    m = Math.max(m, tomato[i][j][k]);
                }
            }
        }
        System.out.println(m-1);
    }
}
