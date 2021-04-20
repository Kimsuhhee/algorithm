import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class bj1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String NK = br.readLine();
        StringTokenizer stk = new StringTokenizer(NK," ");
        int N = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());

        LinkedList<Integer> list = new LinkedList();
        for(int i=1;i<=N;i++){
            list.add(i);
        }

        StringBuilder sb = new StringBuilder();

        System.out.print("<");
        while(list.size()>0){
            for(int i=1;i<=K;i++){
                int temp = list.removeFirst();
                if(i==K){
                    System.out.print(temp);
                    if(!list.isEmpty()) System.out.print(", ");
                }else{
                    list.add(temp);
                }
            }
        }
        System.out.print(">");
    }
}
