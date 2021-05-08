import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Stack;

public class bj2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Stack<String> st = new Stack<>();

        int sum = 0;

        for(int i=0;i<s.length();i++){

            char c = s.charAt(i);

            if(c=='('||c=='['){

                st.push(String.valueOf(c));

            }else if(c==')'){

                if(st.isEmpty()){
                    System.out.println(0);return;
                }

                sum = 0;

                if(st.peek().equals("(")){
                    st.pop();
                    st.push(String.valueOf(2));
                    continue;
                }else{
                    while(!st.isEmpty()){
                        String temp = st.pop();

                        if(temp.equals("[")){
                            System.out.println(0);
                            return;
                        }

                        if(temp.equals("(")){
                            st.push(String.valueOf(sum * 2));
                            break;
                        }

                        sum += Integer.parseInt(temp);
                    }
                }
            }else if(c==']'){

                if(st.isEmpty()){
                    System.out.println(0);return;
                }

                sum = 0;

                if(st.peek().equals("[")){
                    st.pop();
                    st.push(String.valueOf(3));
                    continue;
                }else{
                    while(!st.isEmpty()){
                        String temp = st.pop();

                        if(temp.equals("(")){
                            System.out.println(0);
                            return;
                        }

                        if(temp.equals("[")){
                            st.push(String.valueOf(sum * 3));
                            break;
                        }

                        sum += Integer.parseInt(temp);

                    }
                }
            }
        }
        sum = 0;
        while(!st.isEmpty()){
            if(st.peek().equals("(")||st.peek().equals(")")||st.peek().equals("[")||st.peek().equals("]")){
                sum = 0;
                break;
            }

            sum += Integer.parseInt(st.pop());
        }
        System.out.println(sum);
    }
}
