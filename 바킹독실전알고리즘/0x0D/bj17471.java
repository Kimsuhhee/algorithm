import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj17471 {
    static int N,min=1001;
    static ArrayList<Integer>set1,set2;
    static boolean[] checked;
    static int[] p;
    static ArrayList<Integer>[] area;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        area = new ArrayList[N+1];
        for(int i=0;i<=N;i++){
            area[i] = new ArrayList<>();
        }
        p = new int[N+1];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            p[i] = Integer.parseInt(stk.nextToken());
        }

        for(int i=1;i<=N;i++){
            stk = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(stk.nextToken());
            while(n-- > 0){
                int a = Integer.parseInt(stk.nextToken());
                area[i].add(a);
                area[a].add(i);
            }
        }
        checked = new boolean[N+1];
        for(int i=1;i<=(N+1)/2;i++) {
            dfs(0,1,i);
        }
        if(min==1001) System.out.println(-1);
        else System.out.println(min);
    }

    private static void dfs(int n,int idx,int len) {
        if(n==len){
            set1 = new ArrayList<>();
            set2 = new ArrayList<>();
            for(int i=1;i<=N;i++){
                if(!checked[i])set2.add(i);
                if(checked[i])set1.add(i);
            }
            if(set1.size()>0 && isConnected(set1) && isConnected(set2)){
                cal();
            }

            return;
        }
        for(int i=idx;i<=N;i++){
            if(!checked[i]){
                checked[i] = true;
                dfs(n+1,i+1,len);
                checked[i] = false;
            }
        }

    }

    private static void cal() {
        int sum1 = 0, sum2 = 0;

        for(int a:set1){
            sum1 += p[a];
        }
        for(int b:set2){
            sum2 += p[b];
        }
        min = Math.min(min, Math.abs(sum1-sum2));
    }

    private static boolean isConnected(ArrayList<Integer>list) {
        Queue<Integer>q = new LinkedList<>();
        boolean[] visited = new boolean[N+1];
        q.add(list.get(0));
        visited[list.get(0)] = true;
        int cnt = 1;
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i=0;i<area[cur].size();i++){
                if(!visited[area[cur].get(i)]&&list.contains(area[cur].get(i))){
                    q.add(area[cur].get(i));
                    visited[area[cur].get(i)] = true;
                    cnt++;
                }
            }
        }
        if(cnt!=list.size())return false;
        return true;
    }
}
