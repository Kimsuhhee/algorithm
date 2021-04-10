import java.io.*;
import java.util.*;

public class bj11866 {
    static Queue<Integer> q = new LinkedList<Integer>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nk = br.readLine();
        StringTokenizer stk = new StringTokenizer(nk);

        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());

        for(int i=1;i<=N;i++)q.add(i);

        sb.append("<");
        while(!q.isEmpty()){
            for(int i=1;i<=N;i++){
                if(i==K){
                    sb.append(q.poll());
                    if(!q.isEmpty())sb.append(", ");
                    break;
                }else{
                    q.add(q.poll());
                }
            }
        }
        sb.append(">");
        System.out.println(sb);
        br.close();
    }
}
