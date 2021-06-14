import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj15664 {
    static int N,M;
    static boolean[] visited;
    static LinkedHashSet<String>set = new LinkedHashSet<>();
    static List<Integer> list = new ArrayList<>();
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        visited = new boolean[N];
        arr = new int[M];

        stk = new StringTokenizer(br.readLine()," ");
        while(stk.hasMoreTokens())
            list.add(Integer.parseInt(stk.nextToken()));
        Collections.sort(list);
        func(0,0);
        for(String str:set) System.out.println(str);
    }

    private static void func(int start, int n) {
        if(n==M){
            String s = "";
            for(int i=0;i<arr.length;i++)
                s+=arr[i]+" ";
            set.add(s);
            return;
        }
        for(int i=start;i<N;i++){
            arr[n] = list.get(i);
            func(i+1,n+1);
        }
    }
}
