import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2630 {
    static int N;
    static int[][] arr;
    static int[] cnt = new int[2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer stk;
        arr = new int[N][N];
        int pre = -1;
        boolean finish = true;
        for(int i=0;i<N;i++){
            stk = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j] = Integer.parseInt(stk.nextToken());
                if(pre==-1)pre=arr[i][j];
                if(pre!=-1 && pre!=arr[i][j])finish=false;
            }
        }
        if(finish) {
            cnt[pre]++;
        }else {
            divide(0, 0, N / 2);
            divide(0, N / 2, N / 2);
            divide(N / 2, 0, N / 2);
            divide(N / 2, N / 2, N / 2);
        }

        System.out.println(cnt[0]);
        System.out.println(cnt[1]);
    }

    private static void divide(int x, int y, int area) {
        if(area==1){
            cnt[arr[x][y]]++;
            return;
        }

        boolean f = true;
        for(int i=x;i<x+area;i++){
            for(int j=y;j<y+area;j++){
                if(i==x && j==y)continue;
                if(arr[i][j]!=arr[x][y]){
                    f = false;
                    break;
                }
            }
            if(!f)break;
        }

        if(f){
            cnt[arr[x][y]]++;
            return;
        }

        divide(x,y,area/2);
        divide(x,y+area/2,area/2);
        divide(x+area/2,y,area/2);
        divide(x+area/2,y+area/2,area/2);
    }
}
