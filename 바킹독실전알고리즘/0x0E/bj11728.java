import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj11728 {
    static int[] A, B;
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        A = new int[N];
        B = new int[M];
        int[] temp = new int[N+M];
        stk = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++) A[i] = Integer.parseInt(stk.nextToken());
        stk = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<M;i++) B[i] = Integer.parseInt(stk.nextToken());

        int a=0,b=0,k=0;
        while(true) {
            if (a == N || b == M) break;
            temp[k++] = (A[a] <= B[b]) ? A[a++] : B[b++];
        }
        if(a<N){
            for(int i=a;i<A.length;i++)
                temp[k++] = A[i];
        }
        else if(b<M){
            for(int i=b;i<B.length;i++)
                temp[k++] = B[i];
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<temp.length;i++)
            sb.append(temp[i]+" ");
        System.out.println(sb);
    }
}
