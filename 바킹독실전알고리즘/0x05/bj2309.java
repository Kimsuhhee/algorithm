import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        boolean flag = false;
        int sum = 0;
        for(int i=0;i<9;i++){
            arr[i] = Integer.parseInt(br.readLine());
            sum+=arr[i]; //난쟁이 9명의 키의 합
        }

        for(int i=0;i<9;i++){
            if(flag)break;
            for(int j=0;j<9;j++){
                if(i==j)continue;
                if(sum-arr[i]-arr[j]==100){
                    // 두명의 키의 합을 9명의 키의 합에서 뺄경우 100이 된다면
                    // 두명의 키에 0을 대입
                    arr[i]=0;
                    arr[j]=0;
                    flag= true;
                    break;
                }
            }
        }
        Arrays.sort(arr);
        for(int i=0;i<9;i++){
            if(arr[i]!=0) System.out.println(arr[i]);
        }
    }
}
