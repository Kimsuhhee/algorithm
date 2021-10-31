import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class bj1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String exp = br.readLine();
        Operand[] operand = new Operand[N];
        for(int i=0;i<N;i++){
            operand[i] = new Operand((char)('A'+i),Integer.parseInt(br.readLine()));
        }
        Stack<Double> st = new Stack<>();
        for(int i=0;i<exp.length();i++){
            if(exp.charAt(i)>='A' && exp.charAt(i)<='Z'){
                for(int j=0;j<N;j++){
                    if(operand[j].ch==exp.charAt(i)) {
                        st.add((double)operand[j].op);
                        break;
                    }
                }
            }else{
                double num1 = st.pop();
                double num2 = st.pop();
                if(exp.charAt(i)=='+')st.add(num1+num2);
                else if(exp.charAt(i)=='*')st.add(num1*num2);
                else if(exp.charAt(i)=='-')st.add(num2-num1);
                else if(exp.charAt(i)=='/')st.add(num2/num1);
            }
        }
        System.out.println(String.format("%.2f",st.pop()));
    }

    private static class Operand {
        char ch;
        int op;

        public Operand(char ch, int op) {
            this.ch = ch;
            this.op = op;
        }
    }
}
