import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj21608 {
    static int N,num,sum;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] info;
    static int[][] seat;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        seat = new int[N*N+1][N*N+1];
        visited = new boolean[N*N+1][N*N+1];
        info = new int[N*N+1][N*N+1];
        for(int i=0;i<N*N;i++){
            StringTokenizer stk = new StringTokenizer(br.readLine()," ");
            num = Integer.parseInt(stk.nextToken());
            for(int j=1;j<=4;j++){
                info[num][j] = Integer.parseInt(stk.nextToken());
            }
            setSeat(num);
        }
        /**
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                System.out.print(seat[i][j]+" ");
            }
            System.out.println();
        }
         **/
        cal();
        System.out.println(sum);
    }

    private static void cal() {
        int cur = 0;
        for(int i=1;i<=N;i++){
            for(int j=1 ;j<=N;j++){
                cur = seat[i][j];
                int ch = 0;
                for(int a=0;a<4;a++){
                    int x = dx[a]+i;
                    int y = dy[a]+j;
                    //if(x<0 || y<0|| x>N || y>N)continue;
                    if(seat[x][y]==info[cur][1] ||seat[x][y]==info[cur][2]
                            ||seat[x][y]==info[cur][3]||seat[x][y]==info[cur][4])
                        ch++;
                }
                if(ch==0)sum+=0;
                else if(ch==1)sum+=1;
                else if(ch==2)sum+=10;
                else if(ch==3)sum+=100;
                else sum+=1000;
            }
        }
    }

    private static void setSeat(int idx) {
        int cx=0,cy=0;
        int max = -1;
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(visited[i][j])continue;
                int cnt =0;
                for(int a=0;a<4;a++){
                    int x = dx[a]+i;
                    int y = dy[a]+j;
                    if(x<=0 || y<=0 || x>N || y>N)continue;
                    if(seat[x][y]==info[idx][1] ||seat[x][y]==info[idx][2]
                            ||seat[x][y]==info[idx][3]||seat[x][y]==info[idx][4])
                        cnt+=7;
                    if(seat[x][y]==0)
                        cnt+=1;
                }
                if(max<cnt){
                    max = cnt;
                    cx = i;
                    cy = j;
                }
            }
        }
        seat[cx][cy] = idx;
        visited[cx][cy] = true;
    }
}
