import java.util.Scanner;

public class bj2750 {
    static int[] arr = new int[1000];
    static int num;
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        num = in.nextInt();
        for(int i=0;i<num;i++){
            arr[i]=in.nextInt();
        }
        sort();

        for(int i=0;i<num;i++) System.out.println(arr[i]);
    }

    private static void sort() {
        for(int i=0;i<num;i++){
            for(int j=i+1;j<num;j++){
                if(arr[i]>arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
