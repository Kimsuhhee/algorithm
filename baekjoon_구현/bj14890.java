import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj14890 {
    static int N,L;
    static int cnt;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(stk.nextToken());
        L = Integer.parseInt(stk.nextToken());

        map = new int[N][N];
        for(int i=0;i<N;i++){
            stk = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        for(int i=0;i<N;i++){
            if(check_ramp_row(i)) cnt++;
            if(check_ramp_col(i)) cnt++;
        }
        System.out.println(cnt);

    }

    private static boolean check_ramp_row(int x) {
        int[] temp = new int[N];
        for(int i=0;i<N;i++){
            temp[i] = map[x][i];
        }
        boolean[] ramp = new boolean[N];

        for(int i=0;i<N-1;i++){
            if(temp[i]==temp[i+1])continue;
            if(temp[i]>temp[i+1]){
                if(temp[i]-temp[i+1]==1){
                    for(int j=1;j<=L;j++){
                        if(i+j>=N || ramp[i+j] || temp[i]-temp[i+j]!=1) return false;
                        ramp[i+j] = true;
                    }
                }else return false;
            }else if(temp[i]<temp[i+1]){
                if(temp[i+1]-temp[i]==1){
                    for(int j=1;j<=L;j++){
                        if(i+1-j<0 || i+1-j>=N || ramp[i+1-j] || temp[i+1]-temp[i+1-j]!=1) return false;
                        ramp[i+1-j] = true;
                    }
                }else return false;
            }
        }
        return true;

    }
    private static boolean check_ramp_col(int y) {
        int[] temp = new int[N];
        for (int i = 0; i < N; i++) {
            temp[i] = map[i][y];
        }
        boolean[] ramp = new boolean[N];

        for (int i = 0; i < N - 1; i++) {
            if (temp[i] == temp[i + 1]) continue;
            if (temp[i] > temp[i + 1]) {
                if (temp[i] - temp[i + 1] == 1) {
                    for (int j = 1; j <= L; j++) {
                        if (i + j >= N || ramp[i + j] || temp[i] - temp[i + j] != 1) return false;
                        ramp[i + j] = true;
                    }
                } else return false;
            } else if (temp[i] < temp[i + 1]) {
                if (temp[i + 1] - temp[i] == 1) {
                    for (int j = 1; j <= L; j++) {
                        if (i + 1 - j < 0 || i + 1 - j >= N || ramp[i + 1 - j] || temp[i + 1] - temp[i + 1 - j] != 1)
                            return false;
                        ramp[i + 1 - j] = true;
                    }
                } else return false;
            }
        }
        return true;
    }
}
