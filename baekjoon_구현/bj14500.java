import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj14500 {
    static int N,M;
    static int maxsum = Integer.MIN_VALUE;
    static int[][] paper;
    static int[][][] shape = {
            {{0,0},{1,0},{2,0},{3,0}},
            {{0,0},{0,1},{0,2},{0,3}},
            {{0,0},{0,1},{1,0},{1,1}},

            {{0,0},{0,1},{0,2},{1,1}},
            {{0,1},{1,0},{1,1},{1,2}},
            {{0,0},{1,0},{1,1},{2,0}},
            {{0,1},{1,0},{1,1},{2,1}},

            {{0,0},{1,0},{2,0},{2,1}},
            {{0,1},{1,1},{2,0},{2,1}},
            {{0,0},{0,1},{1,0},{2,0}},
            {{0,0},{0,1},{1,1},{2,1}},
            {{0,2},{1,0},{1,1},{1,2}},
            {{0,0},{1,0},{1,1},{1,2}},
            {{0,0},{0,1},{0,2},{1,2}},
            {{0,0},{0,1},{0,2},{1,0}},

            {{0,0},{1,0},{1,1},{2,1}},
            {{0,1},{1,0},{1,1},{2,0}},
            {{0,1},{0,2},{1,0},{1,1}},
            {{0,0},{0,1},{1,1},{1,2}}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        paper = new int[N][M];

        for(int i=0;i<N;i++){
            stk = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                paper[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                calsum(i,j);
            }
        }
        System.out.println(maxsum);
    }

    private static void calsum(int x, int y) {
        for(int i=0;i<19;i++){
            int sum=0;
            for(int j=0;j<4;j++){
                int cx = x+shape[i][j][0];
                int cy = y+shape[i][j][1];
                if(cx>=0 && cy>=0 && cx<N && cy<M) {
                    sum += paper[cx][cy];
                }
            }
            if(maxsum<sum){
                maxsum = sum;
            }
        }
    }
}
