import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class bj14226 {
    static int S;
    static int[][] d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = Integer.parseInt(br.readLine());
        d = new int[1001][1001]; //[화면][클립보드]
        for(int i=0;i<=1000;i++){
            Arrays.fill(d[i],-1);
        }
        Queue<Emoticon>q = new LinkedList<>();
        q.add(new Emoticon(0,1,0));
        d[1][0] = 0;
        int t = 0;
        while(!q.isEmpty()){
            Emoticon e = q.poll();
            if(e.screen==S){
                t = e.time;
                break;
            }
            if(e.screen>=1 && e.screen<1001){
                //화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장
                if(d[e.screen][e.screen]==-1) {
                    q.add(new Emoticon(e.time + 1, e.screen, e.screen));
                    d[e.screen][e.screen] = e.time + 1;
                }
                //화면에 있는 이모티콘 중 하나 삭제
                if(d[e.screen-1][e.clipboard]==-1) {
                    q.add(new Emoticon(e.time + 1, e.screen-1, e.clipboard));
                    d[e.screen-1][e.clipboard] = e.time + 1;
                }
            }
            if(e.clipboard>0 && e.screen+e.clipboard<1001){
                //클립보드에 있는 모든 이모티콘을 화면에 붙여넣기
                if(d[e.screen+e.clipboard][e.clipboard]==-1) {
                    q.add(new Emoticon(e.time + 1, e.screen + e.clipboard, e.clipboard));
                    d[e.screen+e.clipboard][e.clipboard] = e.time + 1;
                }
            }
        }
        System.out.println(t);
    }

    private static class Emoticon {
        int time,screen,clipboard;

        public Emoticon(int time, int screen, int clipboard) {
            this.time = time;
            this.screen = screen;
            this.clipboard = clipboard;
        }
    }
}
