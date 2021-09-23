import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj17070 {
    static int N,cnt;
    static int[][] d ={{0,1},{1,0},{1,1}};
    static int[][] arr;
    static boolean[][] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        StringTokenizer stk;
        for(int i=0;i<N;i++){
            stk = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        check = new boolean[N][N];
        check[0][0] = true;
        check[0][1] = true;

        //dir 0:가로, 1:세로, 2:대각선
        dfs(0,1,0);
        System.out.println(cnt);
    }

    private static void dfs(int x, int y, int dir) {
        if(x==N-1 && y==N-1){
            cnt++;
            return;
        }
        int mx = 0, my =0;
        if(dir==0){
            for(int i=0;i<3;i+=2){
                mx = x + d[i][0];
                my = y + d[i][1];
                if(mx<0||my<0||mx>=N||my>=N)continue;
                if(i==0){
                    if(arr[mx][my]==0){
                        check[mx][my] = true;
                        dfs(mx,my,i);
                        check[mx][my] = false;
                    }
                }
                if(i==2){
                    if(arr[mx][my]==0 && arr[x][y+1]==0 && arr[x+1][y]==0){
                        check[mx][my] = true;
                        dfs(mx,my,i);
                        check[mx][my] = false;
                    }
                }
            }
        }else if(dir==1){
            for(int i=1;i<3;i++){
                mx = x + d[i][0];
                my = y + d[i][1];
                if(mx<0||my<0||mx>=N||my>=N)continue;
                if(i==1){
                    if(arr[mx][my]==0){
                        check[mx][my] = true;
                        dfs(mx,my,i);
                        check[mx][my] = false;
                    }
                }
                if(i==2){
                    if(arr[mx][my]==0 && arr[x][y+1]==0 && arr[x+1][y]==0){
                        check[mx][my] = true;
                        dfs(mx,my,i);
                        check[mx][my] = false;
                    }
                }
            }
        }else if(dir==2){
            for(int i=0;i<3;i++){
                mx = x + d[i][0];
                my = y + d[i][1];
                if(mx<0||my<0||mx>=N||my>=N)continue;
                if(i==0||i==1){
                    if(arr[mx][my]==0){
                        check[mx][my] = true;
                        dfs(mx,my,i);
                        check[mx][my] = false;
                    }
                }
                if(i==2){
                    if(arr[mx][my]==0 && arr[x][y+1]==0 && arr[x+1][y]==0){
                        check[mx][my] = true;
                        dfs(mx,my,i);
                        check[mx][my] = false;
                    }
                }
            }
        }
    }
}
