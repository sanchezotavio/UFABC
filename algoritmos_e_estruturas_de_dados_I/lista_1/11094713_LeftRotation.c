#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main()
{
  
    int v, left;  
    
    scanf("%d", &v);
    
    scanf("%d", &left);
    
    int array[v];   

    for(int i = 0; i < v; i++){
       scanf("%d",&array[((v - left) + i) % v]);
    }
    
     for(int i = 0; i < v; i++){
         printf("%d ",array[i]);
     }
    
   return 0;
}