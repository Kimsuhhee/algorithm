import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class bj21940 {
    static int N,M,K;
    static int[][] road;
    static ArrayList<Integer>list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        road = new int[N+1][N+1];

        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(i==j)continue;
                road[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i=0;i<M;i++){
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            int c = Integer.parseInt(stk.nextToken());
            road[a][b] = c;
        }

        K = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        stk = new StringTokenizer(br.readLine());
        for(int i=0;i<K;i++){
            list.add(Integer.parseInt(stk.nextToken()));
        }

        for(int k=1;k<=N;k++){
            for(int i=1;i<=N;i++){
                for(int j=1;j<=N;j++){
                    if(road[i][k]==Integer.MAX_VALUE || road[k][j]==Integer.MAX_VALUE)continue;
                    if(road[i][j] > road[i][k] + road[k][j])
                        road[i][j] = road[i][k] + road[k][j];
                }
            }
        }

        int min = Integer.MAX_VALUE;
        ArrayList<Integer>ans = new ArrayList<>();

        for(int i=1;i<=N;i++){
            //왕복 최대값
            int max = 0;
            for(int j=0;j<K;j++){
                if(road[list.get(j)][i] == Integer.MAX_VALUE || road[i][list.get(j)] == Integer.MAX_VALUE){
                    max = -1;
                    break;
                }
                max = Math.max(max,road[list.get(j)][i] + road[i][list.get(j)]);
            }
            if(max!=-1) {
                //현재 최대값중 최소값 갱신
                if (min > max) {
                    min = max;
                    ans.clear();
                    ans.add(i);
                }else if (min == max) {
                    ans.add(i);
                }
            }
        }
        Collections.sort(ans);
        for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i)+" ");
        }
    }
}
