#include <stdio.h>
#include <stdlib.h>

int * new_array(int len) {
	int *arr = malloc(sizeof(int) * len);
	return arr;
}

int main(void)
{
	int i;

	int *a = new_array(10);
	for (i = 0; i < 10; i++) {
		a[i] = 100 - i;
	}
	int *b = a;
	for (i = 0; i < 6; i++) {
		b[i] = i * i;
	}

	printf("a[4] + b[3] = %d\n", a[4] + b[3]);
	free(a);
	free(b);
	return 0;
}
