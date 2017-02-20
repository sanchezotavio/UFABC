#include <math.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <assert.h>
#include <limits.h>
#include <stdbool.h>

int greaterCompare(int ,int);

int greaterCompare(int sum,int greater)
{
    if(sum>greater)
    {
        return sum;
    }
    else{
        return greater;
    }
 }

int main(){

    int array[6][6];
    int sum=0;
    int greater=-99;

    for(int i = 0; i < 6;i++)
    {
        for(int j = 0; j < 6; j++)
        {
            scanf("%d",&array[i][j]);
        }
    }

    for( int i = 0; i < 4; i++)
    {
        for(int j = 0; j < 4; j++)
        {
            sum = (array[i][j]+ array[i][j+1] +array[i][j+2]+array[i+1][j+1]+array[i+2][j]+array[i+2][j+1]+array[i+2][j+2]);
            greater = greaterCompare(sum,greater);
        }
    }

    printf("%d",greater);

    return 0;

}