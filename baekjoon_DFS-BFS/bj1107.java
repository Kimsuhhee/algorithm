import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1107 {
    static String N;
    static int M,s,min;
    static boolean[]wrong = new boolean[10];
    static int[]p;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = br.readLine();
        M = Integer.parseInt(br.readLine());

        min = Integer.MAX_VALUE;
        s = Integer.parseInt(N);

        //고장난 버튼 없음 -> 원하는 채널로 이동가능
        if(M==0){
            // +/- 이동횟수와 0~9버튼으로 이동한 횟수 비교
            min = Math.min(min,Math.min(Math.abs(100-s),N.length()));
            System.out.println(min);
            System.exit(0);
        }

        //고장난 버튼 1개 이상인경우
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            int num = Integer.parseInt(stk.nextToken());
            wrong[num] = true;
        }

        //만약에 목표 채널이 100이면 종료
        if(s==100){
            System.out.println(0);
            System.exit(0);
        }

        //아닌 경우
        //100에서 목표채널간의 간격으로 min값 갱신
        min = Math.min(min,Math.abs(100-s));

        //0~9버튼으로 이동하기
        for(int i=1;i<=6;i++) {
            p = new int[i];
            permutation(0,i);
        }
        System.out.println(min);
    }

    private static void permutation(int n,int l) {
        if(n==l){
            //버튼을 눌러 이동한 채널구하기
            String num = "";
            for(int i:p) num += i;
            int next = Integer.parseInt(num);

            //해당채널에서 목표채널까지의 거리
            int cnt = Math.abs(next-s) + String.valueOf(next).length();
            min = Math.min(min,cnt);
            return;
        }
        for(int i=0;i<10;i++){
            //고장난 버튼이 아닌경우
            if(!wrong[i]) {
                p[n] = i;
                permutation(n + 1,l);
            }
        }
    }

}
