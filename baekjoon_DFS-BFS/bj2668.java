import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class bj2668 {
    static int N;
    static ArrayList<Integer>list = new ArrayList<>();
    static boolean[] visited;
    static int sum = 0;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        for(int i=1;i<=N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        visited = new boolean[N+1];
        for(int i=1;i<=N;i++){
            if(!visited[i]) {
                visited[i] = true;
                dfs(i,arr[i]);
                visited[i] = false;
            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        for(int i:list) System.out.println(i);

    }

    private static void dfs(int x,int s) {
        if(x==s){
            list.add(s);
            return;
        }
        if(!visited[s]) {
            visited[s] = true;
            dfs(x,arr[s]);
            visited[s] = false;
        }
    }

}
