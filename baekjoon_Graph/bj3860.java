import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj3860 {
    static int W,H,G,E;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] cemetry; // 묘비 : -1, 귀신구멍 : -2
    static ArrayList<Info>list;
    static int[][] dist;
    static boolean isCycle;
    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk;
        StringBuilder sb = new StringBuilder();

        while(true){
            stk = new StringTokenizer(br.readLine());
            W = Integer.parseInt(stk.nextToken());
            H = Integer.parseInt(stk.nextToken());
            cemetry = new int[H][W];
            if(W==0 && H==0)break;
            G = Integer.parseInt(br.readLine());
            for(int i=0;i<G;i++){
                stk = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(stk.nextToken());
                int y = Integer.parseInt(stk.nextToken());
                cemetry[y][x] = -1;
            }

            list = new ArrayList<>();
            E = Integer.parseInt(br.readLine());
            for(int i=0;i<E;i++){
                stk = new StringTokenizer(br.readLine());
                int x1 = Integer.parseInt(stk.nextToken());
                int y1 = Integer.parseInt(stk.nextToken());
                int x2 = Integer.parseInt(stk.nextToken());
                int y2 = Integer.parseInt(stk.nextToken());
                int T = Integer.parseInt(stk.nextToken());
                cemetry[y1][x1] = -2;
                list.add(new Info(y1,x1,y2,x2,T));
            }

            addList();

            isCycle = false;
            bellmanford();

            if(isCycle){
                sb.append("Never"+"\n");
            }else{
                if(dist[H-1][W-1]==Integer.MAX_VALUE){
                    sb.append("Impossible"+"\n");
                }else sb.append(dist[H-1][W-1]+"\n");
            }
        }
        System.out.print(sb);
    }

    private static void bellmanford() {
        dist = new int[H][W];
        for(int i=0;i<H;i++){
            for(int j=0;j<W;j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dist[0][0] = 0;

        for(int i=0;i<W*H;i++){
            int size = list.size();
            for(int j=0;j<size;j++){
                Info cur = list.get(j);
                if(dist[cur.sy][cur.sx]!=Integer.MAX_VALUE){
                   if(dist[cur.ey][cur.ex] > dist[cur.sy][cur.sx] + cur.cost){
                       dist[cur.ey][cur.ex] = dist[cur.sy][cur.sx] + cur.cost;
                   }
                }
            }
        }

        int size = list.size();
        for(int j=0;j<size;j++){
            Info cur = list.get(j);
            if(dist[cur.sy][cur.sx]!=Integer.MAX_VALUE){
                if(dist[cur.ey][cur.ex] > dist[cur.sy][cur.sx] + cur.cost){
                    isCycle = true;
                    return;
                }
            }
        }
    }

    private static void addList() {
        //각 지점에 인접한 지점을 연결함
        for(int i=0;i<H;i++){
            for(int j=0;j<W;j++){
                // 현재 위치가 묘비거나 귀신구멍이거나 도착지면 연결할 필요 없음
                if(cemetry[i][j]!=0 || (i==H-1 && j==W-1))continue;
                for(int d=0;d<4;d++){
                    int nx = i+dx[d];
                    int ny = j+dy[d];
                    //다음 위치가 영역을 벗어나지 않고 묘비가 아니면 연결
                    //묘비칸은 갈 수 없음, 귀신구멍이나 도착지는 갈 수 있음
                    if(nx<0||ny<0||nx>=H||ny>=W)continue;
                    if(cemetry[nx][ny]==-1)continue;
                    list.add(new Info(i,j,nx,ny,1));
                }
            }
        }
    }

    private static class Info {
        int sx,sy,ex,ey,cost;

        public Info(int sy, int sx, int ey, int ex, int cost) {
            this.sy = sy;
            this.sx = sx;
            this.ey = ey;
            this.ex = ex;
            this.cost = cost;
        }
    }
}
