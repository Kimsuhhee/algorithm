import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj17136 {
    static int min;
    static int[] coloredPaper = {5,5,5,5,5}; // 각 종류의 색종이는 5개씩 있음
    static int[][]arr = new int[10][10];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk;
        for(int i=0;i<10;i++){
            stk = new StringTokenizer(br.readLine());
            for(int j=0;j<10;j++){
                arr[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        min = 100;
        dfs(0,0,0);
        if(min==100) System.out.println(-1);
        else System.out.println(min);
    }

    private static void dfs(int x, int y, int cnt) {
        if(x>=9 && y>=9){
            min = Math.min(min,cnt);
            return;
        }

        if(cnt>=min)return;

        if(y>9){
            dfs(x+1,0,cnt);
            return;
        }

        if(arr[x][y]==1) {
            for (int r = 5; r >= 1; r--) {
                if (check(x, y, x + r, y + r) && coloredPaper[r-1] > 0) {
                    coloredPaper[r-1]--;
                    attach(x,y,x+r,y+r);
                    dfs(x,y + r , cnt + 1);
                    detach(x,y,x + r,y + r);
                    coloredPaper[r-1]++;
                }
            }
        }else dfs(x,y+1,cnt);
    }

    private static void detach(int x1, int y1, int x2, int y2) {
        for(int x=x1;x<x2;x++){
            for(int y=y1;y<y2;y++){
                arr[x][y] = 1;
            }
        }
    }

    private static void attach(int x1, int y1, int x2, int y2) {
        for(int x=x1;x<x2;x++){
            for(int y=y1;y<y2;y++){
                arr[x][y] = 0;
            }
        }
    }


    private static boolean check(int x1, int y1, int x2, int y2) {
        for(int x=x1;x<x2;x++){
            for(int y=y1;y<y2;y++){
                if(x<0||y<0||x>=10||y>=10)return false;
                if(arr[x][y]==0)return false;
            }
        }
        return true;
    }
}
