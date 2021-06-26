import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj10159 {
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for(int i=0;i<M;i++){
            StringTokenizer stk = new StringTokenizer(br.readLine()," ");
            arr[Integer.parseInt(stk.nextToken())-1][Integer.parseInt(stk.nextToken())-1] = 1;
        }

        for(int k=0;k<N;k++){
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(arr[i][k]==1 && arr[k][j]==1)arr[i][j]=1;
                }
            }
        }

        for(int i=0;i<N;i++){
            int sum = 0;
            for(int j=0;j<N;j++){
                if(i==j)continue;
                if(arr[i][j]==0 && arr[j][i]==0)sum++;
            }
            System.out.println(sum);
        }

    }
}
