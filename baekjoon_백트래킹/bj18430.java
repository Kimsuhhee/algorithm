import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj18430 {
    static int N,M,max;
    static int[][]material;
    static boolean[][] attached;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        material = new int[N][M];
        for(int i=0;i<N;i++){
            stk = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                material[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        attached = new boolean[N][M];
        dfs(0,0,0);
        System.out.println(max);
    }

    private static void dfs(int x, int y, int sum) {
        if(y==M){ //다음줄로 이동
            y = 0;
            x++;
        }
        if(x==N){
            max = Math.max(max,sum);
            return;
        }
        if(!attached[x][y]) {
            for (int i = 0; i < 4; i++) {
                int s = isPossible(i,x,y);
                if(s!=0){
                    if(i==0) {
                        attached[x][y] = true;
                        attached[x+dx[0]][y+dy[0]] = true;
                        attached[x+dx[1]][y+dy[1]] = true;
                        dfs(x, y + 1, sum + s);
                        attached[x][y] = false;
                        attached[x+dx[0]][y+dy[0]] = false;
                        attached[x+dx[1]][y+dy[1]] = false;
                    }
                    if(i==1){
                        attached[x][y] = true;
                        attached[x+dx[2]][y+dy[2]] = true;
                        attached[x+dx[1]][y+dy[1]] = true;
                        dfs(x, y + 1, sum + s);
                        attached[x][y] = false;
                        attached[x+dx[2]][y+dy[2]] = false;
                        attached[x+dx[1]][y+dy[1]] = false;
                    }
                    if(i==2){
                        attached[x][y] = true;
                        attached[x+dx[0]][y+dy[0]] = true;
                        attached[x+dx[3]][y+dy[3]] = true;
                        dfs(x, y + 1, sum + s);
                        attached[x][y] = false;
                        attached[x+dx[0]][y+dy[0]] = false;
                        attached[x+dx[3]][y+dy[3]] = false;
                    }
                    if(i==3){
                        attached[x][y] = true;
                        attached[x+dx[2]][y+dy[2]] = true;
                        attached[x+dx[3]][y+dy[3]] = true;
                        dfs(x, y + 1, sum + s);
                        attached[x][y] = false;
                        attached[x+dx[2]][y+dy[2]] = false;
                        attached[x+dx[3]][y+dy[3]] = false;
                    }
                }
            }
        }
        dfs(x,y+1,sum);
    }

    private static int isPossible(int order, int x, int y) {
        if(order==0){
            int nx1 = x + dx[0];
            int ny1 = y + dy[0];
            int nx2 = x + dx[1];
            int ny2 = y + dy[1];
            if(nx1<N && ny1<M && nx2<N && ny2<M && !attached[nx1][ny1] && !attached[nx2][ny2]){
                return material[nx1][ny1] + material[nx2][ny2] + material[x][y]*2;
            }
        }else if(order==1){
            int nx1 = x + dx[1];
            int ny1 = y + dy[1];
            int nx2 = x + dx[2];
            int ny2 = y + dy[2];
            if(nx1<N && ny1>=0 && ny1<M && nx2<N && ny2>=0 && ny2<M && !attached[nx1][ny1] && !attached[nx2][ny2]){
                return material[nx1][ny1] + material[nx2][ny2] + material[x][y]*2;
            }
        }else if(order==2){
            int nx1 = x + dx[0];
            int ny1 = y + dy[0];
            int nx2 = x + dx[3];
            int ny2 = y + dy[3];
            if(nx1<N && nx1>=0 && ny1<M && nx2<N && nx2>=0 && ny2<M && !attached[nx1][ny1] && !attached[nx2][ny2]){
                return material[nx1][ny1] + material[nx2][ny2] + material[x][y]*2;
            }
        }else if(order==3){
            int nx1 = x + dx[2];
            int ny1 = y + dy[2];
            int nx2 = x + dx[3];
            int ny2 = y + dy[3];
            if(nx1>=0 && nx1<N && ny1>=0 && ny1<M && nx2>=0 && nx2<N && ny2>=0 && ny2<M && !attached[nx1][ny1] && !attached[nx2][ny2]){
                return material[nx1][ny1] + material[nx2][ny2] + material[x][y]*2;
            }
        }
        return 0;
    }
}
