import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        Set<String> s=new HashSet<>();
        List<String> l=new ArrayList<>();
        int cnt=0;

        for(int i=0;i<N;i++){
            s.add(br.readLine());
        }
        for(int i=0;i<M;i++){
            String str=br.readLine();
            if(s.contains(str)) {cnt++; l.add(str);}
        }
        Collections.sort(l);
        System.out.println(cnt);
        for(String str:l){
            System.out.println(str);
        }


    }
}