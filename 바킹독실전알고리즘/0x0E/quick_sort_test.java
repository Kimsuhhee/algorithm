public class quick_sort_test {
    static int[] arr = new int[]{6,-8,1,12,8,3,7,-7};

    public static void main(String[] args) {
        int len = arr.length;
        quick_sort(0,len);
        for(int i=0;i<arr.length;i++) System.out.print(arr[i]+" ");
    }

    private static void quick_sort(int st, int en) {
        if(en<=st+1)return;
        int pivot = arr[st];
        int l = st+1;
        int r = en-1;
        int temp;
        while(true){
            while(l<=r && arr[l] <= pivot)l++;
            while(l<=r && arr[r] >= pivot)r--;
            if(r<l) break;
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
        }

        arr[st] = arr[r];
        arr[r] = pivot;
        for(int i=0;i<arr.length;i++) System.out.print(arr[i]+" ");
        System.out.println();
        quick_sort(st,r);
        quick_sort(r+1,en);
    }

}
