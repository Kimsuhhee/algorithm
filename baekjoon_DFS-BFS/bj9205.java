import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj9205 {
    static int t,n,x,y;
    static Queue<Info>q;
    static Queue<Info> supplement;
    static Info end;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        StringTokenizer stk;
        while(t-- > 0){
            n = Integer.parseInt(br.readLine());
            q = new LinkedList<>();
            supplement = new LinkedList<>();
            stk = new StringTokenizer(br.readLine());
            x = Integer.parseInt(stk.nextToken());
            y = Integer.parseInt(stk.nextToken());
            q.add(new Info(x,y));
            while(n-- > 0){
                stk = new StringTokenizer(br.readLine());
                x = Integer.parseInt(stk.nextToken());
                y = Integer.parseInt(stk.nextToken());
                supplement.add(new Info(x,y));
            }
            stk = new StringTokenizer(br.readLine());
            x = Integer.parseInt(stk.nextToken());
            y = Integer.parseInt(stk.nextToken());
            supplement.add(new Info(x,y));
            end = new Info(x,y);
            bfs();
        }

    }

    private static void bfs() {
        while(!q.isEmpty()){
            Info temp = q.poll();
            int cx = temp.x;
            int cy = temp.y;
            if(cx==end.x && cy==end.y){
                System.out.println("happy");
                return;
            }
            int size = supplement.size();
            while(size-- > 0){
                Info s = supplement.poll();
                int sx = s.x;
                int sy = s.y;
                int dist = Math.abs(cx-sx)+Math.abs(cy-sy);
                if(dist<=1000){
                    q.add(s);
                }else
                    supplement.add(s);
            }
        }
        System.out.println("sad");
    }

    private static class Info {
        int x,y;

        public Info(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
