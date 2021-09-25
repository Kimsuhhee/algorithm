import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj16926 {
    static int N,M,R;
    static int[][] arr;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        R = Integer.parseInt(stk.nextToken());

        arr = new int[N][M];
        for(int i=0;i<N;i++){
            stk = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                arr[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        while(R-- > 0){
            rotate();
        }
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                sb.append(arr[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }

    private static void rotate() {
        int[][] temp = new int[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                temp[i][j] = arr[i][j];
            }
        }
        int r = Math.min(M,N)/2;
        for(int i=0;i<r;i++){
            int x = i , y=i;
            for(int d=0;d<4;d++){
                while(true){
                    int mx = x + dx[d];
                    int my = y + dy[d];
                    if(mx<i||my<i||mx>=N-i||my>=M-i)break;
                    if(d==3 && mx==i && my==i){
                        arr[mx][my] = temp[x][y];
                        break;
                    }
                    arr[mx][my] = temp[x][y];
                    x=mx;
                    y=my;
                }
            }
        }

    }
}
