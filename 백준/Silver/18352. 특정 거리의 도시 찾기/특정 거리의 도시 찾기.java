import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static Queue<Integer>q=new LinkedList<>();
    static ArrayList<Integer>[]a;
    static int[] dist;
    static boolean zero;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());
        int X=Integer.parseInt(st.nextToken());

        a=new ArrayList[N+1];
        dist=new int[N+1];
        Arrays.fill(dist,Integer.MAX_VALUE);

        for(int i=0;i<=N;i++){
            a[i]=new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int A=Integer.parseInt(st.nextToken());
            int B=Integer.parseInt(st.nextToken());
            a[A].add(B);
        }

        dijkstra(X);

        for(int i=1;i<=N;i++){
            if(dist[i]==K){
                System.out.println(i);
                zero=true;
            }
        }

        if(!zero){
            System.out.println(-1);
        }
    }

    static void dijkstra(int X){
        dist[X]=0;
        q.add(X);

        while(!q.isEmpty()){
            int now=q.poll();
            for(int t:a[now]){
                if(dist[t]>dist[now]+1){
                    dist[t]=dist[now]+1;
                    q.add(t);
                }
            }
        }
    }
}