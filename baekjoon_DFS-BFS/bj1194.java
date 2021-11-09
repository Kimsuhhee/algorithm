import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1194 {
    static int N,M;
    static char[][]maze;
    static int[][][]d;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static Queue<Info>q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        maze = new char[N][M];
        q = new LinkedList<>();

        d = new int[N][M][1<<6];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                Arrays.fill(d[i][j],Integer.MAX_VALUE);
            }
        }

        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<s.length();j++){
                maze[i][j] = s.charAt(j);
                if(maze[i][j]=='0'){
                    q.add(new Info(i,j,0,0));
                    d[i][j][0] = 0;
                }
            }
        }
        int min = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            Info cur = q.poll();
            int cx = cur.x;
            int cy = cur.y;
            int cnt = cur.cnt;
            int key = cur.key;
            if(maze[cx][cy]=='1'){
                min = Math.min(min,cnt);
                continue;
            }
            for(int i=0;i<4;i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(nx<0||ny<0||nx>=N||ny>=M)continue;
                if(d[nx][ny][key]!=Integer.MAX_VALUE)continue;
                if(maze[nx][ny]=='#')continue;
                
                    //문인경우
                if(maze[nx][ny]>='A' && maze[nx][ny]<='F'){
                    //해당하는 열쇠를 가지고 있다면
                   if((key&(1<<(maze[nx][ny]-'A')))!=0){
                       q.add(new Info(nx,ny,cnt+1,key));
                       d[nx][ny][key] = d[cx][cy][key]+1;
                   }
                   //열쇠가 있는 칸인 경우
                }else if(maze[nx][ny]>='a' && maze[nx][ny]<='f'){
                    int nk = key|(1<<(maze[nx][ny]-'a'));
                    if(d[nx][ny][nk]==Integer.MAX_VALUE){
                        q.add(new Info(nx,ny,cnt+1,nk));
                        d[nx][ny][nk] = d[cx][cy][key]+1;
                    }
                    //그외 경우
                }else {
                    q.add(new Info(nx,ny,cnt+1,key));
                    d[nx][ny][key] = d[cx][cy][key]+1;
                }
            }
        }
        if(min==Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);
    }

    private static class Info {
        int x,y,cnt,key;

        public Info(int x, int y, int cnt, int key) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.key = key;
        }
    }
}
