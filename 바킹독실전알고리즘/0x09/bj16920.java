import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj16920 {
    static int N,M,P;
    static int[] order;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static char[][] map;
    static int[] count;
    static boolean[][] visited;
    static Queue<Point>q[];

    private static class Point {
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        P = Integer.parseInt(stk.nextToken());

        map = new char[N][M];
        count = new int[P];
        visited = new boolean[N][M];
        order = new int[P];
        q = new LinkedList[P];

        stk = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<P;i++) {
            order[i] = Integer.parseInt(stk.nextToken());
            q[i] = new LinkedList<Point>();
        }
        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = s.charAt(j);
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                int tmp = map[i][j]-'0';
                if(tmp>0 && tmp<10){
                    q[tmp-1].add(new Point(i,j));
                }
            }
        }

        while(true) {
            int size = 0;
            for(int i=0;i<P;i++){
                if(q[i].size()==0)size++;
            }
            if(size==P)break;

            for (int player = 1; player <= P; player++) {
                for(int k=0;k<order[player-1];k++) {
                    int qsize = q[player-1].size();
                    if(qsize==0)break;
                        while (qsize-- > 0) {
                            Point tmp = q[player-1].poll();
                            for (int i = 0; i < 4; i++) {
                                int x = tmp.x + dx[i];
                                int y = tmp.y + dy[i];
                                if (x < 0 || y < 0 || x >= N || y >= M) continue;
                                if (map[x][y] == '.' && !visited[x][y]) {
                                    map[x][y] = Character.forDigit(player, 10);
                                    q[player-1].add(new Point(x,y));
                                    visited[x][y] = true;
                                }
                            }
                        }
                }
            }

        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if((map[i][j]-'0')>0 && (map[i][j]-'0')<10) {
                    count[(map[i][j] - '0') - 1]++;
                }
            }
        }

        for(int c : count) System.out.print(c+" ");

    }

}
