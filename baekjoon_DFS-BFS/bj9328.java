import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj9328 {
    static int T,h,w;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static char[][]map;
    static boolean[][]visited;
    static boolean[] keys;
    static Queue<Point>q;
    static Queue<Point>wq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while(T-- > 0) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            h = Integer.parseInt(stk.nextToken());
            w = Integer.parseInt(stk.nextToken());
            map = new char[h + 2][w + 2];
            for (int i = 0; i < h + 2; i++) {
                for (int j = 0; j < w + 2; j++) {
                    map[i][j] = '.';
                }
            }

            for (int i = 1; i <= h; i++) {
                String s = br.readLine();
                for (int j = 1; j <= w; j++) {
                    map[i][j] = s.charAt(j - 1);
                }
            }

            keys = new boolean[27];
            String s = br.readLine();
            if (!s.equals("0")) {
                for (int i = 0; i < s.length(); i++) {
                    keys[s.charAt(i)-'a'] = true;
                }
            }

            visited = new boolean[h + 2][w + 2];
            q = new LinkedList<>();
            wq = new LinkedList<>();

            q.add(new Point(0, 0));
            visited[0][0] = true;

            int cnt = 0;
            while (!q.isEmpty()) {
                Point cur = q.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];
                    if (nx < 0 || ny < 0 || nx >= h + 2 || ny >= w + 2) continue;
                    if (map[nx][ny]=='*')continue;
                    if (visited[nx][ny]) continue;

                    //다음칸이 열쇠가 있는 칸이라면
                    if (map[nx][ny] >= 'a' && map[nx][ny] <= 'z') {
                        //열쇠 정보 업데이트
                        keys[map[nx][ny]-'a'] = true;
                        visited[nx][ny] = true;
                        q.add(new Point(nx, ny));
                        map[nx][ny] = '.';

                        //대기 큐의 사이즈 만큼 반복문 돌면서 해당 칸을 방문 할 수 있게 되었다면 q에 넣기
                        int size = wq.size();
                        while(size-- > 0){
                            Point p = wq.poll();
                            if(keys[map[p.x][p.y]-'A'])q.add(p);
                            else wq.add(p);
                        }
                    }
                    //다음칸이 문이라면
                    else if (map[nx][ny] >= 'A' && map[nx][ny] <= 'Z') {
                        //해당 문을 열 수 있는 열쇠를 가지고 있음
                        if (keys[map[nx][ny]-'A']) {
                            visited[nx][ny] = true;
                            q.add(new Point(nx, ny));
                            map[nx][ny] = '.';
                        }else { //해당 문을 열 수 있는 열쇠를 가지고 있지않은 경우 대기 큐에 넣기
                            wq.add(new Point(nx,ny));
                        }
                    }else if(map[nx][ny]=='.'){
                        visited[nx][ny] = true;
                        q.add(new Point(nx,ny));
                    }else if(map[nx][ny]=='$'){
                        visited[nx][ny] = true;
                        q.add(new Point(nx,ny));
                        cnt++;
                        map[nx][ny] = '.';
                    }
                }
            }
            sb.append(cnt+"\n");
        }
        System.out.print(sb);
    }

    private static class Point {
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
