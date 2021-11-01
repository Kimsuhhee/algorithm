import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class bj2812 {
    static int N,K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());
        String s = br.readLine();
        int t = N-K;
        Deque<Integer>dq = new ArrayDeque<>();
        dq.add(s.charAt(0)-'0');
        for(int i=1;i<s.length();i++){
            int cur = s.charAt(i)-'0';
            while(K>0 && !dq.isEmpty() && dq.peekLast()<cur) {
                dq.pollLast();
                 K--;
            }
            dq.addLast(cur);
        }
        while(t-- > 0) System.out.print(dq.pollFirst());
    }
}
