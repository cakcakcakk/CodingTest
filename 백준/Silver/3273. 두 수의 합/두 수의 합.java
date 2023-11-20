import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine());

        int[] l =new int[n];
        Set<Integer> s=new HashSet<>();

        int cnt=0;

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            l[i]=Integer.parseInt(st.nextToken());
            s.add(l[i]);
        }
        int x=Integer.parseInt(br.readLine());
        Arrays.sort(l);

        for(int i=0;i<n;i++){
            if(s.contains(x-l[i])&&l[i]<x-l[i]) {cnt++;}
        }
        System.out.println(cnt);

    }
}