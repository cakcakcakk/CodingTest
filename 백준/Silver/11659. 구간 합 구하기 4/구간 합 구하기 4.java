import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		StringBuilder sb=new StringBuilder();
		List<Integer> l=new ArrayList<>();

		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int[] a=new int[N+1];
		
		st=new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++){
		    a[i]=Integer.parseInt(st.nextToken())+a[i-1];
		}
		
		for(int i=0;i<M;i++){
		    st=new StringTokenizer(br.readLine());
		    int x=Integer.parseInt(st.nextToken());
		    int y=Integer.parseInt(st.nextToken());
            int cnt=a[y]-a[x-1];
		    sb.append(cnt).append("\n");
		}	
        System.out.print(sb);
		
	}
}
