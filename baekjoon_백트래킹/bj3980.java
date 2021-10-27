import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj3980 {
    static int C,max;
    static int[][] player;
    static boolean[]visited;
    static int[] com;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        C = Integer.parseInt(br.readLine());

        StringTokenizer stk;

        while(C-- > 0) {
            player = new int[11][11];
            for (int i = 0; i < 11; i++) {
                stk = new StringTokenizer(br.readLine());
                for (int j = 0; j < 11; j++) {
                    player[i][j] = Integer.parseInt(stk.nextToken());
                }
            }

            visited = new boolean[11];
            com = new int[11];
            max = 0;
            combination(0);
            System.out.println(max);
        }
    }

    private static void combination(int n) {
        if(n==11){
            int sum = 0;
            int idx = 0;
            for(int i:com) {
                sum += player[idx++][i];
            }
            max = Math.max(max,sum);
            return;
        }

        for(int i=0;i<11;i++){
            if(!visited[i] && player[n][i]!=0){
                com[n] = i;
                visited[i] = true;
                combination(n+1);
                visited[i] = false;
            }
        }

    }
}
