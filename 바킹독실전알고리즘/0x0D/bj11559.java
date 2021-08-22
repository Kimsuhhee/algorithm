import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class bj11559 {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static char[][] field;
    static boolean[][] visited;
    static ArrayList<Point>puyo;
    static Queue<Point>q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        field = new char[12][6];
        for(int i=0;i<12;i++){
            String s = br.readLine();
            for(int j=0;j<6;j++){
                field[i][j] = s.charAt(j);
            }
        }
        int answer = 0;
        while(true) {
            visited = new boolean[12][6];
            q = new LinkedList<>();
            boolean find = false;
            for (int i = 11; i >= 0; i--) {
                for (int j = 0; j < 6; j++) {
                    puyo = new ArrayList<>();
                    if (field[i][j] != '.' && !visited[i][j]) {
                        puyo.add(new Point(i, j, field[i][j]));
                        q.add(new Point(i, j, field[i][j]));
                        visited[i][j] = true;
                        bfs();
                        if (puyo.size() >= 4) {
                            find = true;
                            crush();
                        }
                    }
                }
            }
            if(!find)break;

            drop();
            answer++;

        }
        System.out.println(answer);
    }

    private static void drop() {
        for(int i=0;i<6;i++){
            ArrayList<Character> ch = new ArrayList<>();
            for(int j=11;j>=0;j--){
                if(field[j][i]!='.'){
                    ch.add(field[j][i]);
                    field[j][i] = '.';
                }
            }
            int x=11;
            for(int j=0;j<ch.size();j++){
                field[x--][i] = ch.get(j);
            }
        }
    }

    private static void crush() {
        for(Point p:puyo){
            field[p.x][p.y] = '.';
        }
    }

    private static void bfs() {
        while(!q.isEmpty()){
            Point p = q.poll();
            for(int i=0;i<4;i++){
                int x = p.x + dx[i];
                int y = p.y + dy[i];
                if(x<0||y<0||x>=12||y>=6)continue;
                if(field[x][y]==p.color&&!visited[x][y]){
                    visited[x][y] = true;
                    puyo.add(new Point(x,y,field[x][y]));
                    q.add(new Point(x,y,field[x][y]));
                }
            }
        }
    }

    private static class Point {
        int x,y;
        char color;

        public Point(int x, int y, char color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }
    }
}
