#include <stdio.h>

int g = 20;

int main(void)
{
	int a = 10;
	int y = 10;
	double f = 3.14;
	int x = 10;

	printf("%d %d %g\n", g, x, f);
	printf("%lu\n%lu\n%lu\n", &g, &x, &f);

	int *p = &g;
	int **pp = &p;

	*p = 8;

	printf("p = %lu\n", p);
	printf("*p = %lu\n", *p);
	printf("g = %lu\n", g);

	return 0;
}
