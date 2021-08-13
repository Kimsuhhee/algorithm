import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj15685 {
    static int N;
    static boolean[][] dragon;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dragon = new boolean[101][101];

        while(N-- >0){
            StringTokenizer stk = new StringTokenizer(br.readLine()," ");
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());
            int d = Integer.parseInt(stk.nextToken());
            int g = Integer.parseInt(stk.nextToken());
            make(x,y,d,g);
        }

        System.out.println(cal());

    }

    private static int cal() {
        int sum = 0;
        for(int i=0;i<100;i++){
            for(int j=0;j<100;j++){
                if(dragon[i][j]&&dragon[i][j+1]&&dragon[i+1][j]&&dragon[i+1][j+1])
                    sum++;
            }
        }
        return sum;
    }

    private static void make(int x, int y, int dir, int age) {
        ArrayList<Integer>dirInfo = new ArrayList<>();
        dirInfo.add(dir);
        while(age-- > 0){
            for(int i=dirInfo.size()-1;i>=0;i--){
                dir = (dirInfo.get(i)+1)%4; //반시계방향회전
                dirInfo.add(dir);
            }
        }

        dragon[y][x] = true; //시작 좌표 표시
        for(int i=0;i<dirInfo.size();i++){
            x = x+dx[dirInfo.get(i)];
            y = y+dy[dirInfo.get(i)];
            if(x>=0&&y>=0&&x<101&&y<101)
                dragon[y][x] = true;
        }
    }

}
