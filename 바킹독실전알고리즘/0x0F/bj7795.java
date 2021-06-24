import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj7795 {
    static int T,N,M;
    static int[] arrA;
    static int[] arrB;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(T-- > 0){
            StringTokenizer stk = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(stk.nextToken());
            M = Integer.parseInt(stk.nextToken());
            arrA = new int[N];
            arrB = new int[M];

            stk = new StringTokenizer(br.readLine()," ");
            for(int i=0;i<N;i++)arrA[i] = Integer.parseInt(stk.nextToken());

            stk = new StringTokenizer(br.readLine()," ");
            for(int i=0;i<M;i++)arrB[i] = Integer.parseInt(stk.nextToken());

            Arrays.sort(arrA);
            Arrays.sort(arrB);

            int cnt = 0;
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(arrA[i]<=arrB[j])break;
                    else cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }

}
