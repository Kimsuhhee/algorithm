import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj2842 {
    static int N, kCnt;
    static Node start;
    static char[][] area;
    static int[][] height;
    static ArrayList<Integer>hList;
    static boolean[][] visited;
    static Queue<Node>q;
    static int[] dx = {-1,-1,-1,0,1,1,1,0};
    static int[] dy = {-1,0,1,1,1,0,-1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        area = new char[N][N];
        height = new int[N][N];

        StringTokenizer stk;

        //초기화 - 마을 행렬
        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<N;j++){
                area[i][j] = s.charAt(j);
                if(area[i][j] == 'P') start = new Node(i,j);
                if(area[i][j] == 'K') kCnt++;
            }
        }

        hList = new ArrayList<>();

        //마을별 고도 행렬
        for(int i=0;i<N;i++){
            stk = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                height[i][j] = Integer.parseInt(stk.nextToken());
                if(!hList.contains(height[i][j])) {
                    hList.add(height[i][j]);
                }
            }
        }

        //행렬내에 존재하는 고도 리스트 정렬
        Collections.sort(hList);

        int st = 0, en = 0;
        int answer = 1000000;
        while(st <= en && en < hList.size()){
            int s = hList.get(st);
            int e = hList.get(en);
            if(bfs(s,e)){
                answer = Math.min(answer, e - s);
                st++;
            }else en++;
        }

        System.out.println(answer);

    }

    private static boolean bfs(int s, int e) {
        //출발점이 해당 구간에 속하지 않으면 bfs수행X
        if(height[start.x][start.y] < s || height[start.x][start.y] > e)return false;

        visited = new boolean[N][N];
        q = new LinkedList<>();

        q.add(start);
        visited[start.x][start.y] = true;

        int cnt = 0;

        while(!q.isEmpty()){
            Node cur = q.poll();
            int cx = cur.x;
            int cy = cur.y;
            if(cnt == kCnt)return true;
            for(int i=0;i<8;i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny])continue;
                if(height[nx][ny] >= s && height[nx][ny] <= e) { //해당구간에 속하면 
                    if (area[nx][ny] == 'K') cnt++;
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
