#include <stdio.h>

void swap(int *a, int *b) {
	int t = *a;
	*a = *b;
	*b = t;
}

int main(void)
{
	int x, y;

	scanf("%d %d", &x, &y);

	printf("Before: x, y = %d, %d\n", x, y);
	swap(&x, &y);
	printf("After: x, y = %d, %d\n", x, y);

	return 0;
}
