public class 메뉴리뉴얼 {
    public static void main(String[] args) {
        //String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        //String[] orders = {"XYZ", "XWY", "WXA"};
        int[] course = {2,3,4};
        String[] orders = {"ABCD","ABCD","ABCD"};
        String[] answer = solution(orders,course);
        for(String s:answer) System.out.print(s+" ");
    }
    public static String[] solution(String[] orders, int[] course) {
        HashMap<String,Integer>map = new HashMap<>();
        for(int i=0;i<orders.length;i++){
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            for(int j=0;j<course.length;j++){
                boolean[]visited = new boolean[arr.length];
                permutation(arr,0,0,course[j],map,"");
            }
        }
        System.out.println(map);
        ArrayList<String>menu = new ArrayList<>();
        for(int i=0;i<course.length;i++){
            int max = 0;
            for(String s:map.keySet()){
                if(s.length()==course[i]){
                    max = Math.max(max,map.get(s));
                }
            }
            if(max>=2) {
                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    if (entry.getKey().length() == course[i] && entry.getValue() == max) {
                        menu.add(entry.getKey());
                    }
                }
            }
        }
        Collections.sort(menu);
        String[] answer = menu.toArray(new String[menu.size()]);
        return answer;
    }

    private static void permutation(char[] arr, int n,int start, int N, HashMap<String, Integer> map, String s) {
        if(n==N){
            map.put(s,map.getOrDefault(s,0)+1);
            return;
        }
        for(int i=start;i<arr.length;i++){
            permutation(arr, n + 1,i+1, N, map,s + arr[i]);
        }
    }
}
