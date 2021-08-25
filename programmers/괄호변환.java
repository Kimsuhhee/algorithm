import java.util.Stack;

public class 괄호변환 {

    public static void main(String[] args) {
        String p = "()))((()";
        System.out.println(solution(p));
    }

    public static String solution(String p) {
            String answer = "";

            if(!is_right(p)){
                answer += make(p);
            }else{
                answer += p;
            }
            return answer;
    }

    private static String make(String p) {
        if(p=="")return "";
        int l=0,r=0;
        String u="",v="";
        for(int i=0;i<p.length();i++){
            if(p.charAt(i)=='(')l++;
            if(p.charAt(i)==')')r++;
            if(l==r){
                u += p.substring(0,i+1);
                v += p.substring(i+1,p.length());
                break;
            }
        }
        if(is_right(u)){
            u+=make(v);
            return u;
        }else{
            String temp = "(";
            temp+=make(v);
            temp+=")";
            u = u.substring(1,u.length()-1);
            temp+=flip(u);
            return temp;
        }
    }

    private static String flip(String u) {
        String s = "";
        for(int i=0;i<u.length();i++){
            if(u.charAt(i)=='(')s+=')';
            else s+='(';
        }
        return s;
    }

    private static boolean is_right(String p) {
        Stack<Character>s = new Stack<>();
        for(int i=0;i<p.length();i++){
            char cur = p.charAt(i);
            if (cur == '(') {
                s.push(cur);
            }else{
                if(!s.isEmpty() && s.peek()=='(')s.pop();
                else return false;
            }
        }
        if(s.size()==0)return true;
        else return  false;
    }

}