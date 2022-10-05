import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj4991 {
    static int w,h;
    static char[][] map;
    static int[][][] visited;
    static Node start;
    static List<Node> dustList;
    static Queue<Node> q;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk;

        while(true) {
            stk = new StringTokenizer(br.readLine());
            w = Integer.parseInt(stk.nextToken());
            h = Integer.parseInt(stk.nextToken());

            if(w == 0 && h == 0)break;

            dustList = new ArrayList<>();
            q = new LinkedList<>();
            map = new char[h][w];
            int idx = 0;
            for (int i = 0; i < h; i++) {
                String s = br.readLine();
                for (int j = 0; j < w; j++) {
                    if (s.charAt(j) == 'o') {
                        start = new Node(i, j, 0);
                    } else if (s.charAt(j) == '*') {
                        dustList.add(new Node(i, j, idx++));
                    }
                    map[i][j] = s.charAt(j);
                }
            }

            //로봇 청소기는 같은 칸을 여러번 방문 할 수 있음
            visited = new int[h][w][1 << dustList.size()];
            q.add(start);
            visited[start.x][start.y][0] = 0;

            int answer = -1;
            while (!q.isEmpty()) {
                Node node = q.poll();
                int cx = node.x;
                int cy = node.y;
                if (node.state == (1 << dustList.size())-1) {
                    answer = visited[cx][cy][node.state];
                    break;
                }
                for (int i = 0; i < 4; i++) {
                    int nx = cx + dx[i];
                    int ny = cy + dy[i];
                    if (nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
                    //이동할 칸에 가구가 있다면 이동 할 수 없음
                    if (map[nx][ny] == 'x') continue;
                    //이동할 칸이 깨끗한 칸인 경우
                    if (map[nx][ny] == '.' || map[nx][ny] == 'o') {
                        if (visited[nx][ny][node.state] == 0 || visited[nx][ny][node.state] > visited[cx][cy][node.state] + 1) {
                            visited[nx][ny][node.state] = visited[cx][cy][node.state] + 1;
                            q.add(new Node(nx, ny, node.state));
                        }
                    } else { //이동할 칸이 더러운 칸인 경우
                        //더러운칸의 index를 알아와야함
                        int dustIdx = 0;
                        for (Node dust : dustList) {
                            if (dust.x == nx && dust.y == ny) {
                                dustIdx = dust.state;
                                break;
                            }
                        }
                        //현재 상태에서 더러운 칸을 이미 청소 했다면 다음턴으로 넘어감
                        if ((node.state & (1 << dustIdx)) == 0) {
                            //청소하지 않았다면 다음칸을 청소하러 이동
                            visited[nx][ny][(node.state | (1 << dustIdx))] = visited[cx][cy][node.state] + 1;
                            q.add(new Node(nx, ny, (node.state | (1 << dustIdx))));
                        }else {
                            if (visited[nx][ny][node.state] == 0 || visited[nx][ny][node.state] > visited[cx][cy][node.state] + 1) {
                                visited[nx][ny][node.state] = visited[cx][cy][node.state] + 1;
                                q.add(new Node(nx, ny, node.state));
                            }
                        }
                    }
                }
            }
            System.out.println(answer);
        }
    }

    public static class Node{
        int x, y, state;

        public Node(int x, int y, int state) {
            this.x = x;
            this.y = y;
            this.state = state;
        }
    }
}
