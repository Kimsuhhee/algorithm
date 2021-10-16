import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class bj1620 {
    static int N,M;
    static HashMap<String,Integer>map1;
    static HashMap<Integer,String>map2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        map1 = new HashMap<>();
        map2 = new HashMap<>();

        int idx = 1;
        while(N-- > 0){
            String s = br.readLine();
            map1.put(s,idx);
            map2.put(idx,s);
            idx++;
        }
        StringBuilder sb = new StringBuilder();
        while(M-- > 0){
            String command = br.readLine();
            if(command.charAt(0)>='A' && command.charAt(0)<='Z'){
                sb.append(map1.get(command)).append("\n");
            }else
                sb.append(map2.get(Integer.parseInt(command))).append("\n");
        }
        System.out.println(sb);
    }

}
