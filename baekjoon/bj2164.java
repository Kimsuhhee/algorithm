import java.io.*;
import java.util.*;

public class bj2164 {
    static Queue<Integer> q = new LinkedList<Integer>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i=1;i<=N;i++)q.add(i);

        int idx = 1;

        while(true){
            if(q.size()==1)break;
            if(idx%2==1){
                q.poll();
            }else{
                int temp=q.poll();
                q.add(temp);
            }
            idx++;
        }

        System.out.println(q.peek());
        br.close();
    }
}
