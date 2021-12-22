import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj18111 {
    static int N,M,B;
    static int[][] height;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        B = Integer.parseInt(stk.nextToken());

        height = new int[N][M];
        for(int i=0;i<N;i++){
            stk = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                height[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        int time = Integer.MAX_VALUE;
        int H = -1;

        for(int h=0;h<=256;h++){

            int t = 0;
            int inventory = B;

            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){

                    //블록을 제거하여 인벤토리에 넣음.
                    if(height[i][j]-h > 0){
                        t += 2 * (height[i][j]-h);
                        inventory += (height[i][j]-h);
                        continue;
                    }

                    //인벤토리에서 꺼내어 블록위에 추가함
                    if(height[i][j]-h < 0){
                        t += 1 * Math.abs(height[i][j]-h);
                        inventory -= Math.abs(height[i][j]-h);
                    }
                }
            }
            if(inventory>=0){
                if(t<=time){
                    time = t;
                    H = h;
                }
            }

        }

        System.out.println(time + " " + H);

    }
}
