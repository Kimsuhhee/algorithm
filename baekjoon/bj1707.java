import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1707 {
    static int K, V, E;
    static int visited[];
    static boolean flag;
    static StringBuilder sb = new StringBuilder();
    static Queue<Integer>q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());

        while(K-- > 0){
            StringTokenizer stk = new StringTokenizer(br.readLine()," ");
            V = Integer.parseInt(stk.nextToken());
            E = Integer.parseInt(stk.nextToken());
            visited = new int[V];
            ArrayList<ArrayList<Integer>>list = new ArrayList<>();

            for(int i=0;i<V;i++) list.add(new ArrayList<>());
            for(int i=0;i<E;i++){
                stk = new StringTokenizer(br.readLine()," ");
                int a = Integer.parseInt(stk.nextToken())-1;
                int b = Integer.parseInt(stk.nextToken())-1;
                list.get(a).add(b);
                list.get(b).add(a);
            }

            q = new LinkedList<>();

            flag = true;
            for(int i=0;i<V;i++){
                if(visited[i]==0){
                    visited[i] = 1;
                    q.add(i);
                    while(!q.isEmpty()){
                        int cur = q.poll();
                        for(int j=0;j<list.get(cur).size();j++){
                            int nex = list.get(cur).get(j);
                            if(visited[nex]==0){
                                q.add(nex);
                                visited[nex] = (visited[cur]==1)? 2:1;
                            }else{
                                if(visited[cur]==visited[nex]){
                                    flag = false;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            if(flag) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");
        }
        System.out.print(sb);
    }
}