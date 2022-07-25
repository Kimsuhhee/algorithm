import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1981 {
    static int n;
    static int[][] arr;
    static int maxV = 0;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static boolean[][] visited;
    static Queue<Node>q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        StringTokenizer stk;

        for(int i=0;i<n;i++){
            stk = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                arr[i][j] = Integer.parseInt(stk.nextToken());
                maxV = Math.max(maxV, arr[i][j]);
            }
        }

        int answer = 0;

        int st = 0, en = maxV;
        while(st <= en){
            //최댓값 - 최솟값
            int mid = (st + en)/2;
            
            if(function(mid)) { 
                answer = mid;
                en = mid -1;
            }
            else st = mid + 1;
        }

        System.out.println(answer);

    }

    private static boolean function(int mid) {
        for(int s = 0 ; s + mid <= 200 ; s++) {
            if(arr[0][0] >= s && arr[0][0] <= s + mid) {  //출발점이 해당 영역에 속하면 bfs수행
                if (bfs(s, s + mid)) return true; //해당 구간내에서 bfs수행할 수 있으면 true반환
            }
        }
        return false;
    }

    private static boolean bfs(int s, int e) {
        visited = new boolean[n][n];
        visited[0][0] = true;
        q = new LinkedList<>();
        q.add(new Node(0, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();
            int cx = cur.x;
            int cy = cur.y;
            if(cx == n-1 && cy == n-1)return true;
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n || visited[nx][ny]) continue;
                if(arr[nx][ny] >= s && arr[nx][ny] <= e) { //구간에 속하는지 체크
                    q.add(new Node(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
        return false;
    }

    private static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
