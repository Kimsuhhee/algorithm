import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj4179 {
    static char[][] maze;
    static int[][] dist1;
    static int[][] dist2;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int R,C;
    static Queue<Fire>q1 = new LinkedList<>();
    static Queue<Fire>q2 = new LinkedList<>();

    private static class Fire {
        int x,y;

        public Fire(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String RC = br.readLine();
        StringTokenizer stk = new StringTokenizer(RC);

        R = Integer.parseInt(stk.nextToken());
        C = Integer.parseInt(stk.nextToken());
        maze = new char[R+1][C+1];
        dist1 = new int[R+1][C+1];
        dist2 = new int[R+1][C+1];

        for(int[] t:dist1){
            Arrays.fill(t,-1);
        }
        for(int[] t:dist2){
            Arrays.fill(t,-1);
        }

        for(int i=0;i<R;i++){
            String tmp = br.readLine();
            for(int j=0;j<C;j++){
                maze[i][j] = tmp.charAt(j);
            }
        }

        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(maze[i][j]=='F'){
                    q1.add(new Fire(i,j));
                    dist1[i][j]=0;
                }
                else if(maze[i][j]=='J'){
                    q2.add(new Fire(i,j));
                    dist2[i][j]=0;
                }
            }
        }

        //불에 대한 BFS
        while(!q1.isEmpty()){
            Fire tmp = q1.poll();
            for(int i=0;i<4;i++){
                int mx = tmp.x+dx[i];
                int my = tmp.y+dy[i];
                if(mx<0 || my<0 || mx>=R || my>=C)continue;
                if(maze[mx][my]!='#' && dist1[mx][my]==-1){
                    q1.add(new Fire(mx,my));
                    dist1[mx][my] = dist1[tmp.x][tmp.y]+1;
                }
            }
        }

        //지훈이에 대한 BFS
        while(!q2.isEmpty()){
            Fire tmp = q2.poll();
            for(int i=0;i<4;i++){
                int mx = tmp.x+dx[i];
                int my = tmp.y+dy[i];
                if(mx<0 || my<0 || mx>=R || my>=C){
                    System.out.println(dist2[tmp.x][tmp.y]+1);
                    return;
                }
                if(dist2[mx][my]==-1 && maze[mx][my]!='#'){
                    if(dist1[mx][my]!=-1 && dist1[mx][my]<=dist2[tmp.x][tmp.y]+1)
                        continue;
                        q2.add(new Fire(mx, my));
                        dist2[mx][my] = dist2[tmp.x][tmp.y] + 1;
                }
            }
        }
        System.out.println("IMPOSSIBLE");

    }

}
