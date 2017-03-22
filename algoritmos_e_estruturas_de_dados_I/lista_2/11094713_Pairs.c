#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>
#include <assert.h>

int main()
{
    int _a_size, _k, i, j;

    int res = 0;
    
    scanf("%d %d", &_a_size, &_k);

    int _a[_a_size];

    for (i = 0; i < _a_size; ++i)
    {
        scanf("%d", &_a[i]);
    }

    i = 0;

    while (i < _a_size)
    {
        j = i;
        while (j < _a_size)
        {
            if (_a[j] - _a[i] == _k || _a[i] - _a[j] == _k)
            {
                res++;
            }
            ++j;
        }
        i++;
    }

    printf("%d", res);

    return 0;
}
