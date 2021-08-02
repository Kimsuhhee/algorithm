import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj13458 {
    static int N,B,C;
    static long[]rooms;
    static long cnt=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        rooms = new long[N];
        for(int i=0;i<N;i++)
            rooms[i] = Integer.parseInt(stk.nextToken());
        stk = new StringTokenizer(br.readLine()," ");
        B = Integer.parseInt(stk.nextToken());
        C = Integer.parseInt(stk.nextToken());
        for(int i=0;i<N;i++){
            if(B>rooms[i]){
                cnt++;
                continue;
            }else {
                rooms[i] -= B;
                cnt++;
                if(rooms[i]%C==0) cnt+= rooms[i]/C;
                else if(rooms[i]%C!=0) cnt+= rooms[i]/C+1;
            }
        }
        System.out.println(cnt);

    }
}
