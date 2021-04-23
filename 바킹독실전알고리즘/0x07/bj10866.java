import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj10866 {
    static final int MX = 10005;
    static int[] dat = new int[MX*2+1];
    static int head = MX, tail=MX;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            String command = br.readLine();
            String[] commands = command.split(" ");
            if(commands[0].equals("push_front")){
                push_front(Integer.parseInt(commands[1]));
            }else if(commands[0].equals("push_back")){
                push_back(Integer.parseInt(commands[1]));
            }else if(commands[0].equals("pop_front")){
                if(head==tail)sb.append(-1).append("\n");
                else {
                    sb.append(front()).append("\n");
                    pop_front();
                }
            }else if(commands[0].equals("pop_back")){
                if(head==tail)sb.append(-1).append("\n");
                else {
                    sb.append(back()).append("\n");
                    pop_back();
                }
            }else if(commands[0].equals("size")){
                sb.append(size()).append("\n");
            }else if(commands[0].equals("empty")){
                sb.append(empty()).append("\n");
            }else if(commands[0].equals("front")){
                if(head==tail)sb.append(-1).append("\n");
                else {
                    sb.append(front()).append("\n");
                }
            }else if(commands[0].equals("back")){
                if(head==tail)sb.append(-1).append("\n");
                else {
                    sb.append(back()).append("\n");
                }
            }
        }
        System.out.println(sb);
    }

    private static int empty() {
        if(tail==head) return 1;
        else return 0;
    }

    private static int front() {
        return dat[head];
    }

    private static int back() {
        return dat[tail-1];
    }
    private static void pop_front() {
        head++;
    }
    private static void pop_back() {
        tail--;
    }

    private static int size() {
        return tail-head;
    }

    private static void push_front(int x) {
        dat[--head] = x;
    }
    private static void push_back(int x) {
        dat[tail++] = x;
    }
}
