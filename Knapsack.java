import java.util.*;

public class Knapsack{
    public static int knapsack(int[] weight, int[] profit , int capacity){
        int n = weight.length;
        int[][]dp = new int[n+1][capacity+1];

        //build dp table
        for(int i = 1; i <=n ; i++){
            for(int w =0; w <= capacity ; w++){
                //if curr item fits
                if(weight[i-1]<= w){
                    dp[i][w] = Math.max(profit[i-1]+ dp[i-1] [w-weight[i-1]] , dp[i-1][w]);
                }
                else{
                    dp[i][w] = dp[i-1][w];
                }
                }
            }
        return dp[n][capacity];
        
        }
    public static void main(String[] args){
        int[] weight = {5,2,4,3};
        int[] profit = {20,30,15,10};

        int capacity = 7;
        System.out.println("Max Profit " + knapsack(weight , profit , capacity));
        
    }
    
    }

