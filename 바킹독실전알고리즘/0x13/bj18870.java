import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj18870 {
    static int N;
    static Long[] arr,temp,arr1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new Long[N];
        arr1 = new Long[N];
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            arr[i] = Long.parseLong(stk.nextToken());
            arr1[i] = arr[i];
        }

        Arrays.sort(arr);
        ArrayList<Long>list = new ArrayList<>();
        Long max = (long)-1000000000;
        for(int i=0;i<N;i++){
            if(max==arr[i])continue;
            if(max<arr[i]){
                max = arr[i];
                list.add(max);
            }
        }
        StringBuilder sb = new StringBuilder();
        temp = new Long[list.size()];
        int size = 0;
        for(Long i:list){
            temp[size++] = i;
        }
        for(Long i:arr1){
            sb.append(binarySearch(i)+" ");
        }
        System.out.println(sb);
    }

    private static int binarySearch(long num) {
        int st = 0, en = temp.length-1;
        while(st<=en){
           int mid = (st+en)/2;
            if(temp[mid]<num){
                st = mid+1;
            }else if(temp[mid]>num){
                en = mid-1;
            }else if(temp[mid]==num)return mid;
        }
        return  -1;
    }
}
