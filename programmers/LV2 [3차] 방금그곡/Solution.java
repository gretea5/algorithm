import java.util.StringTokenizer;
import java.util.Arrays;

class Solution {
    //곡의 정보 객체
    private static class Obj {
        int start;
        int end;
        String name;
        String music;
        
        Obj(int start, int end, String name, String music) {
            this.start = start;
            this.end = end;
            this.name = name;
            this.music = music;
        }
    }
    
    public String solution(String m, String[] musicinfos) {
        //#으로 되어 있는 문자열을 숫자로 변경(판별을 위해)
        m = m.replace("C#", "1");
        m = m.replace("D#", "2");
        m = m.replace("F#", "3");
        m = m.replace("G#", "4");
        m = m.replace("A#", "5");
        
        //음악 정보 객체 배열
        Obj[] arr = new Obj[musicinfos.length];
        
        for(int i = 0; i < musicinfos.length; i++) {
            StringTokenizer st = new StringTokenizer(musicinfos[i], ",");
            
            //시간 정보 * 60해서 파싱 이유? 24시간 형식으로 제공되기 때문에, 가능한 것
            String[] timeInfo = st.nextToken().split(":");
            
            int start = Integer.parseInt(timeInfo[0]) * 60 + Integer.parseInt(timeInfo[1]);
            
            timeInfo = st.nextToken().split(":");
            
            int end = Integer.parseInt(timeInfo[0]) * 60 + Integer.parseInt(timeInfo[1]);
            
            //이름 
            String name = st.nextToken();
            
            //음악, 입력 되기 이전에 #이 달린 음들을 바꿔준다.
            String music = st.nextToken();
            
            music = music.replace("C#", "1");
            music = music.replace("D#", "2");
            music = music.replace("F#", "3");
            music = music.replace("G#", "4");
            music = music.replace("A#", "5");
            
            //객체 배열에 입력
            arr[i] = new Obj(start, end, name, music);
        }
        
        //재생된 시간이 제일 긴 순서대로 정렬
        Arrays.sort(arr, (o1, o2) -> {
            int d1 = o1.end - o1.start;
            int d2 = o2.end - o2.start;
            
            return d2 - d1;
        });
        
        //음악 판별
        return judgeMusicName(m, arr);
    }
    
    private static String judgeMusicName(String m, Obj[] arr) {
        
        for(Obj musicInfo : arr) {
            //재생 시간
            int time = musicInfo.end - musicInfo.start;
            
            //원래의 음
            String music = musicInfo.music;
            
            StringBuilder sb = new StringBuilder();
            
            //재생된 음
            for(int i = 0; i < time; i++) {
                sb.append(music.charAt(i % music.length()));
            }
            
            //들었던 음에 포함이 되면 이름 리턴
            if(sb.toString().contains(m)) {
                return musicInfo.name;
            }    
        }
        
        //포함이 되지 않았다면 (None) 리턴
        return "(None)";
    }
    
}
