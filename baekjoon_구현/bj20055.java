import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj20055 {
    static int N,K;
    static int[] belt;
    static boolean[] robot;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());
        belt = new int[N*2];
        robot = new boolean[N];
        stk = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<2*N;i++){
            belt[i] = Integer.parseInt(stk.nextToken());
        }

        int level = 0;
        while(true){
            if(findZero()>=K){
                System.out.println(level);
                break;
            }
            rotate();
            move_robot();
            if(!robot[0] && belt[0]>0){
                robot[0] = true;
                belt[0] -= 1;
            }
            level++;
        }

    }

    private static void move_robot() {
        for(int i=N-1;i>0;i--){
            if(robot[i-1]&&!robot[i]&&belt[i]>0){
                belt[i]-=1;
                robot[i] = true;
                robot[i-1] = false;
            }
        }
    }

    private static void rotate() {
        int temp = belt[2*N-1];
        for(int i=2*N-1;i>0;i--){
            belt[i] = belt[i-1];
        }
        belt[0] = temp;

        for(int i=N-1;i>0;i--){
            robot[i] = robot[i-1];
        }
        robot[0] = false;
        robot[N-1] = false;
    }

    private static int findZero() {
        int cnt = 0;
        for(int n:belt){
            if(n==0)cnt++;
        }
        return cnt;
    }


}
