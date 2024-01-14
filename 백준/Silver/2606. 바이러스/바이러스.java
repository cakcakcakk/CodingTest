import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int a[][];
    static boolean visited[];
    static int count=0;
    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int M=Integer.parseInt(br.readLine());

        a=new int[N+1][N+1];
        visited=new boolean[N+1];

        for(int i=0;i<M;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            a[x][y]=a[y][x]=1;
        }
        System.out.println(dfs(1));
    }

    public static int dfs(int v){
        visited[v]=true;

        for(int i=0;i<a[v].length;i++){
            if(a[v][i]==1 && !visited[i]){
                count++;
                dfs(i);
            }
        }

        return count;

    }
}