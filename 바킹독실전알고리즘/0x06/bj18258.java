import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj18258 {
    static final int MX = 2000005;
    static int[] dat = new int[MX];
    static int head = 0, tail = 0;

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
                if(tail==head)sb.append(-1).append("\n");
                else sb.append(pop()).append("\n");
            }else if(commands[0].equals("size")){
                sb.append(size()).append("\n");
            }else if(commands[0].equals("empty")){
                if(tail==head)sb.append(1).append("\n");
                else sb.append(0).append("\n");
            }else if(commands[0].equals("front")){
                if(tail==head)sb.append(-1).append("\n");
                else sb.append(front()).append("\n");
            }else if(commands[0].equals("back")){
                if(tail==head)sb.append(-1).append("\n");
                else sb.append(back()).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static void push(int x) {
        dat[tail++] = x;
    }

    private static int size() {
        return tail-head;
    }

    private static int pop() {
        return dat[head++];
    }

    private static int front() {
        return dat[head];
    }

    private static int back() {
        return dat[tail-1];
    }
}
