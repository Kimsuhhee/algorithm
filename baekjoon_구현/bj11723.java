import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj11723 {
    static int S;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(M-- > 0){
            String[] commands = br.readLine().split(" ");
            if(commands[0].equals("add")){
                int x = Integer.parseInt(commands[1]);
                S |= (1<<x);
            }else if(commands[0].equals("remove")){
                int x = Integer.parseInt(commands[1]);
                S &= ~(1<<x);
            }else if(commands[0].equals("check")){
                int x = Integer.parseInt(commands[1]);
                if((S & (1<<x))==(1<<x)) sb.append(1+"\n");
                else sb.append(0+"\n");
            }else if(commands[0].equals("toggle")){
                int x = Integer.parseInt(commands[1]);
                S ^= (1<<x);
            }else if(commands[0].equals("all")){
                S = (1<<21)-1;
            }else if(commands[0].equals("empty")){
                S = 0;
            }
        }
        System.out.print(sb);
    }
}
