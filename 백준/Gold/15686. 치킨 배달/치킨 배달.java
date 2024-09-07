import java.io.*;
import java.util.*;

public class Main
{   
    static int[][] arr;
    static int min=Integer.MAX_VALUE;
    static int n,m;
    static List<int[]> chicken=new ArrayList<>();  //치킨집 리스트
    static List<int[]> house=new ArrayList<>();
    static boolean[][] visited;
    static boolean[] chickenSelect;  // 실제로 고른 m개의 치킨집
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    n=Integer.parseInt(st.nextToken());
	    m=Integer.parseInt(st.nextToken());
	    
	    arr=new int[n][n];
	    visited=new boolean[n][n];
	    
	    for(int i=0;i<n;i++){
	        st=new StringTokenizer(br.readLine());
	        for(int j=0;j<n;j++){
	            arr[i][j]=Integer.parseInt(st.nextToken());
	            if(arr[i][j]==2) {
	                chicken.add(new int[]{i,j});                
	            }
	            	            
	        }
	    }
	    chickenSelect=new boolean[chicken.size()];
	    
	    chicM(0,0);
	    	    
	    System.out.println(min);
		
	}
	
	private static void chicM(int idx, int depth){
	    //치킨집 m개를 고르기
	    if(depth==m) {
	        distance();  // m개 골랐으면 치킨거리 계싼
	        return;
	    }
	    
	    for(int i=idx;i<chicken.size();i++) {
	        chickenSelect[i]=true;  // 해당 치킨집은 넣자
	        chicM(i+1, depth+1);
	        chickenSelect[i]=false;
	    }
	}
	
	private static void distance(){
	    int result=0;

	    for(int i=0;i<n;i++){
	        for(int j=0;j<n;j++){
	            // 각 집 에서의 치킨거리 계산
	            if(arr[i][j]==1) {
	                int dist=Integer.MAX_VALUE;  //dist 큰값으로 초기화하기
	                for(int k=0;k<chickenSelect.length;k++) {
	                    
	                    if(chickenSelect[k]) {
	                        int[] now=chicken.get(k);
	                        int x=now[0];
	                        int y=now[1];
	    
	                        dist=Math.min(dist,Math.abs(i-x)+Math.abs(j-y));
	                    }
	                }
	                //dist는 하나의 집에서 젤 가까운 치킨거리
	                result+=dist;
	            }
	            // 한 집에서의 치킨거리 계산
	        }
	    }
	    
	    min=Math.min(min,result);
	}
}
