import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj10773 {
    static final int MX = 100005;
    static int[] dat = new int[MX];
    static int pos = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        int sum = 0;

        for(int i=0;i<K;i++){
            int number = Integer.parseInt(br.readLine());
            if(number==0){
                pop();
            }else{
                push(number);
            }
        }
        //스택에 남아있는 값의 합
        for(int i=0;i<K;i++){
            sum+=dat[i];
        }
        System.out.println(sum);
    }

    private static void push(int x) {
        dat[pos++] = x;
    }

    private static void pop() {
        dat[--pos] = 0;
    }
}
