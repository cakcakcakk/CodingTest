import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[][] map;
	static boolean[][] checked;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
    public static void main (String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	N = Integer.parseInt(br.readLine());
    	
    	StringTokenizer st;
    	
    	map = new int[N][N];
    	int maxHeight = 0; // 맵에서 가장 큰 높이를 찾아서 그 만큼 잠기는 빗물 높이를 탐색하기 위해
    	
    	for(int i=0; i<N; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j=0; j<N; j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    			if(map[i][j] > maxHeight) maxHeight = map[i][j]; 
    		}
    	}
    	
    	int maxArea = 0; // 각 빗물 높이 별로 만들어지는 영역 최대 갯수 담는 변수
    	
    	// 높이 0부터 물에 안잠기는 안전 구역 탐색
    	for(int h=0; h<maxHeight+1; h++) {
    		checked = new boolean[N][N]; // 각 높이 별로 매번 새 배열 생성
    		int areaCnt =0;
    		
    		for(int i=0; i<N; i++) {
    			for(int j=0; j<N; j++) {
    				if(!checked[i][j] && map[i][j] > h) areaCnt+= dfs(i, j, h);
    			}
    		}
    		maxArea = Math.max(maxArea, areaCnt);
    	}
    	System.out.println(maxArea);
    }
    
    
    static int dfs(int r, int c, int h) {
    	
    	checked[r][c] = true; // 방문 표시
    	
    	for(int i=0; i<4; i++) {
    		int nr = r + dx[i];
    		int nc = c + dy[i];
    		
    		if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue; // 범위 벗어나거나
    		if(checked[nr][nc]) continue; // 이미 방문했다면
    	    if(map[nr][nc] > h) dfs(nr, nc, h); // 상하좌우 중 현재 빗물 높이보다 높은 안전구역있다면 계속 탐색
    	}
    	// 상하좌우 더 탐색할 곳이 없으면 1을 반환하고, 이 1이 연결된 하나의 안전구역 숫자
    	return 1;
    }
}