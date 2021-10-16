import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class bj13414 {
    static int K,L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        K = Integer.parseInt(stk.nextToken());
        L = Integer.parseInt(stk.nextToken());
        LinkedHashSet<String> set = new LinkedHashSet<>();
        while(L-- > 0){
            String log = br.readLine();
            if(set.contains(log))set.remove(log);
            set.add(log);
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String>it = set.iterator();
        for(int i=0;i<K;i++){
            if(it.hasNext())sb.append(it.next()).append("\n");
        }
        System.out.print(sb);
    }

}
