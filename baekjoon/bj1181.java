import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj1181 {
    static int N;
    static String[] words;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> set = new HashSet<String>();

        N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++)
            set.add(br.readLine());

        Iterator<String> it = set.iterator();
        words = new String[set.size()];

        int idx=0;
        while(it.hasNext()){
            words[idx++]=it.next();
        }

        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()==o2.length())
                    return o1.compareTo(o2);
                else
                   return o1.length()-o2.length();
            }
        });

        for(String s:words) System.out.println(s);
        br.close();
    }
}
