import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj23288 {
    static int N,M,K,answer,sx,sy,dir;
    static int[][] map;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int[] dice = {2,4,1,3,5,6};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());

        map = new int[N][M];
        for(int i=0;i<N;i++){
            stk = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        //시작 x, y, 이동방향
        sx = 0; sy = 0; dir = 0;

        while(K-- > 0){
            move();
            turnDirect();
            bfs();
        }

        System.out.println(answer);

    }

    private static void bfs() {
        int target = map[sx][sy];

        Queue<Node>q = new LinkedList<>();
        q.add(new Node(sx,sy));
        int cnt = 0; //target과 같은값의 개수

        boolean[][] visited = new boolean[N][M];
        visited[sx][sy] = true;

        while(!q.isEmpty()){
            Node cur = q.poll();
            cnt++;
            for(int i=0;i<4;i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(nx < 0 || ny <0 || nx > N-1 || ny > M-1)continue;
                if(visited[nx][ny])continue;
                if(map[nx][ny] == target){
                    visited[nx][ny] = true;
                    q.add(new Node(nx,ny));
                }
            }
        }
        answer += (cnt*target);
    }

    private static void turnDirect() {
        //주사위 밑과 해당 맵의 수가 같으면 방향 그대로
        if(dice[5] == map[sx][sy])return;

        //주사위 밑의 수가 더 크면 이동 방향 시계방향으로 회전
        if(dice[5] > map[sx][sy]){
            if(dir == 0){
                dir = 2;
            }else if(dir == 1){
                dir = 3;
            }else if(dir == 2){
                dir = 1;
            }else {
                dir = 0;
            }
        }else{ //주사위 밑의 수가 더 작으면 이동방향 반시계방향으로 회전
            if(dir == 0){
                dir = 3;
            }else if(dir == 1){
                dir = 2;
            }else if(dir == 2){
                dir = 0;
            }else {
                dir = 1;
            }
        }
    }

    private static void move() {
        //현재 이동방향으로 한칸 이동
        int nx = sx + dx[dir];
        int ny = sy + dy[dir];

        //만약 이동할 수 있는 칸이 없다면
        if(nx < 0 || ny < 0 || nx >= N || ny >= M){
            //방향을 바꾸고
            if(dir == 0) dir = 1;
            else if(dir == 1)dir = 0;
            else if(dir == 2)dir = 3;
            else if(dir ==3) dir = 2;

            //그 방향으로 한칸 이동
            nx = sx + dx[dir];
            ny = sy + dy[dir];
        }

        sx = nx; sy = ny;

        //주사위 전개도 위치 변경
        int[] temp = dice.clone();
        if(dir == 0){
            dice[1] = temp[5];
            dice[2] = temp[1];
            dice[3] = temp[2];
            dice[5] = temp[3];
            return;
        }
        if(dir == 1){
            dice[1] = temp[2];
            dice[2] = temp[3];
            dice[3] = temp[5];
            dice[5] = temp[1];
            return;
        }
        if(dir == 2){
            dice[0] = temp[5];
            dice[2] = temp[0];
            dice[4] = temp[2];
            dice[5] = temp[4];
            return;
        }
        if(dir == 3){
            dice[0] = temp[2];
            dice[2] = temp[4];
            dice[4] = temp[5];
            dice[5] = temp[0];
            return;
        }
    }

    private static class Node {
        int x,y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
