import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine());


        List<Integer> l=new ArrayList<>();

        int cnt=0;

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){

            l.add(Integer.parseInt(st.nextToken()));
        }
        int x=Integer.parseInt(br.readLine());

        Collections.sort(l);
        Set<Integer> s=new HashSet<>(l);

        for(int i=0;i<n;i++){
            if(s.contains(x-l.get(i))&&l.get(i)<x-l.get(i)) {cnt++;}
        }
        System.out.println(cnt);

    }
}