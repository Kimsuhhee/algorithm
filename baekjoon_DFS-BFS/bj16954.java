import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class bj16954 {
    static char[][]chess = new char[8][8];
    static int[] dx = {-1,-1,-1,0,0,1,1,1,0};
    static int[] dy = {-1,0,1,-1,1,-1,0,1,0};
    static Queue<Point>q;
    static int endX = 0, endY = 7;
    static boolean finish;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0;i<8;i++){
            String s = br.readLine();
            for(int j=0;j<8;j++){
                chess[i][j] = s.charAt(j);
            }
        }

        q = new LinkedList<>();
        q.add(new Point(7,0));
        finish = false;

        while(!q.isEmpty()){
            bfs();
            if(finish)break;
            drop();
        }
        if(finish) System.out.println(1);
        else System.out.println(0);
    }

    private static void drop() {
        char[][]temp = new char[8][8];
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                temp[i][j] = chess[i][j];
            }
        }

        for(int j=0;j<8;j++){
            for(int i=7;i>=1;i--){
                chess[i][j] = temp[i-1][j];
            }
            chess[0][j] ='.';
        }
    }

    private static void bfs() {
        int size = q.size();
        while(size-- > 0){
            Point p = q.poll();
            if(chess[p.x][p.y]=='#'){
                continue;
            }
            if(p.x==endX && p.y==endY){
                finish = true;
                return;
            }

            //상,하,좌,우,대각선,현재위치로 이동할 수 있음
            for(int i=0;i<9;i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx<0||ny<0||nx>=8||ny>=8)continue;
                if(chess[nx][ny]=='.') {
                    q.add(new Point(nx, ny));
                }
            }
        }
    }


    private static class Point {
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
