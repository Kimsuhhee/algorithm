import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj17281 {
    static int N,max;
    static int[][] inning;
    static int[] order;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer stk;
        inning = new int[N][9];
        for(int i=0;i<N;i++){
            stk = new StringTokenizer(br.readLine());
            for(int j=0;j<9;j++){
                inning[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        max = Integer.MIN_VALUE;
        order = new int[9];
        visited = new boolean[9];
        combination(0);
        System.out.println(max);
    }

    private static void combination(int n) {
        if(n==9){
            if(order[3]!=0) return;

            //1번선수가 4번타자인 경우
            max = Math.max(max,play());
            return;
        }
        for(int i=0;i<9;i++){
            if(!visited[i]){
                order[n] = i;
                visited[i] = true;
                combination(n+1);
                visited[i] = false;
            }
        }
    }

    private static int play() {
        boolean[] base;
        int score = 0;
        int j = 0;
        for(int i=0;i<N;i++){
            base = new boolean[4]; //0:타자, 1:1루주자, 2:2루주자, 3:3루주자
           int out = 0;
            while(out<3){
                if(j==9)j=0;
                int cur = inning[i][order[j]];
                if(cur==0){
                    out++;
                }else{
                    for(int k=3;k>=1;k--){
                        if(!base[k])continue;

                        int next = k + cur;

                        if(next >= 4){ //홈을 밟는경우
                            score++;
                            base[k] = false;
                        }else{
                            base[next] = true;
                            base[k] = false;
                        }
                    }
                    if(cur==4) score++;
                    else base[cur] = true;
                }
                j++;
            }
        }
        return score;
    }

}
