public class merge_sort_test {
    static int[] arr = new int[]{-20,14,5,99,81,1,55,47,8,-1};
    static int[] temp = new int[10];

    public static void main(String[] args) {
        merge_sort(0,arr.length);
        for(int i=0;i<arr.length;i++) System.out.print(arr[i]+" ");
    }

    private static void merge_sort(int st, int en) {
        if(en==st+1)return; //길이 1인 경우
        int mid = (st+en)/2;
        merge_sort(st,mid);
        merge_sort(mid,en);
        merge(st,en);
    }

    private static void merge(int st, int en) {

        int mid = (st+en)/2;
        int left = st;
        int right = mid;
        int k = st;
        while(left<mid && right<en){
            temp[k++] = (arr[left] <= arr[right]) ? arr[left++] : arr[right++];
        }
        while(left<mid){
            temp[k++] = arr[left++];
        }
        while(right<en){
            temp[k++] = arr[right++];
        }
        for(int i=st;i<en;i++)arr[i] = temp[i];

        for(int i=0;i<arr.length;i++) System.out.print(arr[i]+" ");
        System.out.println();
    }
}
