import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj17472 {
    static int N,M;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int[][] map;
    static boolean[][] visited;
    static Queue<Node>q;
    static PriorityQueue<Node>pq;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk;
        stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        map = new int[N][M];
        for(int i=0;i<N;i++){
            stk = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        visited = new boolean[N][M];
        q = new LinkedList<>();
        int number = 1;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    q.add(new Node(i,j));
                    visited[i][j] = true;
                    bfs(number++);
                }
            }
        }
        pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.len - o2.len;
            }
        });

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j] != 0){
                    makeBridge(i,j,map[i][j]);
                }
            }
        }

        //mst
        parent = new int[number];
        for(int i=1;i<number;i++){
            parent[i] = i;
        }

        int answer = kruskal();

        int p = find(1);
        for(int i=2;i<number;i++){
            if(find(i)!=p){
                answer = 0;
                break;
            }
        }
        if(answer == 0) System.out.println(-1);
        else System.out.println(answer);

    }

    private static int kruskal() {
        int cost = 0;
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int u = find(cur.u);
            int v = find(cur.v);
            if(u == v)continue;
            union(u,v);
            cost += cur.len;

        }
        return cost;
    }

    private static void union(int u, int v) {
        u = find(u);
        v = find(v);
        if(u==v)return;
        parent[v] = u;
    }

    private static int find(int u) {
        if(parent[u] == u)return u;
        return parent[u] = find(parent[u]);

    }

    private static void makeBridge(int cx, int cy, int number) {
        for(int dir=0;dir<4;dir++){
            int nx = cx; int ny = cy;
            int len = 0;
            while(true){
                nx += dx[dir];
                ny += dy[dir];
                if(nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == number)break;
                if(map[nx][ny] != 0){
                    if(len >= 2) {
                        pq.add(new Node(number, map[nx][ny], len));
                    }
                    break;
                }
                len++;
            }
        }
    }


    private static void bfs(int number) {
        while(!q.isEmpty()){
            Node cur = q.poll();
            map[cur.x][cur.y] = number;
            for(int i=0;i<4;i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(nx < 0 || ny < 0|| nx >= N || ny >= M)continue;
                if(visited[nx][ny])continue;
                if(map[nx][ny]==1){
                    q.add(new Node(nx,ny));
                    visited[nx][ny] = true;
                }
            }
        }
    }

    private static class Node {
        int x,y,u,v,len;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public Node(int u, int v, int len){
            this.u = u;
            this.v = v;
            this.len = len;
        }
    }

}
