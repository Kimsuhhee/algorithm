import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class bj1431 {
    static int N;
    static String[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new String[N];
        for (int i = 0; i < N; i++)
            arr[i] = br.readLine();
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()!=o2.length()){
                    return o1.length()-o2.length();
                }
                else{
                    int sum1=0, sum2=0;
                    for(int i=0;i<o1.length();i++){
                        if(o1.charAt(i)>='0' && o1.charAt(i)<='9')
                            sum1 += o1.charAt(i)-'0';
                        if(o2.charAt(i)>='0' && o2.charAt(i)<='9')
                            sum2 += o2.charAt(i)-'0';
                    }
                    if(sum1==sum2)return o1.compareTo(o2);
                    return sum1 - sum2;
                }
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) sb.append(arr[i]).append("\n");
        System.out.println(sb);
    }
}