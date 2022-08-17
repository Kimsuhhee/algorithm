import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj16172 {
    static String s,k;
    static int[] fArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        k = br.readLine();

        //문자열에 존재하는 숫자 제거
        s = s.replaceAll("[0-9]","");

        //실패함수 구하기
        getFarr();

        //KMP
        char[] S = s.toCharArray();
        char[] K = k.toCharArray();
        int j=0;
        boolean find = false;
        for(int i=0;i<S.length;i++){
            while(j > 0 && S[i] != K[j]) j = fArr[j-1];
            if(S[i] == K[j]) {
                if (j == K.length - 1) {
                    find = true;
                    break;
                }
                else j++;
            }
        }
        if(find) System.out.println(1);
        else System.out.println(0);
    }

    private static void getFarr() {
        fArr = new int[k.length()];
        char[] temp = k.toCharArray();
        int j=0;
        for(int i=1;i<temp.length;i++){
            while(j > 0 && temp[i] != temp[j]) j = fArr[j-1];
            if(temp[i] == temp[j]) fArr[i] = ++j;
        }
    }
}
