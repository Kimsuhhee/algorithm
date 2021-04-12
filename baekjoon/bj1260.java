import java.io.*;
import java.util.*;

public class bj1260 {
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
    static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String command = br.readLine();
        String comm[]=command.split(" ");
        int N = Integer.parseInt(comm[0]); //정점의 개수
        int M = Integer.parseInt(comm[1]); //간선의 개수
        int V = Integer.parseInt(comm[2]); //탐색을 시작할 정점의 번호

        visited= new int [N+1];

        for(int i=0;i<N+1;i++){
            arr.add(new ArrayList<Integer>());
        }

        for(int i=0;i<M;i++){
            String temp = br.readLine();
            String tmp[] = temp.split(" ");
            arr.get(Integer.parseInt(tmp[1])).add(Integer.parseInt(tmp[0]));
            arr.get(Integer.parseInt(tmp[0])).add(Integer.parseInt(tmp[1]));
        }
        dfs(V);
        System.out.println();
        Arrays.fill(visited,0);
        bfs(V);
    }

    private static void dfs(int start) {
        if(visited[start]==1)return;
        visited[start] = 1;
        Collections.sort(arr.get(start));
        System.out.print(start+" ");
        for(int i=0;i<arr.get(start).size();i++){
            int y = arr.get(start).get(i);
            if(visited[y]==0)dfs(y);
        }
    }

    private static void bfs(int start) {
        Queue<Integer>q = new LinkedList<Integer>();
        q.add(start);
        visited[start]=1;

        while(!q.isEmpty()){
            int x = q.poll();
            System.out.print(x+" ");
            Collections.sort(arr.get(x));
            for(int i=0;i<arr.get(x).size();i++){
                int y=arr.get(x).get(i);
                if(visited[y]==0){
                    q.add(y);
                    visited[y]=1;
                }
            }
        }
    }

}
