import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1012 {
    static int[][] cabbage = new int[50][50];
    static int[][] visited = new int[50][50];
    static int[] dx ={0,0,-1,+1};
    static int[] dy ={+1,-1,0,0};
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++){
            StringTokenizer stk = new StringTokenizer(br.readLine()," ");
            int M = Integer.parseInt(stk.nextToken()); //배추밭 가로길이
            int N = Integer.parseInt(stk.nextToken()); //배추밭 세로길이
            int K = Integer.parseInt(stk.nextToken()); //배추가 심어져있는 위치의 개수

            for(int j=0;j<K;j++){
                String command = br.readLine();
                String commands[]=command.split(" ");

                cabbage[Integer.parseInt(commands[0])][Integer.parseInt(commands[1])]=1;
            }

            cnt=0;
            for(int k=0;k<M;k++){
                for(int l=0;l<N;l++){
                    if(cabbage[k][l]==1 && visited[k][l]==0) {
                        cnt++;
                        dfs(k,l);
                    }
                }
            }
            sb.append(cnt).append("\n");
            for(int a=0;a<50;a++){
            Arrays.fill(cabbage[a],0);
            Arrays.fill(visited[a],0);
            }
        }
        System.out.println(sb);
    }

    private static void dfs(int k, int l) {
        if(visited[k][l]==1)return;
        visited[k][l]=1;

        for(int i=0;i<4;i++){
            int cx = k+dx[i];
            int cy = l+dy[i];
            if(cx>=0 && cy>=0 && cx<50 && cy<50){
                if(cabbage[cx][cy]==1 && visited[cx][cy]==0){
                    dfs(cx,cy);
                }
            }
        }
    }

}
