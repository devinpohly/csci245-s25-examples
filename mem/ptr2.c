#include <stdio.h>

int g = 23;

int main(void)
{
	int arr[10];
	arr[0] = 10;
	arr[1] = 15;
	arr[5] = 55;

	int *p = &arr[0];

	printf("p = %lu\n", p);
	printf("*p = %lu\n", *p);

	p++;

	printf("p = %lu\n", p);
	printf("*p = %lu\n", *p);
	*p = 99;

	printf("arr[1] = %lu\n", 1[arr]);
	printf("arr[5] = %lu\n", *(arr + 12));

	return 0;
}
