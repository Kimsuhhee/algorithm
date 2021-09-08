import java.util.ArrayList;
import java.util.Collections;

public class 기둥과보설치 {
    public static void main(String[] args) {
        int n = 5;
        int[][] build_frame = {{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0},{2,2,0,1}};
        //int[][] build_frame = {{1,0,0,1}, {1,1,1,1},{2,1,0,1}, {2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1}};
        int[][] result = solution(n,build_frame);
        for(int i=0;i<result.length;i++){
            for(int j=0;j<result[i].length;j++){
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static int[][] solution(int n, int[][] build_frame) {
        boolean[][][] installed = new boolean[2][n+2][n+2];
        for(int i=0;i<build_frame.length;i++){
            int[] temp = build_frame[i];
            int x = temp[0]+1;
            int y = temp[1]+1;
            int a = temp[2];
            int b = temp[3];

            if(a==0){ //기둥
                if(b==1 && installPillar(x,y,installed)){ //설치
                    installed[0][x][y] = true;
                }
                if(b==0 && remove(x,y,a,n,installed)){ //제거
                    installed[0][x][y] = false;
                }
            }
            if(a==1){ //보
                if(b==1 && installBeam(x,y,installed)){ //설치
                    installed[1][x][y] = true;
                }
                if(b==0 && remove(x,y,a,n,installed)){ //제거
                    installed[1][x][y] = false;
                }

            }

        }
        ArrayList<Info>list = new ArrayList<Info>();
        for(int i=1;i<=n+1;i++){
            for(int j=1;j<=n+1;j++){
                if(installed[0][i][j])list.add(new Info(i-1,j-1,0));
                if(installed[1][i][j])list.add(new Info(i-1,j-1,1));
            }
        }
        Collections.sort(list);
        int[][]answer = new int[list.size()][3];
        int idx = 0;
        for(Info info:list){
            answer[idx][0] = info.x;
            answer[idx][1] = info.y;
            answer[idx][2] = info.type;
            idx++;
        }
        return answer;
    }

    private static boolean remove(int x, int y, int a, int n,boolean[][][] installed) {
        installed[a][x][y] = false;
        boolean possible = true;
        for(int i=1;i<=n+1;i++){
            for(int j=1;j<=n+1;j++){
                if(installed[0][i][j] && !installPillar(i,j,installed)){
                    possible = false;
                    break;
                }
                if(installed[1][i][j] && !installBeam(i,j,installed)){
                    possible = false;
                    break;
                }
            }
            if(possible==false)break;
        }
        installed[a][x][y] = true;
        return possible;
    }

    private static boolean installBeam(int x, int y, boolean[][][] installed) {
        if(installed[0][x][y-1]||installed[0][x+1][y-1]||installed[1][x-1][y]&&installed[1][x+1][y]) return true;
        else return false;
    }

    private static boolean installPillar(int x, int y, boolean[][][] installed) {
        if(y==1||installed[0][x][y-1]||installed[1][x-1][y]||installed[1][x][y]) return true;
        else return false;
    }

    private static class Info implements Comparable<Info>{
        int x,y,type;

        public Info(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }

        @Override
        public int compareTo(Info o) {
            if(this.x==o.x){
                if(this.y==o.y){
                    return this.type - o.type;
                }return this.y-o.y;
            }
            return this.x - o.x;
        }
    }
}
