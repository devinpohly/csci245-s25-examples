#include <stdio.h>

void print_factors(int x) {
	int i;
	for (i = 1; i <= x; i++) {
		if (x % i == 0) {
			printf("%d\n", i);
		}
	}
}
