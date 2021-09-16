import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj2631 {
    static int N;
    static int[] child,d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        child = new int[N];
        for(int i=0;i<N;i++) child[i] = Integer.parseInt(br.readLine());

        int change = 0;
        d = new int[N];
        d[0] = 1;
        for(int i=1;i<N;i++){
            d[i] = 1;
            for(int j=0;j<i;j++){
                if(child[i]>child[j]){
                    d[i] = Math.max(d[i],d[j]+1);
                }
            }
            change = Math.max(change,d[i]);
        }
        System.out.println(N-change);
    }
}
