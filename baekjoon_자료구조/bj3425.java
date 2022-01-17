import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class bj3425 {
    static int T;
    static String s;
    static ArrayList<String>op;
    static Stack<Long>st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            boolean flag = false;
            op = new ArrayList<>();
            while (true) {
                s = br.readLine();
                if (s.equals("QUIT")) {
                    flag = true;
                    break;
                }
                if(s.equals("END"))break;
                op.add(s);
            }

            if (flag) break;

            T = Integer.parseInt(br.readLine());

            while (T-- > 0) {
                long num = Long.parseLong(br.readLine());
                st = new Stack<>();
                st.push(num);
                boolean error = false;
                for (String command : op) {
                    String[] str = command.split(" ");
                    if (str[0].equals("DUP")) {
                        if(st.isEmpty()){
                            error = true;
                            break;
                        }
                        long top = st.pop();
                        st.push(top);st.push(top);
                    } else if (str[0].equals("MUL")) {
                        if(st.isEmpty()){
                            error = true;
                            break;
                        }
                        long first = st.pop();
                        if(st.isEmpty()){
                            error = true;
                            break;
                        }
                        long second = st.pop();
                        if(Math.abs(first * second) > 1000000000){
                            error = true;
                            break;
                        }
                        st.push(first * second);
                    } else if (str[0].equals("NUM")) {
                        long x = Long.parseLong(str[1]);
                        if(x<0 || x> 1000000000){
                            error = true;
                            break;
                        }
                        st.push(x);
                    } else if (str[0].equals("ADD")) {
                        if(st.isEmpty()){
                            error = true;
                            break;
                        }
                        long first = st.pop();
                        if(st.isEmpty()){
                            error = true;
                            break;
                        }
                        long second = st.pop();
                        if(Math.abs(first + second) > 1000000000){
                            error = true;
                            break;
                        }
                        st.push(first + second);
                    } else if (str[0].equals("SUB")) {
                        if(st.isEmpty()){
                            error = true;
                            break;
                        }
                        long first = st.pop();
                        if(st.isEmpty()){
                            error = true;
                            break;
                        }
                        long second = st.pop();
                        if(Math.abs(first - second) > 1000000000){
                            error = true;
                            break;
                        }
                        st.push(second - first);
                    } else if (str[0].equals("MOD")) {
                        if(st.size()<2){
                            error = true;
                            break;
                        }
                        long first = st.pop();

                        if (first == 0) {
                            error = true;
                            break;
                        }

                        long second = st.pop();

                        if(second<0) {
                            st.push(-(Math.abs(second) % Math.abs(first)));
                        }else {
                            st.push(Math.abs(second) % Math.abs(first));
                        }
                    } else if (str[0].equals("DIV")) {
                        if(st.size()<2){
                            error = true;
                            break;
                        }

                        long first = st.pop();

                        if (first == 0) {
                            error = true;
                            break;
                        }

                        long second = st.pop();

                        int cnt = 0;
                        if(second<0){
                            second = Math.abs(second);
                            cnt++;
                        }
                        if(first<0){
                            first = Math.abs(first);
                            cnt++;
                        }

                        if(cnt==1)st.push(-(second / first));
                        else st.push(second / first);
                    } else if (str[0].equals("POP")) {
                        if(st.isEmpty()){
                            error = true;
                            break;
                        }
                        st.pop();
                    } else if (str[0].equals("INV")) {
                        if(st.isEmpty()){
                            error = true;
                            break;
                        }
                        long top = st.pop();
                        st.push(top*(-1));
                    } else if (str[0].equals("SWP")) {
                        if(st.size()<2){
                            error = true;
                            break;
                        }
                        long first = st.pop();
                        long second = st.pop();
                        st.push(first);
                        st.push(second);
                    }
                }

                if (!error && st.size()==1) {
                    sb.append(st.pop()+"\n");
                } else {
                    sb.append("ERROR"+"\n");
                }
            }
            br.readLine();
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
