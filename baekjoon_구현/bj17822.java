import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj17822 {
    static int N,M,T,x,d,k;
    static int[] dir = {1,-1}; //시계,반시계
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int [][] pan;
    static boolean[][] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        T = Integer.parseInt(stk.nextToken());
        pan = new int[N][M];
        for(int i=0;i<N;i++){
            stk = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                pan[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        while(T-- > 0){
            stk = new StringTokenizer(br.readLine()," ");
            x = Integer.parseInt(stk.nextToken());
            d = Integer.parseInt(stk.nextToken());
            k = Integer.parseInt(stk.nextToken());

            for(int i=x;i<=N;i+=x){
                rotate(i-1);
            }
            check = new boolean[N][M];
            boolean flag = false;
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(pan[i][j]==0)continue;
                    int cnt = 0;
                    for(int k=0;k<4;k++){
                        int x = i+dx[k];
                        int y = j+dy[k];
                        if(j==0 && k==3){
                            y = M-1;
                        }
                        if(j==M-1 && k==2){
                            y = 0;
                        }
                        if(x>=0&&y>=0&&x<N&&y<M) {
                            if (pan[i][j] == pan[x][y]) {
                                check[x][y] = true;
                                cnt++;
                            }
                        }
                    }if(cnt>=1) {
                        check[i][j] = true;
                        flag = true;
                    }
                }
            }

            if(!flag){
                calAvg();
            }else{
                for(int i=0;i<N;i++){
                    for(int j=0;j<M;j++){
                        if(check[i][j]) pan[i][j] = 0;
                    }
                }
            }
        }
        System.out.println(cal());
    }

    private static int cal() {
        int sum = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                sum+=pan[i][j];
            }
        }
        return sum;
    }

    private static void calAvg() {
        double sum = 0.0;
        int[][] cnt = new int[N][M];
        int c = 0;

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(pan[i][j]!=0){
                    cnt[i][j]++;
                    c++;
                    sum+=pan[i][j];
                }
            }
        }

        sum/=(double)c;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(cnt[i][j]!=0) {
                    if (pan[i][j] > sum) pan[i][j] -= 1;
                    else if(pan[i][j] < sum) pan[i][j] += 1;
                }
            }
        }
    }
    private static void rotate(int x) {
        int[] temp = new int[M];
        for(int i=0;i<M;i++){
            int cx = (i+dx[d]*k+M)%M;
            temp[cx] = pan[x][i];
        }
        for(int i=0;i<M;i++){
            pan[x][i] = temp[i];
        }

    }
}
