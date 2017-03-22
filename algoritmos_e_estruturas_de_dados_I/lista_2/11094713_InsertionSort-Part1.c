#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>
#include <assert.h>

void insertionSort(int size, int *a)
{
    int i, x, y, j;
    for (i = size - 1; i < size; i++)
    {
        x = a[i];
        y = i;
        while (y > 0 && a[y - 1] > x)
        {
            a[y] = a[y - 1];
            y = y - 1;
            for (j = 0; j < size; j++)
            {
                printf("%d ", a[j]);
            }
            printf("\n");
        }
        a[y] = x;
        for (j = 0; j < size; j++)
        {
            printf("%d ", a[j]);
        }
    }
}

int main(void)
{
    int _size, _a_i;

    scanf("%d", &_size);

    int _a[_size];

    for (_a_i = 0; _a_i < _size; _a_i++)
    {
        scanf("%d", &_a[_a_i]);
    }

    insertionSort(_size, _a);

    return 0;
}