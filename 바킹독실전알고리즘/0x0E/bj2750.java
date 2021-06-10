import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class bj2750 {
    static int N;
    static int[] arr;
    static int[] temp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        temp = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        merge_sort(0,N);
        for(int i=0;i<N;i++) System.out.print(arr[i]+" ");
    }

    private static void merge_sort(int start, int end) {
        if(end==start+1)return;
        int mid = (start+end)/2;
        merge_sort(start,mid);
        merge_sort(mid,end);
        merge(start,mid,end);
    }

    private static void merge(int start, int mid, int end) {
        int i=start;
        int j=mid;
        int k=start;

        while(i<mid && j<end){
            temp[k++] = (arr[i]<=arr[j]) ? arr[i++] : arr[j++];
        }
        if(i>mid){
            for(int idx=i;idx<end;idx++)temp[k++] = arr[idx];
        }
        else{
            for(int idx=i;idx<mid;idx++)temp[k++] = arr[idx];
        }
        for(int idx=start;idx<end;idx++)arr[idx] = temp[idx];
    }
}
