import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj10828 {
    static final int MX = 10005;
    static int[] dat = new int[MX];
    static int pos = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<N;i++){
            String command = br.readLine();
            String[] commands = command.split(" ");
            if(commands[0].equals("push")){
                push(Integer.parseInt(commands[1]));
            }else if(commands[0].equals("pop")){
                if(pos==0)sb.append(-1).append("\n");
                else sb.append(pop()).append("\n");
            }else if(commands[0].equals("top")){
                if(pos==0)sb.append(-1).append("\n");
                else sb.append(top()).append("\n");
            }else if(commands[0].equals("size")){
                sb.append(size()).append("\n");
            }else if(commands[0].equals("empty")){
                if(pos==0)sb.append(1).append("\n");
                else sb.append(0).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static int size() {
        return pos;
    }

    private static int top() {
        return dat[pos-1];
    }

    private static int pop() {
        return dat[--pos];
    }

    private static void push(int x) {
        dat[pos++]=x;
    }
}
