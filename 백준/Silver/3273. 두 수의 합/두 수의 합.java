import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine());

        Set<Integer> s=new HashSet<>();
        int cnt=0;

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            s.add(Integer.parseInt(st.nextToken()));
        }
        int x=Integer.parseInt(br.readLine());

        for(int k:s){
            if(s.contains(x-k)&&x-k>k){ cnt++;}
        }
        System.out.println(cnt);

    }
}