import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class bj5648 {
    static long n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        ArrayList<Long>list = new ArrayList<>();
        while(stk.hasMoreTokens()){
            String s = stk.nextToken();
            String temp = "";
            for(int i=s.length()-1;i>=0;i--){
                temp+=s.charAt(i);
            }
            list.add(Long.parseLong(temp));
            n--;
        }
        while(true){
            if(n==0)break;
            stk = new StringTokenizer(br.readLine());
            while(stk.hasMoreTokens()){
                String s = stk.nextToken();
                String temp = "";
                for(int i=s.length()-1;i>=0;i--){
                    temp+=s.charAt(i);
                }
                list.add(Long.parseLong(temp));
                n--;
            }
        }
        Collections.sort(list);
        for(long l:list) System.out.println(l);
    }
}
