#include <stdio.h>
#include <string.h>

union foo {
	int y;
	double f;
	char name[8];
	long z;
};

int main(void)
{
	union foo a;

	a.z = 4990000000000000999;
	a.f = 3.14;
	// strlen
	// strcpy(b, a)   b = a
	// strcat(b, a)   b += a
	strcpy(a.name, "Jenna");
	a.y = 10;


	printf("a.y = %d\n", a.y);
	printf("a.f = %f\n", a.f);
	printf("a.name = %s\n", a.name);
	printf("a.z = %ld\n", a.z);

	return 0;
}
