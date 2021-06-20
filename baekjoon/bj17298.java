import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        Stack<Integer>st = new Stack<>();

        StringBuilder sb = new StringBuilder();

        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<N;i++)
            arr[i] = Integer.parseInt(stk.nextToken());

        for(int i=0;i<N;i++){
            while(!st.isEmpty() && arr[i]>arr[st.peek()]){
                arr[st.pop()] = arr[i];
            }
            st.push(i);
        }


        while(!st.isEmpty())
            arr[st.pop()] = -1;

        for(int i=0;i<N;i++) sb.append(arr[i]+" ");
        System.out.print(sb);

    }
}
