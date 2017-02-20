#include <math.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <assert.h>
#include <limits.h>
#include <stdbool.h>

int tree(int cycle){
    int h = 1;
    for (int a0 = 0; a0 < cycle; a0++)
        {
            if(a0 % 2 == 0)
            {
                h *= 2;
            }
            else
            {
                h ++;
            }
        }
    
    return h;
}

int main(){
    int t; 
    scanf("%d",&t);
    for(int a0 = 0; a0 < t; a0++){
       int cycle;
       scanf("%d",&cycle);
       printf("%d \n",tree(cycle));
    }
    return 0;
}
