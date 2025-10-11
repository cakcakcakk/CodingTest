import java.util.*;
import java.io.*;

public class Main
{
    static String[] str;
    static boolean[] visited;
    static Set<Integer> set=new HashSet<>();
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    String input=br.readLine();
	    str=input.split("");
	    visited=new boolean[str.length];
	    
	    // 앞자리에 0이 오게 하지는 말자
	    dfs("",0);
	    
	    List<Integer> list=new ArrayList<>(set);
	    Collections.sort(list);
	    

	    if(set.size()==1|| list.get(list.size()-1)==Integer.parseInt(input)) System.out.println(0);
		else {
		    for(int k:list) {
                if(k>Integer.parseInt(input)) {
                    System.out.println(k);
                    break;
                }
	        }
		}
	}
	private static void dfs(String s, int depth) {
	    if(depth==str.length) {
	        set.add(Integer.parseInt(s));
	        return;
	    }
	    
	    for(int i=0;i<str.length;i++) {
	        if(depth==0 && str[i]=="0") continue; // 맨 앞자리가 0이면 안 됨
	        if(!visited[i]) {
	            visited[i]=true;
	            dfs(s+str[i],depth+1);
	            visited[i]=false;
	        }
	    }
	    
	} 
}