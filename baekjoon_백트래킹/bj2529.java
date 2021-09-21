import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class bj2529 {
    static int k;
    static ArrayList<String>list = new ArrayList<>();
    static boolean[] check = new boolean[10];
    static int[] num = {0,1,2,3,4,5,6,7,8,9};
    static char[] sign;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        sign = new char[k];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i=0;i<k;i++) sign[i] = stk.nextToken().charAt(0);
        combi("",0,k+1);
        Collections.sort(list);
        System.out.println(list.get(list.size()-1));
        System.out.println(list.get(0));
    }

    private static void combi(String s,int n,int N) {
        if(n==N){
            boolean flag = true;
            for(int i=1;i<=sign.length;i++){
                char cur = sign[i-1];
                if(cur=='<' && s.charAt(i)-'0' < s.charAt(i-1)-'0'){
                    return;
                }
                if(cur=='>' && s.charAt(i)-'0' > s.charAt(i-1)-'0'){
                    return;
                }
            }
            list.add(s);
            return;
        }
        for(int i=0;i<num.length;i++){
            if(!check[i]){
                check[i] = true;
                combi(s+num[i],n+1,N);
                check[i] = false;
            }
        }
    }

}
