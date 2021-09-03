import java.util.ArrayList;

public class 프렌즈4블록 {
    static int answer;
    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,1,1,1,0,-1,-1,-1};
    public static void main(String[] args) {
        //int m = 4;
        int m = 6;
        //int n = 5;
        int n = 6;
        String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
        //String[] board = {"CCBDE","AAADE","AAABF","CCBBF"};
        System.out.println(solution(m,n,board));
    }
    public static int solution(int m, int n, String[] board) {
        char[][] ch = new char[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ch[i][j] = board[i].charAt(j);
            }
        }

        while(true) {

            boolean[][] check = new boolean[m][n];
            boolean possible = false;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if(ch[i][j]=='.')continue;
                    if (checkSquare(ch, i, j, m,n,0)){
                        checkpop(check,i,j,0);
                        possible = true;
                    }
                    if (checkSquare(ch, i, j,m,n,2)){
                        checkpop(check,i,j,2);
                        possible = true;
                    }
                    if (checkSquare(ch, i, j,m,n,4)) {
                        checkpop(check,i,j,4);
                        possible = true;
                    }
                    if (checkSquare(ch, i, j,m,n,6)) {
                        checkpop(check,i,j,6);
                        possible = true;
                    }
                }
            }
            if(possible==false)break;

            pop(ch,check,m,n);

            drop(ch,m,n);

        }
        return answer;
    }

    private static void drop(char[][] ch, int m, int n) {
        for(int i=0;i<n;i++){
            ArrayList<Character>list = new ArrayList<>();
            for(int j=m-1;j>=0;j--){
                if(ch[j][i]!='.'){
                    list.add(ch[j][i]);
                    ch[j][i]='.';
                }
            }
            int x = m-1;
            for(int j=0;j<list.size();j++){
                ch[x--][i] = list.get(j);
            }
        }
    }

    private static void pop(char[][] ch, boolean[][] check,int m,int n) {
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(check[i][j]==true){
                    ch[i][j] = '.';
                    answer++;
                }
            }
        }
    }


    private static void checkpop(boolean[][] check, int x, int y, int dir) {
        for(int i=0;i<3;i++){
            int mx = x + dx[(dir+i)%8];
            int my = y + dy[(dir+i)%8];
            check[mx][my] = true;
        }
    }

    private static boolean checkSquare(char[][] ch, int x, int y, int m,int n,int dir) {
        char cur = ch[x][y];
        int sum = 0;
        for(int i=0;i<3;i++){
            int mx = x + dx[(dir+i)%8];
            int my = y + dy[(dir+i)%8];
            if(mx<0||my<0||mx>=m||my>=n)continue;
            if(ch[mx][my]==cur) sum++;
        }
        if(sum==3)return true;
        else return false;
    }
}
