#include <math.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <assert.h>
#include <limits.h>
#include <stdbool.h>

int main(){
    int n; 
    scanf("%d",&n);
    int sum_y = 0;
    int sum_x = 0;
    int x = n -1;
    int a[n][n];
    for(int a_i = 0; a_i < n; a_i++){
       for(int a_j = 0; a_j < n; a_j++){          
          scanf("%d",&a[a_i][a_j]);
       }
    }
    for(int a_i = 0; a_i < n; a_i++){       
      sum_y += a[a_i][a_i];   
      sum_x += a[a_i][x]; 
        x--;
    }
    int result = abs(sum_x - sum_y);
    printf("%d",result);
   
   
    return 0;
}