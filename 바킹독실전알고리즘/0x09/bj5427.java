import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj5427 {
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static Area person;
    static Queue<Area>fq ;
    static int answer;
    static boolean flag;
    static int w, h;
    static StringBuilder sb = new StringBuilder();

    private static class Area {
        int x, y;

        public Area(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            answer = 0;
            flag = false;
            String wh = br.readLine();
            StringTokenizer stk = new StringTokenizer(wh," ");
            w = Integer.parseInt(stk.nextToken());
            h = Integer.parseInt(stk.nextToken());

            map = new char[h+1][w+1];
            visited = new boolean[h+1][w+1];
            fq = new LinkedList<>();


            //불의 위치와 상근이의 위치를 각각 저장해둠
            for(int i=0;i<h;i++){
                String s = br.readLine();
                for(int j=0;j<w;j++){
                    map[i][j] = s.charAt(j);
                    if(map[i][j]=='@'){
                        person = new Area(i,j);
                    }
                    if(map[i][j]=='*'){
                        fq.add(new Area(i,j));
                        visited[i][j] = true;
                    }
                }
            }


            bfs();
            if(!flag) sb.append("IMPOSSIBLE").append("\n");
        }

        System.out.println(sb);

    }

    private static void bfs() {
        Queue<Area> sq = new LinkedList<>();
        sq.add(person);

        while(!sq.isEmpty()) {
            int fqSize = fq.size();
            Area tmp;
            answer++;

            //불 전파
            while (fqSize-- > 0) {
                tmp = fq.poll();
                for (int i = 0; i < 4; i++) {
                    int mx = tmp.x + dx[i];
                    int my = tmp.y + dy[i];
                    if (mx < 0 || my < 0 || mx >= h || my >= w) continue;
                    if (map[mx][my] == '#'||map[mx][my]=='*') continue;
                    map[mx][my] = '*';
                    fq.add(new Area(mx, my));
                }
            }

            int sqSize = sq.size();
            //상근이의탈출
            while (sqSize-- > 0) {
                tmp = sq.poll();
                for (int i = 0; i < 4; i++) {
                    int mx = tmp.x + dx[i];
                    int my = tmp.y + dy[i];
                    if (mx < 0 || my < 0 || mx >= h || my >= w){
                        flag = true;
                        sb.append(answer).append("\n");
                        return;
                    }
                    if (map[mx][my]=='*'|| map[mx][my]=='#'||visited[mx][my])continue;

                    visited[mx][my] = true;
                    sq.add(new Area(mx,my));
                }
            }
        }
    }

}

