import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj1874 {
    static final int MX = 1000005;
    static int[] dat = new int[MX];
    static int pos = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr  = new int[n];
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int idx = 0;
        for(int i=0;i<n;i++){
            push(i+1);
            sb.append("+").append("\n");
            while(pos!=0){
                if(top()==arr[idx]){
                    pop();
                    sb.append("-").append("\n");
                    idx++;
                }else break;
            }
        }
        if(pos==0) System.out.println(sb);
        else System.out.println("NO");
    }

    private static void push(int x) {
        dat[pos++] = x;
    }
    private static int top() {
        return dat[pos-1];
    }
    private static void pop() {
        pos--;
    }
}
