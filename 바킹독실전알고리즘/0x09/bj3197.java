import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj3197 {
    static int R,C;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static char[][] river;
    static boolean[][] visited;
    static Queue<Point>q = new LinkedList<>();
    static Queue<Point>water = new LinkedList<>();
    static Point l1,l2;
    static boolean flag = false;

    private static class Point {
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        R = Integer.parseInt(stk.nextToken());
        C = Integer.parseInt(stk.nextToken());

        river = new char[R][C];
        visited = new boolean[R][C];

        for(int i=0;i<R;i++){
            String s = br.readLine();
            for(int j=0;j<C;j++){
                river[i][j] = s.charAt(j);
                if(river[i][j]=='L'){
                    if(!flag){
                        l1 = new Point(i,j);
                        flag = true;
                    }else{
                        l2 = new Point(i,j);
                    }
                    water.add(new Point(i,j));
                }
                if(river[i][j] == '.'){
                    water.add(new Point(i,j));
                }
            }
        }

        q.add(l1);
        visited[l1.x][l1.y] = true;

        int day = 0;
        boolean find = false;
        while(true){
            Queue<Point>t = new LinkedList<>();
            while(!q.isEmpty()){
                Point temp = q.poll();
                if(temp.x == l2.x && temp.y == l2.y){
                    find = true;
                    break;
                }
                for(int i=0;i<4;i++){
                    int x = temp.x+dx[i];
                    int y = temp.y+dy[i];
                    if(x<0||y<0||x>=R||y>=C||visited[x][y])continue;
                    visited[x][y] = true;
                    if(river[x][y] == 'X'){
                        t.add(new Point(x,y));
                        continue;
                    }
                    q.add(new Point(x,y));
                }
            }
            if(find) break;
            q = t;
            int qsize = water.size();
            while(qsize -- > 0){
                Point tmp = water.poll();
                for(int i=0;i<4;i++){
                    int x = tmp.x+dx[i];
                    int y = tmp.y+dy[i];
                    if(x<0||y<0||x>=R||y>=C)continue;
                    if(river[x][y]=='X'){
                        river[x][y]='.';
                        water.add(new Point(x,y));
                    }
                }
            }
            day++;
        }
        System.out.println(day);
    }
}
