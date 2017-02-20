#include <math.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <assert.h>
#include <limits.h>
#include <stdbool.h>

int main(){
    int n, m; 
    scanf("%d",&n);
    int negative, zero = 0;
    
    int arr[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
       scanf("%d",&arr[arr_i]);              
    }
    
    for(int arr_i = 0; arr_i < n; arr_i++){
    
        if(0 == arr[arr_i]){
            zero ++;
        }
        
        
         if(0 > arr[arr_i]){
           negative ++;
        }
    }
    
    int positive = n - (negative + zero);
        
    printf("%f \n",((double)positive)/((double)n));
    
      printf("%f \n",((double)negative)/((double)n));
   
    printf("%f ",((double)zero)/((double)n));
   
    return 0;
}
