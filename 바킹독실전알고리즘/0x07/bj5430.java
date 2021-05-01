import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class bj5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while(T-- > 0){
            String func = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String array = br.readLine().replace("["," ").replace("]"," ").replace(","," ");
            StringTokenizer stk = new StringTokenizer(array);

            Deque dq = new LinkedList();
            for(int i=0;i<n;i++){
                dq.add(Integer.parseInt(stk.nextToken()));
            }

            char[] temp = func.toCharArray();
            boolean emptyFlag = false;
            boolean dir = true; //true: 오른쪽, false: 왼쪽

            for(char c: temp){
                if(c=='R'){
                    dir = !dir;
                }else if(c=='D'){
                    if(dq.isEmpty()){
                        emptyFlag = true;
                        break;
                    }
                    if(dir){
                        dq.removeFirst();
                    }else{
                        dq.removeLast();
                    }
                }
            }
            if(emptyFlag){
                sb.append("error").append("\n");
                continue;
            }

            sb.append("[");
            while(!dq.isEmpty()){
                if(dir){
                    if(dq.size()==1){
                        sb.append(dq.removeFirst());
                        continue;
                    }
                    sb.append(dq.removeFirst()).append(",");
                }else{
                    if(dq.size()==1){
                        sb.append(dq.removeLast());
                        continue;
                    }
                    sb.append(dq.removeLast()).append(",");
                }
            }
            sb.append("]").append("\n");
        }
        System.out.println(sb);

    }
}
