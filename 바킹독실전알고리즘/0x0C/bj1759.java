import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class bj1759 {
    static int L,C;
    static ArrayList<String> list = new ArrayList<>();
    static boolean[]visited = new boolean[16];
    static String[] arr = new String[16];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        L = Integer.parseInt(stk.nextToken());
        C = Integer.parseInt(stk.nextToken());
        stk = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<C;i++) list.add(stk.nextToken());

        Collections.sort(list);
        func(1,0);
        System.out.println(sb);
    }

    private static void func(int start, int n) {
        if(n==L){
            int co=0,vo=0;
            for(int i=0;i<L;i++){
                if(arr[i].equals("a")||arr[i].equals("e")||arr[i].equals("i")||arr[i].equals("o")||arr[i].equals("u"))
                    vo++;
                else
                    co++;
            }
            if(co>=2 && vo>=1){
                for(int i=0;i<L;i++){
                    sb.append(arr[i]);
                }
                sb.append("\n");
            }
            return;
        }
        for(int i=start;i<=C;i++){
            if(!visited[i]){
                arr[n] = list.get(i-1);
                visited[i] = true;
                func(i+1,n+1);
                visited[i] = false;
            }
        }
    }
}

