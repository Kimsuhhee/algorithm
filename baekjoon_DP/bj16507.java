import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj16507 {
    static int R,C,Q;
    static int[][]pixel;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        R = Integer.parseInt(stk.nextToken());
        C = Integer.parseInt(stk.nextToken());
        Q = Integer.parseInt(stk.nextToken());
        pixel = new int[R+1][C+1];

        for(int i=1;i<=R;i++){
            stk = new StringTokenizer(br.readLine());
            for(int j=1;j<=C;j++){
                pixel[i][j] = Integer.parseInt(stk.nextToken());
                if(i==1 && j!=1){
                    pixel[i][j] += pixel[i][j-1];
                }else if(j==1 && i!=1){
                    pixel[i][j] += pixel[i-1][j];
                }else if(i!=1 && j!=1){
                    pixel[i][j] += (pixel[i-1][j] + pixel[i][j-1] - pixel[i-1][j-1]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<Q;i++){
            stk = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(stk.nextToken());
            int c1 = Integer.parseInt(stk.nextToken());
            int r2 = Integer.parseInt(stk.nextToken());
            int c2 = Integer.parseInt(stk.nextToken());
            int avg = (pixel[r2][c2] - pixel[r1-1][c2] - pixel[r2][c1-1] + pixel[r1-1][c1-1])/((r2-r1+1)*(c2-c1+1));
            sb.append(avg+"\n");
        }
        System.out.print(sb);
    }
}
