import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj2342 {
    static int[][][] d;
    static ArrayList<Integer>command;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        command = new ArrayList<>();
        while(stk.hasMoreTokens()){
            int n = Integer.parseInt(stk.nextToken());
            if(n==0)break;
            command.add(n);
        }

        d = new int[command.size()][5][5];
        for(int i=0;i<command.size();i++){
            for(int j=0;j<5;j++){
                for(int k=0;k<5;k++){
                    d[i][j][k] = 100000000;
                }
            }
        }
        System.out.println(dfs(0,0,0));
    }

    private static int dfs(int order, int left, int right) {
        if(order==command.size()) return 0;

        //왼발, 오른발이 같은 위치에 있는 경우
        if(left!=0 && right!=0 && left==right) return 100000000;

        //이미 최소값을 갱신한 적이 있다면 해당 값 리턴
        if(d[order][left][right]!=100000000) return d[order][left][right];

        //왼발의 위치가 0인 경우
        if(left==0) {
            d[order][left][right] = Math.min(d[order][left][right], dfs(order + 1, command.get(order), right)+2);
        }

        //오른발의 위치가 0인 경우
        if(right==0){
            d[order][left][right] = Math.min(d[order][left][right], dfs(order + 1, left,command.get(order))+2);
        }

        //왼발의 위치가 0이 아닌 경우
        if(left>0){
            int next = command.get(order);
            //반대편으로 움직일때
            if(Math.abs(next-left)==2) {
                d[order][left][right] = Math.min(d[order][left][right], dfs(order + 1, next,right)+4);
            }else if(Math.abs(next-left)==0){ //같은지점을 한번더 누를때
                d[order][left][right] = Math.min(d[order][left][right], dfs(order + 1, next,right)+1);
            }else{ //인접한 지점으로 움직일때
                d[order][left][right] = Math.min(d[order][left][right], dfs(order + 1, next,right)+3);
            }
        }

        //오른발의 위치가 0이 아닌 경우
        if(right>0){
            int next = command.get(order);
            //반대편으로 움직일때
            if(Math.abs(next-right)==2) {
                d[order][left][right] = Math.min(d[order][left][right], dfs(order + 1, left,next)+4);
            }else if(Math.abs(next-right)==0){ //같은지점을 한번더 누를때
                d[order][left][right] = Math.min(d[order][left][right], dfs(order + 1, left,next)+1);
            }else{ //인접한 지점으로 움직일때
                d[order][left][right] = Math.min(d[order][left][right], dfs(order + 1, left,next)+3);
            }
        }
        return d[order][left][right];
    }
}
