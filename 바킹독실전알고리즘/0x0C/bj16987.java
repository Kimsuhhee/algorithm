import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj16987 {
    static int N;
    static int cnt = 0; //깨져있는 계란의 수
    static int Max = Integer.MIN_VALUE;
    static Egg eggs[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        eggs = new Egg[N];

        for(int i=0;i<N;i++){
            StringTokenizer stk = new StringTokenizer(br.readLine()," ");
            eggs[i] = new Egg(Integer.parseInt(stk.nextToken()),Integer.parseInt(stk.nextToken()));
        }

        func(0);
        System.out.println(Max);
    }

    private static void func(int n) { //n번째 계란으로 다른걸 깰 차례
        if(n == N){
            Max = Math.max(Max,cnt);
            return;
        }
        if(eggs[n].power <= 0 || cnt == N-1){
            //a번째 계란이 깨져있거나 다른 모든 계란이 깨져있으면 넘어감
            func(n+1);
            return;
        }
        for(int i=0;i<N;i++){ //i번째 계란을 깬다.
            if(i == n|| eggs[i].power <= 0) continue;
            //i번째 계란이 현재 들고있는 계란이 아니고, 깨져있지않다면
            //n번째와 i번째계란을 서로 친다.
            eggs[n].power -= eggs[i].weight;
            eggs[i].power -= eggs[n].weight;
            //깨진 계란의 수를 셈
            if(eggs[n].power <= 0)cnt++;
            if(eggs[i].power <= 0)cnt++;
            func(n+1);
            //원상복구
            if(eggs[n].power <= 0)cnt--;
            if(eggs[i].power <= 0)cnt--;
            eggs[n].power += eggs[i].weight;
            eggs[i].power += eggs[n].weight;
        }
    }

    private static class Egg {
        int power, weight;

        public Egg(int power, int weight) {
            this.power = power;
            this.weight = weight;
        }
    }
}
