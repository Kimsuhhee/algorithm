import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj2565 {
    static int a,b;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Info[] arr = new Info[n];

        for(int i=0;i<n;i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            a = Integer.parseInt(stk.nextToken());
            b = Integer.parseInt(stk.nextToken());
            arr[i] = new Info(a,b);
        }

        Arrays.sort(arr);
        int max = -1;
        int[] d = new int[n];
        d[0] = 1;
        for(int i=1;i<n;i++){
            Info cur = arr[i];
            d[i] = 1;
            for(int j=0;j<i;j++){
                if(cur.b>arr[j].b){
                    d[i] = Math.max(d[i],d[j]+1);
                }
            }
            max = Math.max(max,d[i]);
        }
        System.out.println(n-max);
    }

    private static class Info implements Comparable<Info>{
        int a,b;

        public Info(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Info o) {
            return this.a-o.a;
        }
    }
}
