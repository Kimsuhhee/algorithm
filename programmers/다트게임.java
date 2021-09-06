import java.util.ArrayList;
import java.util.Stack;

public class 다트게임 {
    public static void main(String[] args) {
        String dartResult = "1S2D*3T*";
        System.out.println(solution(dartResult));
    }
    public static int solution(String dartResult) {
        int answer = 0;
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<dartResult.length();i++){
            char cur = dartResult.charAt(i);
            if(cur>='0'&&cur<='9'){
                if(cur=='1'&&dartResult.charAt(i+1)=='0'){
                    st.add(10);
                    i++;
                }else st.add(cur-'0');
            }else if(cur=='S'){
                continue;
            }else if(cur=='D'){
                int num = st.pop();
                st.add(num*num);
            }else if(cur=='T'){
                int num = st.pop();
                st.add(num*num*num);
            }else if(cur=='*'){
                ArrayList<Integer>list = new ArrayList<>();
                for(int j=0;j<2;j++){
                    if(st.isEmpty())break;
                    list.add(st.pop());
                }
                for(int j=list.size()-1;j>=0;j--){
                    st.add(list.get(j)*2);
                }
            }else if(cur=='#'){
                int num = st.pop();
                st.add(num*(-1));
            }
        }
        for(int i:st)answer+=i;
        return answer;
    }
}
