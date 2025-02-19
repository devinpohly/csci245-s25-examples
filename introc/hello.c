#include <stdio.h>

// public static void main(String[] args)
int main(void) {
	// Declaration
	int i;

	// Declare and initialize
	int y = 1;

	// Assignment
	y = 4

	char str[10];
	str[0] = 'T';
	str[1] = 'r';
	str[2] = 'e';
	str[3] = '\0';
	// str[3] = 0;

	for (i = 0; i < 7; i++) {
		// "Hello #" + i + ", " + str + "!"
		printf("Hello #%d, %s!\n", i, str);
	}

	str[0] = 'J';
	str[1] = 'o';
	//str[2] = '\0';
	for (i = 0; i < 5; i++) {
		// "Hello #" + i + ", " + str + "!"
		printf("Hello #%d, %s!\n", i, str);
	}

	return 0;
}
