
#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

static long long count = 0;

void merge(int arr[], int p, int q, int r)
{
    long long leftlength = q - p + 1;
    long long left[leftlength];

    long long rightlength = r - q;
    long long right[rightlength];

    for (int i = 0; i < leftlength; i++)
    {
        left[i] = arr[p + i];
    }
    for (int i = 0; i < rightlength; i++)
    {
        right[i] = arr[q + i + 1];
    }

    long long i = 0, j = 0;
    for (int k = p; k <= r; k++)
    {
        if (i < leftlength && j < rightlength)
        {
            if (left[i] <= right[j])
            {
                arr[k] = left[i];
                i++;
            }
            else
            {
                arr[k] = right[j];
                count += leftlength - i;
                j++;
            }
        }
        else
        {
            if (i < leftlength)
            {
                arr[k] = left[i];
                i++;
            }
            else if (j < rightlength)
            {
                arr[k] = right[j];
                j++;
            }
        }
    }
}

static void mergesort(int arr[], int p, int r)
{
    long long q = (p + r) / 2;
    if (p < r)
    {
        mergesort(arr, p, q);
        mergesort(arr, q + 1, r);
        merge(arr, p, q, r);
    }
}

static long long insertSort(int ar[], int n)
{
    count = 0;
    mergesort(ar, 0, n - 1);
    return count;
}

int main()
{
    long long i, t, n, e;
    scanf("%lld", &t);
    for (i = 0; i < t; i++)
    {
        scanf("%lld", &n);
        int v[n];
        for (e = 0; e < n; e++)
        {
            scanf("%lld", &v[e]);
        }

        printf("%lld\n", insertSort(v, n));
    }
}
