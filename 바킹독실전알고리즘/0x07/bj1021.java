import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj1021 {
    static int[] findArr;
    static Deque<Integer> dq = new LinkedList();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String NM = br.readLine();
        StringTokenizer stk = new StringTokenizer(NM," ");
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        for(int i=1;i<=N;i++){
            dq.add(i);
        }

        findArr = new int[M];
        String findNum = br.readLine();
        stk = new StringTokenizer(findNum," ");
        for(int i=0;i<M;i++){
            findArr[i] = Integer.parseInt(stk.nextToken());
        }

        int cnt = 0;
        for(int i=0;i<M;i++){
            int idx = 1;
            Iterator it = dq.iterator();
            while(it.hasNext()){
                if((int)it.next()==findArr[i])break;
                idx++;
            }
            int left = idx-1;
            int right = dq.size()-idx+1;
            if(left<=right){
                for(int j=0;j<left;j++){
                    dq.addLast(dq.pollFirst());
                    cnt++;
                }
                dq.pollFirst();

            }else{
                for(int j=0;j<right;j++){
                    dq.addFirst(dq.pollLast());
                    cnt++;
                }
                dq.pollFirst();
            }
        }
        System.out.println(cnt);
    }
}
