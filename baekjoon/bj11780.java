import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj11780 {
    static int n,m;
    static int[][] cost,route;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); //도시의 개수
        m = Integer.parseInt(br.readLine()); //버스의 개수

        route = new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            Arrays.fill(route[i],1000000);
        }

        StringTokenizer stk;
        cost = new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            Arrays.fill(cost[i],1000000);
        }
        for(int i=1;i<=n;i++){
            cost[i][i] = 0;
        }

        for(int i=0;i<m;i++){
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken()); //시작
            int b = Integer.parseInt(stk.nextToken()); //도착
            int c = Integer.parseInt(stk.nextToken()); //비용
            if(cost[a][b]>c) {
                cost[a][b] = c;
                route[a][b] = a;
            }
        }

        floydWarshall();

        StringBuilder sb = new StringBuilder();

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(cost[i][j]==1000000)sb.append(0+" ");
                else sb.append(cost[i][j]+" ");
            }
            sb.append("\n");
        }

        Stack<Integer>stack = new Stack<>();
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(cost[i][j]==1000000 || cost[i][j]==0){
                    sb.append(0+"\n");
                    continue;
                }

                int idx = j;

                while(true){
                    if(idx==i){
                        stack.add(idx);
                        break;
                    }
                    stack.add(idx);
                    idx = route[i][idx];
                }

                sb.append(stack.size()+" ");
                while(!stack.isEmpty()){
                    sb.append(stack.pop()+" ");
                }
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }

    private static void floydWarshall() {
        for(int k=1;k<=n;k++){
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    if(i==j && j==k && k==i)continue;
                    if(cost[i][j]>cost[i][k] + cost[k][j]){
                        cost[i][j] = cost[i][k] + cost[k][j];
                        route[i][j] = route[k][j];
                    }
                }
            }
        }

    }
}
