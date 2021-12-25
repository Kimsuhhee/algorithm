import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj1992 {
    static int N;
    static String s = "";
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<N;j++){
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        divide(0,0,N);
        System.out.println(s);

    }

    private static void divide(int x, int y, int area) {
        if(area==1){
            s+=String.valueOf(arr[x][y]);
            return;
        }
        boolean f = true;
        for(int i=x;i<x+area;i++){
            for(int j=y;j<y+area;j++){
                if(i==x&&j==y)continue;
                if(arr[i][j]!=arr[x][y]){
                    f = false;
                }
            }
            if(!f)break;
        }
        if(f){
            s+=String.valueOf(arr[x][y]);
            return;
        }
        s += "(";
        divide(x,y,area/2);
        divide(x,y+area/2,area/2);
        divide(x+area/2,y,area/2);
        divide(x+area/2,y+area/2,area/2);
        s += ")";
    }
}
