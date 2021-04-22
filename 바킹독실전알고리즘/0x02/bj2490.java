import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2490 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<3;i++){
            String y = br.readLine();
            int zero=0;
            StringTokenizer stk = new StringTokenizer(y," ");
            while(stk.hasMoreTokens()){
                if(stk.nextToken().equals("0")){
                    zero++;
                }
            }
            if(zero==1) sb.append("A").append("\n");
            else if(zero==2) sb.append("B").append("\n");
            else if(zero==3) sb.append("C").append("\n");
            else if(zero==4) sb.append("D").append("\n");
            else sb.append("E").append("\n");
        }
        System.out.println(sb);
    }
}
