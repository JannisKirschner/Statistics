//used for a challenge at www.hackerrank.com
//Licence: Jannis Kirschner 2017

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        double[] arr = new double[n];
        for(int i = 0; i<n;i++){
            arr[i] = scan.nextInt();
        }
        
        System.out.println(calcMean(n, arr));
        System.out.println(calcMedian(n, arr));
        System.out.println(calcMode(n, arr));
    }
    
    
                           
    public static double calcMean(int n, double[] arr){
        double tmp = 0;
        for(int i = 0; i<n;i++){
            tmp = tmp + arr[i];
        }
        return tmp / n;
    }
                           
    public static double calcMedian(int n, double[] arr){
        Arrays.sort(arr);
        if(n%2==1){
            return arr[n / 2];
        }
        else{
            return (arr[n/2-1]+arr[n/2])/2;
        }
    }
    
    public static int calcMode(int n, double[] arr){
        final int[] intArr = new int[n];
        for(int i=0; i<n; ++i){
            intArr[i] = (int) arr[i];
        }         
        HashMap<Integer,Integer> freqs = new HashMap<Integer,Integer>();
        for (int val : intArr) {
            Integer freq = freqs.get(val);
            freqs.put(val, (freq == null ? 1 : freq+1));
        }
        int mode = 0, maxFreq = 0;
        for (Map.Entry<Integer,Integer> entry : freqs.entrySet()) {
            int freq = entry.getValue();
            if (freq > maxFreq) {
                maxFreq = freq;
                mode = entry.getKey();
            }
            if (freq == maxFreq){
                return intArr[0];
            }
        }
        return mode;
    }
    
    
}
