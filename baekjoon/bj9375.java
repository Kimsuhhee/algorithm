import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class bj9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            HashMap<String,Integer>map = new HashMap<>();
            int n = Integer.parseInt(br.readLine());
            StringTokenizer stk;
            while(n-- > 0){
                stk = new StringTokenizer(br.readLine());
                String item = stk.nextToken();
                String name = stk.nextToken();
                map.put(name,map.getOrDefault(name,0)+1);
            }
            int answer = 1;
            for(int cnt:map.values()){
                answer *= cnt+1;
            }
            System.out.println(answer-1); //아무것도 안입은 경우 빼기
        }
    }
}
