import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1780 {
    static int N;
    static int[] cnt = new int[3];
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        StringTokenizer stk;
        for(int i=0;i<N;i++){
            stk = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        divide(0,0,N);
        System.out.println(cnt[0]);
        System.out.println(cnt[1]);
        System.out.println(cnt[2]);
    }

    private static void divide(int x, int y, int area) {
        if(area==1){
            cnt[arr[x][y]+1]++;
            return;
        }
        boolean f = true;
        for(int i=x;i<x+area;i++){
            for(int j=y;j<y+area;j++){
                if(i==x&&j==y)continue;
                if(arr[i][j]!=arr[x][y]) {
                    f = false;
                    break;
                }
            }
            if(!f)break;
        }
        if(f){
            cnt[arr[x][y]+1]++;
            return;
        }
        divide(x,y,area/3);
        divide(x,y+area/3,area/3);
        divide(x,y+(area/3*2),area/3);
        divide(x+area/3,y,area/3);
        divide(x+area/3,y+area/3,area/3);
        divide(x+area/3,y+(area/3*2),area/3);
        divide(x+(area/3*2),y,area/3);
        divide(x+(area/3*2),y+area/3,area/3);
        divide(x+(area/3*2),y+(area/3*2),area/3);
    }
}
