#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

#define _size 100001

int main()
{
    int x[_size];
    int i, A, B, temp;

    for (i = 1; i < _size - 1; i++)
    {
        x[i] = 0;
    }

    scanf("%d", &A);

    for (i = 0; i < A; i++)
    {
        scanf("%d", &temp);
        x[temp]++;
    }

    scanf("%d", &B);

    for (i = 0; i < B; i++)
    {
        scanf("%d", &temp);
        x[temp]--;
    }

    for (i = 1; i < _size - 1; i++)
    {
        if (x[i] < 0)
            printf("%d ", i);
    }

    return 0;
}