#include <math.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <assert.h>
#include <limits.h>
#include <stdbool.h>

int main()
{

    int n, k, y_i, x, i, j;

    scanf("%d %d", &n, &k);

    int y[1000001] = {0};

    for (int x_i = 0; x_i < n; x_i++)
    {
        scanf("%d", &x);
        y[x] = 1;
    }

    int count = 0;

    for (y_i = 0; y_i <= 1000000; y_i++)
    {
        if (y[y_i] == 1)
        {
            for (i = y_i + k; i >= y_i; i--)
            {
                if (y[i] == 1)
                {
                    for (j = i - k; j <= i + k; j++)
                    {
                        y[j] = 0;
                    }
                }
            }
            count++;
        }
    }

    printf("%d", count);

    return 0;
}
