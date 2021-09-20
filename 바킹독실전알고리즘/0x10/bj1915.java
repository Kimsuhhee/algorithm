import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1915 {
    static int[] dx = {-1,-1,0};
    static int[] dy = {0,-1,-1};
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        arr = new int[n+2][m+2];
        for(int i=0;i<n;i++){
            String s = br.readLine();
            for(int j=0;j<m;j++){
                arr[i+1][j+1] = s.charAt(j)-'0';
            }
        }

        int area = 0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(arr[i][j]!=0){
                    int min = 10001;
                    for(int d=0;d<3;d++){
                        int x = i+dx[d];
                        int y = j+dy[d];
                        min = Math.min(min,arr[x][y]);
                    }
                    arr[i][j] = min + 1;
                    area = Math.max(area, arr[i][j]);
                }
            }
        }

        System.out.println(area*area);

    }
}
