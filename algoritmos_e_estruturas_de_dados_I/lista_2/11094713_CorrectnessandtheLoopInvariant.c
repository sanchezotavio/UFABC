#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>
#include <assert.h>

void insertionSort(int N, int *arr)
{
    int i = 1;
    int value, j;
    while (i < N)
    {
        value = arr[i];
        j = i - 1;
        while (j >= 0 && value < arr[j])
        {
            arr[j + 1] = arr[j];
            j = j - 1;
        }
        arr[j + 1] = value;
        i++;
    }

    j = 0;

    while (j < N)
    {
        printf("%d ", arr[j]);
        j++;
    }
}

int main(void)
{
    int N;
    scanf("%d", &N);
    int _arr[N], _arr_i;
    for (_arr_i = 0; _arr_i < N; _arr_i++)
    {
        scanf("%d", &_arr[_arr_i]);
    }

    insertionSort(N, _arr);

    return 0;
}