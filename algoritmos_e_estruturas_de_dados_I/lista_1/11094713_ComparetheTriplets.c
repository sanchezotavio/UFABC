#include <math.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <assert.h>
#include <limits.h>
#include <stdbool.h>

int main(){
    int n = 3;
    int a[n],b[n];
    int alice,bob = 0;
    
    for(int i =0; i<n;i++){
         scanf("%d",&a[i]);
    }
    
    for(int i =0; i<n;i++){
         scanf("%d",&b[i]);
    }
    
    for(int i = 0; i < n; i++){
        if(a[i] > b[i]){
            alice += 1;           
        } 
        else if(a[i] < b[i]){
            bob += 1;
        }
    }    
    
    printf("%d %d",alice,bob);
    
    return 0;
}
