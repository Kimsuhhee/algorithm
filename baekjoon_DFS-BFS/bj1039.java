import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1039 {
    static int K;
    static String N;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = stk.nextToken();
        K = Integer.parseInt(stk.nextToken());

        visited = new boolean[K+1][1000001]; //[연산횟수][1000000이하의 숫자];
        int len = N.length();
        Queue<String>q = new LinkedList<>();
        q.add(N);
        visited[0][Integer.parseInt(N)] = true;

        int max = -1;
        int t = 0;

        while(!q.isEmpty()) {
            if(t==K)break;
            int size = q.size();
            t++;
            while (size-- > 0) {
                String cur = q.poll();

                for (int i = 0; i < len - 1; i++) {
                    for (int j = i + 1; j < len; j++) {
                        char[] arr = cur.toCharArray();

                        //맨 앞에 0이 올 수 없음
                        if (i==0 && arr[j] == '0') continue;

                        //i번째 문자와 j번째 문자 교환
                        char temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                        String str = String.valueOf(arr);
                        if (!visited[t][Integer.parseInt(str)]) {
                            if(t==K) max = Math.max(max,Integer.parseInt(str));
                            q.add(str);
                            visited[t][Integer.parseInt(str)] = true;
                        }
                    }
                }
            }
        }
        System.out.println(max);
    }

}
