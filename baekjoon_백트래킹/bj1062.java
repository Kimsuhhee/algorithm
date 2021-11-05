import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1062 {
    static int N,K,S,max;
    static String[] words;
    static boolean[] five = new boolean[26];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());

        words = new String[N];
        for(int i=0;i<N;i++){
            words[i] = br.readLine();
        }

        if(K<5) {
            System.out.println(0);
            System.exit(0);
        }
        if(K==26){
            System.out.println(N);
            System.exit(0);
        }

        //남극언어의 모든 단어는 "anta"로 시작되고 "tica"로 끝남
        //해당하는 알파벳은 따로 표시해둠
        S |= (1 << ('a'-'a'));
        five['a'-'a'] = true;
        S |= (1 << ('c'-'a'));
        five['c'-'a'] = true;
        S |= (1 << ('n'-'a'));
        five['n'-'a'] = true;
        S |= (1 << ('i'-'a'));
        five['i'-'a'] = true;
        S |= (1 << ('t'-'a'));
        five['t'-'a'] = true;

        max = -1;
        dfs(0,0);
        System.out.println(max);
    }

    private static void dfs(int start,int n) {
        if(n==K-5){
            int ans = 0;
            for(int i=0;i<N;i++){
                boolean add = true;
                for(int j=0;j<words[i].length();j++){
                    if((S & 1<<(words[i].charAt(j)-'a'))==0){
                        add = false;break;
                    }
                }
                if(add)ans++;
            }
            max = Math.max(max,ans);
            return;
        }
        for(int i=start;i<26;i++){
            //남극언어의 접두사와 접미사에 해당하는 알파벳이면 순서 넘기기
            if(five[i])continue;

            //접두사와 접미사에 해당하는 알파벳이 아닌데 비트가 i번째 비트가 0인경우
            if((S & (1<<i))==0){
                S |= (1<<i);
                dfs(i,n+1);
                S &= ~(1<<i);
            }
        }
    }
}
