#include <stdio.h>

int g = 3;

void selectionSort(int array[], int n, int (*compare)(int, int))
{
	int i, j;
	for (i = 0; i < n; i++)     
	{
		int min = array[i];
		int minPos = i;
		for (j = i + 1; j < n; j++) 
		{
			if (compare(min, array[j]) > 0) 
			{
				min = array[j];
				minPos = j;
			}
		}
		array[minPos] = array[i];
		array[i] = min;
	}
}

int ascending(int a, int b) {
	if (a < b)
		return -1;
	if (a == b)
		return 0;
	return 1;
}

int descending(int a, int b) {
	return -ascending(a, b);
}

int wacky(int a, int b) {
	if (a == 7)
		return -1;
	else if (b == 7)
		return 1;
	else return ascending(a, b);
}

int main(int argc, char **argv) {

	int arr[] = {
		6, 3, 18, 7, 19, 2, 16, 12, 14, 15, 17, 11, 20, 13, 21, 1, 9, 10, 8, 4, 5,
	};

	for (int i = 0; i < 21; i++) {
		printf("%d ", arr[i]);
	}
	printf("\n");

	selectionSort(arr, 21, wacky);

	for (int i = 0; i < 21; i++) {
		printf("%d ", arr[i]);
	}
	printf("\n");

	return 0;
}
