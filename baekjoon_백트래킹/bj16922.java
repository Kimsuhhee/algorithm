import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class bj16922 {
    static int N;
    static int[] com;
    static HashSet<Integer>set = new HashSet<>();
    static int[] cnt = {1,5,10,50};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        if(N==1){
            System.out.println(4);
            return;
        }
        com = new int[N];
        combination(0,0);
        System.out.println(set.size());
    }

    private static void combination(int start, int n) {
        if(n==N){
            int num = 0;
            for(int i=0;i<com.length;i++){
                num += cnt[com[i]];
            }
            set.add(num);
            return;
        }
        for(int i=start;i<4;i++){
            com[n] = i;
            combination(i, n + 1);
        }
    }
}
