#include <stdio.h>

// public static void main(String[] args)
int main(void) {
	char str[10];
	int n;
	printf("Hi, what's your name? ");
	scanf("%s", str);
	printf("Pick a number less than 10: ");
	scanf("%d", &n);

	int i;
	for (i = 0; i < n; i++) {
		// "Hello #" + i + ", " + str + "!"
		printf("Hello, %s!\n", str);
	}

	return 0;
}
