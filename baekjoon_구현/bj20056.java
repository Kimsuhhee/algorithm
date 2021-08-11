import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj20056 {
    static int N,M,K,r,c,m,s,d;
    static ArrayList<fireball>[][] area;
    static Queue<fireball>q = new LinkedList<>();
    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,1,1,1,0,-1,-1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());

        while(M-- > 0){
            stk = new StringTokenizer(br.readLine()," ");
            r = Integer.parseInt(stk.nextToken());
            c = Integer.parseInt(stk.nextToken());
            m = Integer.parseInt(stk.nextToken());
            s = Integer.parseInt(stk.nextToken());
            d = Integer.parseInt(stk.nextToken());
            q.add(new fireball(r-1,c-1,m,s,d));
        }

        while(K-- > 0){
            init();
            move();
            merge();
        }
        System.out.println(cal());

    }

    private static void init() {
        area = new ArrayList[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                area[i][j] = new ArrayList<fireball>();
            }
        }
    }

    private static void merge() {

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                int odd = 0, even = 0;
                int mm = 0 , ms = 0, sum = 0, sum1 = 0;
                if(area[i][j].size()==0)continue;
                if(area[i][j].size()==1){
                    q.add(area[i][j].get(0));
                    continue;
                }
                if(area[i][j].size()>=2){
                    for(fireball f : area[i][j]){
                        sum += f.m;
                        sum1 += f.s;
                        if(f.d % 2 == 0) even++;
                        else odd++;
                    }

                    int x = area[i][j].get(0).x;
                    int y = area[i][j].get(0).y;
                    mm = sum/5;
                    ms = sum1/area[i][j].size();

                    if(mm==0){
                        continue;
                    }
                    if(odd==area[i][j].size()||even==area[i][j].size()){
                        q.add(new fireball(x,y,mm,ms,0));
                        q.add(new fireball(x,y,mm,ms,2));
                        q.add(new fireball(x,y,mm,ms,4));
                        q.add(new fireball(x,y,mm,ms,6));
                    }else{
                        q.add(new fireball(x,y,mm,ms,1));
                        q.add(new fireball(x,y,mm,ms,3));
                        q.add(new fireball(x,y,mm,ms,5));
                        q.add(new fireball(x,y,mm,ms,7));
                    }
                }

            }
        }
    }

    private static int cal() {
        int sum = 0;
        while(!q.isEmpty()){
            fireball temp = q.poll();
            sum += temp.m;
        }
        return sum;
    }

    private static void move() {
        while(!q.isEmpty()){
            fireball temp = q.poll();
            int x = temp.x;
            int y = temp.y;
            int m = temp.m;
            int s = temp.s;
            int d = temp.d;
            int mx = (x + (dx[d]*s) + 1000) % N;
            int my = (y + (dy[d]*s) + 1000) % N;
            area[mx][my].add(new fireball(mx,my,m,s,d));
        }
    }

    private static class fireball {
        int x,y,m,s,d;

        public fireball(int x, int y, int m, int s, int d) {
            this.x = x;
            this.y = y;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }
}
