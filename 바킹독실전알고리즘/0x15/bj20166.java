import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class bj20166 {
    static int N,M,K;
    static char[][] arr;
    static int[] dx = {-1,-1,-1,0,0,1,1,1};
    static int[] dy = {-1,0,1,-1,1,-1,0,1};
    static HashMap<String,Integer> list;
    static String[] str;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());

        arr = new char[N][M];
        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<M;j++){
                arr[i][j]  = s.charAt(j);
            }
        }
        str = new String[K];
        list = new HashMap<>();
        for(int i=0;i<K;i++){
            String words = br.readLine();
            list.put(words,0);
            str[i] = words;
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                dfs(i,j,arr[i][j]+"",1);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<K;i++){
            sb.append(list.get(str[i])+"\n");
        }
        System.out.print(sb);
    }

    private static void dfs(int x, int y, String s, int n) {
        if(list.containsKey(s))list.put(s, list.get(s)+1);
        if(n>=5)return;
        for(int i=0;i<8;i++){
            int nx = (x+dx[i]+N)%N;
            int ny = (y+dy[i]+M)%M;
            dfs(nx,ny,s+arr[nx][ny],n+1);
        }
    }
}
