import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
    static final int INF=Integer.MAX_VALUE;
    static ArrayList<Node>[] a;
    static int[] dist;
    static PriorityQueue<Node> q=new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int V=Integer.parseInt(st.nextToken());
        int E=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(br.readLine());

        a=new ArrayList[V+1];
        dist=new int[V+1];

        for(int i=0;i<=V;i++) a[i]=new ArrayList<>();
        Arrays.fill(dist,INF);

        for(int i=0;i<E;i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            int w=Integer.parseInt(st.nextToken());

            a[u].add(new Node(v,w));
        }

        dijkstra(K);

        for(int i=1;i<=V;i++){
            if(dist[i]==INF) System.out.println("INF");
            else System.out.println(dist[i]);
        }

    }

    static void dijkstra(int K){
        dist[K]=0;
        q.add(new Node(K,0));

        while(!q.isEmpty()){
            Node now=q.poll();

            for(int i=0;i<a[now.v].size();i++){
                Node next=(Node)a[now.v].get(i);
                if(dist[next.v]>now.w+next.w){
                    dist[next.v]=now.w+next.w;
                    q.add(new Node(next.v,dist[next.v]));
                }
            }

        }
    }

}
class Node implements Comparable<Node>{
    int v,w;

    public Node(int v,int w){
        this.v=v;
        this.w=w;
    }
    @Override
    public int compareTo(Node n){
        return this.w-n.w;
    }
}