import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj20057 {
    static int N, x, y, dir, answer;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {-1,0,1,0};
    static int[][][] mxy = {
            {{-2,-1,-1,-1,0,1,1,1,2},{0,-1,0,1,-2,-1,0,1,0},{2,10,7,1,5,10,7,1,2}},
            {{-1,-1,0,0,0,0,1,1,2},{-1,1,-2,-1,1,2,-1,1,0},{1,1,2,7,7,2,10,10,5}},
            {{-2,-1,-1,-1,0,1,1,1,2},{0,-1,0,1,2,-1,0,1,0},{2,1,7,10,5,1,7,10,2}},
            {{-2,-1,-1,0,0,0,0,1,1},{0,-1,1,-2,-1,1,2,-1,1},{5,10,10,2,7,7,2,1,1}}
    };
    static int[][] sand;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sand = new int[N][N];
        x = N/2; y = N/2; dir = 0;
        for(int i=0;i<N;i++){
            StringTokenizer stk = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                sand[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        for(int i=1;i<N;i++){
            for(int j=0;j<2;j++){
                tornado(i);
            }
        }

        tornado(N-1);

        System.out.println(answer);
    }

    private static void tornado(int move) {
        while(move-- > 0){
            int cx = x + dx[dir];
            int cy = y + dy[dir];
            if(cx<0||cy<0||cx>=N||cy>=N)break;

            if(sand[cx][cy]!=0) {
                spread(cx,cy,sand[cx][cy],dir);
                sand[cx][cy] = 0;

                 /**
                System.out.println("===========");
                for(int i=0;i<N;i++){
                    for(int j=0;j<N;j++){
                        System.out.print(sand[i][j]+" ");
                    }
                    System.out.println();
                }
                 **/
            }
            x = cx; y = cy;
        }

        dir = (dir+1)%4;
    }

    private static void spread(int x, int y, int amount, int dir) {
        int sum = 0;
        for(int i=0;i<9;i++){
            int cx = x + mxy[dir][0][i];
            int cy = y + mxy[dir][1][i];
            if(cx<0||cy<0||cx>=N||cy>=N){
                answer += amount * (mxy[dir][2][i]*0.01);
                sum+= amount * (mxy[dir][2][i]*0.01);
            }else{
                sand[cx][cy] += amount * (mxy[dir][2][i]*0.01);
                sum+= amount * (mxy[dir][2][i]*0.01);
            }
        }
        int mx = x + dx[dir];
        int my = y + dy[dir];
        if(mx<0||my<0||mx>=N||my>=N)
            answer+= amount-sum;
        else
            sand[mx][my] += amount-sum;
    }

}
