import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj6603 {
    static int k;
    static int[]lotto;
    static ArrayList<Integer>list;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
            k = Integer.parseInt(stk.nextToken());

            if(k==0)break;

            sb = new StringBuilder();
            lotto = new int[6];
            list = new ArrayList<>();
            for (int i = 0; i < k; i++){
                list.add(Integer.parseInt(stk.nextToken()));
            }
            func(0,0);
            System.out.println(sb);
        }

    }

    private static void func(int start, int n) {
        if(n==6){
            for(int i=0;i<n;i++){
                sb.append(lotto[i]+" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=start;i<k;i++) {
            lotto[n] = list.get(i);
            func(i+1,n+1);
        }

    }
}
