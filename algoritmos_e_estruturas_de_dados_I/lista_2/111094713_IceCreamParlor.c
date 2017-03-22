#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main()
{
    int trips, i;
    scanf("%d", &trips);

    for (i = 0; i < trips; i++)
    {
        int m, i, j;

        scanf("%d %d", &m, &i);

        int p[i];

        for (j = 0; j < i; j++)
        {
            scanf("%d", &p[j]);
        }

        int k = 0;
        int count = 0;
        while (k < i && !count)
        {
            for (j = k + 1; j < i; j++)
            {
                if (p[k] + p[j] == m)
                {
                    printf("%d %d", k + 1, j + 1);
                    count = 1;
                };
            }
            k++;
        }
        printf("\n");
    }
    return 0;
}