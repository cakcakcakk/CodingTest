import java.io.*;
import java.util.*;

public class Main
{   
    static int n,cnt;
    static boolean[] check;
    static int[][] arr;
    static int min=Integer.MAX_VALUE;
   public static void main(String[] args) throws IOException {
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       n=Integer.parseInt(br.readLine());
       
       arr=new int[n][n];
       check=new boolean[n];
       
       for(int i=0;i<n;i++){
           StringTokenizer st=new StringTokenizer(br.readLine());
           for(int j=0;j<n;j++) arr[i][j]=Integer.parseInt(st.nextToken());
       }
       makeTeam(0,0);
       //n/2명을 골라야 함...
      System.out.println(min);
   }
   
   private static void makeTeam(int index, int depth){
       if(depth==n/2) {
           power();
           return;
       }
       for(int i=index;i<n;i++){
           check[i]=true;
           makeTeam(i+1,depth+1);
           check[i]=false;
       }
   }
   
   private static void power(){
       int start=0,link=0;
       
       
       for(int i=0;i<n;i++){
           for(int j=0;j<n;j++){
               if(i==j) continue;
               if(check[i]&&check[j]) start+=arr[i][j];
               if(!check[i]&&!check[j]) link+=arr[i][j];
           }
       }
       
       min=Math.min(Math.abs(start-link),min);
   }
   
}