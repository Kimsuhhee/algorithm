import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj10773 {
    static Stack<Integer> st = new Stack<Integer>();
    static int K;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());

        for(int i=0;i<K;i++){
            int num = Integer.parseInt(br.readLine());
            if(num!=0) st.push(num);
            else{
                if(!st.isEmpty()) st.pop();
            }
        }

        Iterator<Integer> it = st.iterator();
        int sum = 0;
        while(it.hasNext()){
            sum += it.next();
        }
        System.out.println(sum);
        br.close();
    }
}
