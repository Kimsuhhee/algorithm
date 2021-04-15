import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj7562 {
    static int T,l; // T: 테스트케이스의 개수, l: 가로세로길이
    static int sx,sy,ex,ey; //출발x,y 도착x,y
    static int[][] knight;
    static int[] dx = {-1,1,2,2,1,-1,-2,-2};
    static int[] dy = {2,2,1,-1,-2,-2,-1,1};
    static Queue<Knight>q = new LinkedList<>();

    private static class Knight {
        int x;
        int y;

        public Knight(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++){
            l =Integer.parseInt(br.readLine());

            stk = new StringTokenizer(br.readLine());
            sx = Integer.parseInt(stk.nextToken());
            sy = Integer.parseInt(stk.nextToken());

            stk = new StringTokenizer(br.readLine());
            ex = Integer.parseInt(stk.nextToken());
            ey = Integer.parseInt(stk.nextToken());

            knight = new int[301][301];

            q.add(new Knight(sx,sy));
            bfs();
            sb.append(knight[ey][ex]).append("\n");
            for(int a=0;a<l+1;a++){
                Arrays.fill(knight[i],0);
                q.clear();
            }
        }
        System.out.println(sb);
    }

    private static void bfs() {
        while(!q.isEmpty()) {
            Knight tmp = q.poll();
            int ox = tmp.x;
            int oy = tmp.y;
            if(ox==ex && oy==ey)break;
            for(int i=0;i<8;i++){
                int cx = ox + dx[i];
                int cy = oy + dy[i];
                if(cx>=0 && cy>=0 && cx<l && cy<l){
                    if(knight[cy][cx]==0 || knight[oy][ox]+1<knight[cy][cx]){
                        knight[cy][cx] = knight[oy][ox]+1;
                        q.add(new Knight(cx,cy));
                    }
                }
            }
        }
     }
}
