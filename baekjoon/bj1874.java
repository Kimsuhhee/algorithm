import java.io.*;
import java.util.*;

public class bj1874 {
    static Stack<Integer> st;
    static int[] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        st = new Stack<Integer>();

        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }

        int index = 0;
        for(int i=1;i<=n;i++){
            st.push(i);
            sb.append("+"+'\n');
            while(!st.isEmpty()){
                if(st.peek() == arr[index]){
                    sb.append("-"+'\n');
                    st.pop();
                    index++;
                }else break;
            }
        }
        if(st.isEmpty()) System.out.println(sb.toString());
        else System.out.println("NO");

        br.close();

    }

}
