import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj9663 {
    static int N,cnt;
    static boolean visited1[] = new boolean[40];
    static boolean visited2[] = new boolean[40];
    static boolean visited3[] = new boolean[40];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        func(0);
        System.out.println(cnt);
    }

    private static void func(int cur) {
        if(cur==N) {
            cnt++;
            return;
        }
        for(int i=0;i<N;i++){
            if(visited1[i]||visited2[cur+i]||visited3[cur-i+N-1])
                continue;
            visited1[i] = true;
            visited2[cur+i] = true;
            visited3[cur-i+N-1] = true;
            func(cur+1);
            visited1[i] = false;
            visited2[cur+i] = false;
            visited3[cur-i+N-1] = false;
        }
    }
}
