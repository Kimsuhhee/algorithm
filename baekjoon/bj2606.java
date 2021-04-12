import java.io.*;
import java.util.*;

public class bj2606 {
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
    static int[] visited;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

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
        bfs(1); 
        //1번 컴퓨터가 웜 바이러스에 걸렸을때, 
        // 1번 컴퓨터를 통해 웜바이러스에 걸리게 되는 컴퓨터의 수를 출력
        System.out.println(cnt);
    }

    private static void bfs(int start) {
        Queue<Integer>q = new LinkedList<Integer>();
        q.add(start);
        visited[start]=1;

        while(!q.isEmpty()){
            int x = q.poll();
            for(int i=0;i<arr.get(x).size();i++){
                int y=arr.get(x).get(i);
                if(visited[y]==0){
                    q.add(y);
                    visited[y]=1;
                    cnt++;
                }
            }
        }
    }

}
