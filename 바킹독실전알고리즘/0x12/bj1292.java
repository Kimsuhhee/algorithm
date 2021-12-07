import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1292 {
    static int A,B;
    static int[] d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        A = Integer.parseInt(stk.nextToken());
        B = Integer.parseInt(stk.nextToken());

        d = new int[1001];
        int cnt = 1; //1부터 시작, 현재값
        int pre = 0; //이전 인덱스

        for(int i=1;i<=1000;i++){
            
            //현재 값 + 이전 인덱스까지의 누적합
            d[i] = cnt + d[i-1];

            //현재 값(cnt)만큼 누적합 수행함
            //cnt+=1 , pre값 갱신
            if(i-cnt==pre){
                cnt++;
                pre = i;
            }
        }

        System.out.println(d[B]-d[A-1]);
    }
}
