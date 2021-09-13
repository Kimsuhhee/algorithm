import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj10815 {
    static int n,m;
    static int[] card;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        card = new int[n];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            card[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(card);

        m = Integer.parseInt(br.readLine());
        stk = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            int num = Integer.parseInt(stk.nextToken());
            System.out.print(binarySearch(num)+" ");
        }
    }

    private static int binarySearch(int num) {
        int st = 0, en = card.length-1;
        while(st<=en){
            int mid = (st+en)/2;
            if(card[mid]<num){
                st = mid + 1;
            }else if(card[mid]>num){
                en = mid - 1;
            }else return 1;
        }
        return 0;
    }
}
