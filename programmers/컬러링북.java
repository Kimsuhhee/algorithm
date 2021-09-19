import java.util.*;
class 컬러링북 {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static boolean[][] visited;
    static Queue<Point>q = new LinkedList<>();
    static int area;
    public int[] solution(int m, int n, int[][] picture) {
        
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
    
        visited = new boolean[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && picture[i][j]!=0){
                    visited[i][j] = true;
                    q.add(new Point(i,j,picture[i][j]));
                    area = 0;
                    bfs(m,n,picture);
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea,area);
                }
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    public void bfs(int m,int n,int[][] picture){
        
        while(!q.isEmpty()){
            area++;
            Point cur = q.poll();
            for(int i=0;i<4;i++){
                int x = cur.x + dx[i];
                int y = cur.y + dy[i];
                if(x<0||y<0||x>=m||y>=n)continue;
                if(visited[x][y])continue;
                if(picture[x][y]==cur.type){
                    q.add(new Point(x,y,picture[x][y]));
                    visited[x][y] = true;
                }
            }
        }
        
    }
    
    class Point{
        int x,y,type;
        public Point(int x,int y,int type){
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }
}