import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj2910 {
    static int N,C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(stk.nextToken());
        C = Integer.parseInt(stk.nextToken());
        HashMap<Integer, Integer> map = new LinkedHashMap<>();

        stk = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(stk.nextToken());
            if (map.containsKey(num)) {
                map.replace(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        List<Integer> keys = new ArrayList<>(map.keySet());
        keys.sort((o1,o2)->map.get(o2).compareTo(map.get(o1)));
        for(Integer key:keys){
            for(int i=0;i<map.get(key);i++){
                System.out.print(key+" ");
            }
        }
    }

}
