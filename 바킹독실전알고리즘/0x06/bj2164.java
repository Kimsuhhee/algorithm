import java.io.*;

public class bj2164 {
    static final int MX = 1000001;
    static int[] dat = new int[MX];
    static int head = 0, tail = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for(int i=1;i<=N;i++){
            push(i);
        }

        int idx = 0;
        while(true){
            if(head==tail-1)break;
            if(idx%2==0){
                pop();
            }else{
                int temp = front();
                pop();
                push(temp);
            }
            idx++;
        }
        bw.write(front()+"\n");
        bw.flush();
        br.close();
        bw.close();
    }

    private static int front() {
        return dat[head];
    }

    private static void pop() {
        head++;
    }

    private static void push(int x) {
        dat[tail++] = x;
    }
}
