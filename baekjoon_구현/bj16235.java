import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj16235 {
    static int N,M,K,x,y,z;
    static PriorityQueue<Tree>trees;
    static Queue<Tree> die;
    static Queue<Tree>alive;
    static int[] dx = {-1,-1,-1,0,0,1,1,1};
    static int[] dy = {-1,0,1,-1,1,-1,0,1};
    static int[][] map;
    static int[][] add;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());
        map = new int[N+1][N+1];
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                map[i][j] = 5;
            }
        }
        add = new int[N+1][N+1];
        for(int i=1;i<=N;i++){
            stk = new StringTokenizer(br.readLine()," ");
            for(int j=1;j<=N;j++){
                add[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        trees = new PriorityQueue<>();

        while(M-- > 0){
            stk = new StringTokenizer(br.readLine()," ");
            x = Integer.parseInt(stk.nextToken());
            y = Integer.parseInt(stk.nextToken());
            z = Integer.parseInt(stk.nextToken());
            trees.add(new Tree(x,y,z));
        }

        die = new LinkedList<>();
        alive = new LinkedList<>();

        while(K-- > 0){

            //봄
            while(!trees.isEmpty()){
                Tree temp = trees.poll();
                x = temp.x;
                y = temp.y;
                int age = temp.age;
                if(map[x][y]>=age){
                    map[x][y]-=age;
                    alive.add(new Tree(x,y,age+1));
                }else{
                    die.add(new Tree(x,y,age));
                }
            }

            //여름
            while(!die.isEmpty()){
                Tree temp = die.poll();
                int add = temp.age/2;
                map[temp.x][temp.y] += add;
            }

            //가을
            while(!alive.isEmpty()){
                Tree temp = alive.poll();
                if(temp.age%5==0) {
                    for (int i = 0; i < 8; i++) {
                        int cx = temp.x + dx[i];
                        int cy = temp.y + dy[i];
                        if (cx >= 1 && cy >= 1 && cx <= N && cy <= N) {
                            trees.add(new Tree(cx, cy, 1));
                        }
                    }
                }
                trees.add(new Tree(temp.x,temp.y,temp.age));
            }

            //겨울
            for(int i=1;i<=N;i++){
                for(int j=1;j<=N;j++){
                    map[i][j] += add[i][j];
                }
            }
            /**
            System.out.println("============================");
            Iterator<Tree>it = trees.iterator();
            while(it.hasNext()){
                Tree temp = it.next();
                System.out.println(temp.x+" "+temp.y+" "+temp.age);
            }
             **/

        }
        System.out.println(trees.size());

    }


    private static class Tree implements Comparable<Tree> {
        int x,y,age;

        public Tree(int x, int y, int age) {
            this.x = x;
            this.y = y;
            this.age = age;
        }

        @Override
        public int compareTo(Tree o) {
            return this.age-o.age;
        }
    }
}
