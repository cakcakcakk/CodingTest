import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static int[] dist;
    static ArrayList<Road>[] a;
    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int D=Integer.parseInt(st.nextToken());

        dist=new int[D+1];
        a=new ArrayList[10001];
        Arrays.fill(dist,Integer.MAX_VALUE);

        for(int i=0;i<10001;i++) a[i]=new ArrayList<>();

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            int w=Integer.parseInt(st.nextToken());

            if(v-u>w){
                a[v].add(new Road(u,w));
            }
        }
        dist[0]=0;
        for(int i=1;i<=D;i++){
            if(a[i].size()>0){
                for(Road s:a[i]){
                    if(dist[i]<dist[s.u]+s.w) continue;
                    dist[i]=Math.min(dist[i-1]+1,dist[s.u]+s.w);
                }
                continue;
            }
            dist[i]=dist[i-1]+1;
        }
        System.out.println(dist[D]);

    }
}

class Road {
    int u,w;
    public Road(int u,int w){
        this.u=u;
        this.w=w;
    }

}