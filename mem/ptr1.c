#include <stdio.h>

int g = 23;

int main(void)
{
	int a = 10;
	int y = 20;
	double f = 3.14;
	int x = 30;

	int *p = &a;
	int **q = &p;

	int *r = *q;

	printf("p = %lu\n", p);
	printf("*p = %lu\n", *p);

	p -= 2;

	printf("p = %lu\n", p);
	printf("*p = %lu\n", *p);
	*p = 99;

	printf("f = %g\n", f);

	return 0;
}
