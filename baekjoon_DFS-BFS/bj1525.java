import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj1525 {
    static String start = "123456780"; //초기상태
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        String str = "";
        for(int i=0;i<3;i++){
            stk = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++){
                str+= Integer.parseInt(stk.nextToken());
            }
        }
        
        //초기상태와 같은경우 끝내기
        if(str.equals(start)){
            System.out.println(0);
            System.exit(0);
        }

        //아닌경우 -> BFS수행
        int answer = Integer.MAX_VALUE;

        Queue<Info>q = new LinkedList<>();
        q.add(new Info(str,0));

        HashSet<String>set = new HashSet<>();
        set.add(str);

        while(!q.isEmpty()){
            Info cur = q.poll();
            
            //현재 문자열과 초기상태가 같으면 정답횟수 갱신 후 반복문 탈출
            if(cur.s.equals(start)){
                answer = cur.cnt;
                break;
            }

            //문자열에서 '0'의 인덱스 구하기
            int idx = cur.s.indexOf('0');

            int cx = idx/3; int cy = idx%3;

            //현재 위치에서 상하좌우 인접한 칸 탐색
           for(int i=0;i<4;i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(nx<0||ny<0||nx>=3||ny>=3)continue;
                char[] ch = cur.s.toCharArray();

                //'0'과 인접한 칸의 위치를 바꾸어 문자열 만들기
                char temp = ch[nx*3+ny];
                ch[idx] = temp;
                ch[nx*3+ny] = '0';
                String s = new String(ch);

                //만들지 않았던 문자열이면 q에 넣기
                if(!set.contains(s)){
                    set.add(s);
                    q.add(new Info(s,cur.cnt+1));
                }
            }

        }

        if(answer==Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(answer);

    }

    private static class Info {
        String s;
        int cnt;

        public Info(String s, int cnt) {
            this.s = s;
            this.cnt = cnt;
        }
    }
}
