import java.util.*;
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        Arrays.fill(answer,"");
        String[] a1=new String[n];
        String[] a2=new String[n];
        
        for(int i=0;i<n;i++){
            a1[i]=Integer.toBinaryString(arr1[i]);
            a2[i]=Integer.toBinaryString(arr2[i]);
            if(a1[i].length()<n) {
                while(a1[i].length()<n) a1[i]="0"+a1[i];
            }
            if(a2[i].length()<n) {
                while(a2[i].length()<n) a2[i]="0"+a2[i];
            } 
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(a1[i].charAt(j)=='0'&&a2[i].charAt(j)=='0') {
                    answer[i]+=" ";
                }
                else {answer[i]+="#";}
            }
        }
        
        
        return answer;
    }
}