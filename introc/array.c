#include <stdio.h>

int main(void)
{
	// Java:
	// int[] arr = new int[20];
	int arr[10];
	arr[0] = 10;
	arr[-11] = 9;
	arr[-3] = 5;
	printf("%d %d %d %d\n", arr[0], arr[1], arr[-11], arr[-3]);

	return 0;
}
