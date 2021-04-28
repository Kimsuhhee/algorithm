import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj6593 {
    static int l,r,c,result;
    static char[][][] building;
    static int[][][] dist;
    static int[] dx = {1,-1,0,0,0,0};
    static int[] dy = {0,0,1,-1,0,0};
    static int[] dz = {0,0,0,0,1,-1};
    static Queue<Point>q = new LinkedList<>();

    private static class Point {
        int z,x,y;

        public Point(int z, int x, int y) {
            this.z = z;
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            String lrc = br.readLine();
            StringTokenizer stk = new StringTokenizer(lrc," ");

            l = Integer.parseInt(stk.nextToken());
            r = Integer.parseInt(stk.nextToken());
            c = Integer.parseInt(stk.nextToken());
            if(l==0 && r==0 && c==0)break;

            building = new char[l][r][c];
            dist = new int[l][r][c];
            q.clear();
            result = 0;

            for(int i=0;i<l;i++){
                for(int j=0;j<r;j++){
                    String tmp = br.readLine();
                    for(int k=0;k<c;k++){
                        building[i][j][k] = tmp.charAt(k);
                        if(building[i][j][k] == 'S'){
                            q.add(new Point(i,j,k));
                            dist[i][j][k] = 1;
                        }
                    }
                }
                br.readLine();
            }

            if(bfs()) sb.append("Escaped in "+result+" minute(s).").append("\n");
            else sb.append("Trapped!").append("\n");

        }
        System.out.println(sb);
    }

    private static boolean bfs() {
        while(!q.isEmpty()) {
            Point tmp = q.poll();
            for (int i = 0; i < 6; i++) {
                int mx = tmp.x + dx[i];
                int my = tmp.y + dy[i];
                int mz = tmp.z + dz[i];
                if (mx < 0 || my < 0 || mz < 0 || mz >= l || my >= c || mx >= r) continue;
                if (building[mz][mx][my] != '#' && dist[mz][mx][my] == 0) {
                        dist[mz][mx][my] = dist[tmp.z][tmp.x][tmp.y] + 1;
                        q.add(new Point(mz, mx, my));
                }
                if(building[mz][mx][my]=='E'){
                    result = dist[tmp.z][tmp.x][tmp.y];
                    return true;
                }
            }

        }
        return false;
    }

}
