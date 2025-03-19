#include <stdio.h>
#include <stdlib.h>

int main(void)
{
	int *arr = realloc(NULL, sizeof(int) * 10);
	for (int i = 0; i < 10; i++) {
		arr[i] = (i + 1) * 5;
	}

	arr = realloc(arr, 20 * sizeof(int));
	for (int i = 10; i < 20; i++) {
		arr[i] = i*i - 1;
	}

	for (int i = 0; i < 20; i++) {
		printf("%d ", arr[i]);
	}
	printf("\n");
	arr = realloc(arr, 0);
	arr = realloc(arr, 4 * sizeof(int));
	return 0;
}
