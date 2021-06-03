import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj1182 {
    static int N,S;
    static int cnt;
    static ArrayList<Integer>list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(stk.nextToken());
        S = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++)list.add(Integer.parseInt(stk.nextToken()));
        func(0,0);

        //S==0인경우 공집합도 포함되어있으므로 -1
        cnt = (S==0)? --cnt:cnt;
        System.out.println(cnt);

    }

    private static void func(int idx, int tot) {
        if(idx==N){
            if(tot==S) cnt++;
            return;
        }
        func(idx+1,tot);
        func(idx+1,tot+list.get(idx));
    }
}
