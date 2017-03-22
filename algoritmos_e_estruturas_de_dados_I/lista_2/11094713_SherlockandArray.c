#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main()
{
      int x, t, s, R, k, n;
      int A[10000];
      scanf("%d", &t);
      int i = 0;

      while (i < t)
      {
            s = 0;
            x = 0;
            R = 0;
            k = 0;

            scanf("%d", &n);

            while (x < n)
            {
                  scanf("%d", &A[x]);
                  R = R + A[x];
                  x++;
            }

            x = 0;

            while (x < n)
            {
                  R = R - A[x];

                  if (R == s)
                  {
                        k++;
                  }

                  s = s + A[x];

                  x++;
            }

            if (k > 0)
            {
                  printf("YES \n");
            }
            else
            {
                  printf("NO \n");
            }

            i++;
      }
      return 0;
}