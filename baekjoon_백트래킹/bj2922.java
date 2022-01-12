import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj2922 {
    static long answer;
    static char[] ch;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ch = br.readLine().toCharArray();
        changeWord(0,ch.length,0,0,false,1);
        System.out.println(answer);
    }

    private static void changeWord(int n, int N, int vcnt, int ccnt, boolean lFlag, long cnt) {
        if(n==N){
            //'L'포함되었을 때
            if(lFlag)answer += cnt;
            return;
        }
		
        //모음, 'L'제외 자음, 'L'을 넣는 경우
        if(ch[n]=='_'){
            //모음이 연속 2회나오지 않은 경우
            if(vcnt<2){
                //모음개수 카운트+1, 모음 개수 만큼 횟수 곱하기
                changeWord(n+1,N,vcnt+1,0,lFlag,cnt*5);
            }

            //자음이 연속 2회나오지 않은 경우
            if(ccnt<2){
                 //자음 개수 카운트+1, 'L'제외 한 자음 개수 만큼 횟수 곱하기
                changeWord(n+1,N,0,ccnt+1,lFlag,cnt*20);
                 //자음 개수 카운트+1
                changeWord(n+1,N,0,ccnt+1,true,cnt);
            }

          //모음인 경우
        }else if(ch[n]=='A'||ch[n]=='E'||ch[n]=='I'||ch[n]=='O'||ch[n]=='U') {
            //모음이 연속 2회나오지 않은 경우
            if (vcnt<2) changeWord(n + 1, N, vcnt + 1, 0, lFlag, cnt);

         //자음인 경우
        }else{
            //자음이 연속 2회나오지 않았고 , 'L'과 'L'이 아닌경우
            if(ccnt<2) {
                if(ch[n]=='L')
                    changeWord(n + 1, N, 0 , ccnt+1, true, cnt);
                else
                    changeWord(n + 1, N, 0 , ccnt+1, lFlag, cnt);
            }
        }
    }
}
