public class 방금그곡 {
    public static void main(String[] args) {
        String m ="CC#BCC#BCC#BCC#B";
        String[] musicinfos = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
        System.out.println(solution(m,musicinfos));
    }
    public static String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        m = change(m);

        int max = 0;

        for(int i=0;i<musicinfos.length;i++){
            String[] str = musicinfos[i].split(",");

            String[] start = str[0].split(":");
            String[] end = str[1].split(":");
            int sTime = Integer.parseInt(start[0]);
            int eTime = Integer.parseInt(end[0]);
            int sMinute = Integer.parseInt(start[1]);
            int eMinute = Integer.parseInt(end[1]);

            //음악 구간
            int interval = (eTime - sTime)*60 + (eMinute - sMinute);

            //구간동안 반복되는 멜로디
            String info = change(str[3]);
            int len = info.length();

            String fullSong = "";
            if(interval>len){
                int d = interval/len;
                int r = interval%len;
                for(int j=0;j<d;j++){
                    fullSong += info;
                }
                for(int j=0;j<r;j++){
                    fullSong += info.charAt(j);
                }
            }else if(interval<len){
                for(int j=0;j<interval;j++){
                    fullSong += info.charAt(j);
                }
            }else fullSong += info;

            //멜로디가 구간에 속할때,
            // 만약 이미 정답이 나온상황이라면 가장 길게 재생된 음악인지
            if(fullSong.contains(m)){
                if(max<interval){
                    max = interval;
                    answer = str[2];
                }
            }
            
        }
        return answer;
    }

    private static String change(String s) {
        s = s.replaceAll("C#","c");
        s = s.replaceAll("D#","d");
        s = s.replaceAll("F#","f");
        s = s.replaceAll("G#","g");
        s = s.replaceAll("A#","a");
        return s;
    }

}
