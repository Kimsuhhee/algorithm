import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2531 {
    static int N,d,k,c;
    static int[] belt,choose;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken()); //접시 수
        d = Integer.parseInt(stk.nextToken()); //초밥의 가짓수
        k = Integer.parseInt(stk.nextToken()); //연속해서 먹는 접시의 수
        c = Integer.parseInt(stk.nextToken()); //쿠폰번호

        belt = new int[N];
        choose = new int[d+1];

        for(int i=0;i<N;i++){
            belt[i] = Integer.parseInt(br.readLine());
        }

        int max = 0;
        int o = 0; //k개의 영역내에서 먹은 스시 수
        for(int i=0;i<k;i++){
            if(choose[belt[i]]==0)o++;
            choose[belt[i]]++;
        }
        max = o;
        int coupon = 0;
        for(int i=1;i<N;i++){
            if(choose[c]==0)coupon = 1;
            else coupon = 0;
            max = Math.max(max,o+coupon);
            //해당 i번째 스시의 바로 앞 스시는 먹지 않음 처리
            choose[belt[i-1]]--;
            if(choose[belt[i-1]]==0){
                o--;
            }

            //다음 스시를 먹을 때 이전에 먹은 적이 없던 스시의 경우
            if(choose[belt[(i+k-1)%N]]==0){
                o++;
            }
            choose[belt[(i+k-1)%N]]++;
        }
        System.out.println(max);

    }
}
