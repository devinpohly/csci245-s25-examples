#include <stdio.h>

int g = 3;

int foo(int x) {
	return x + 1;
}

int bar(int x) {
	return x * 3;
}

int main(int argc, char **argv) {
	int (*f)(int);

	f = foo;

	printf("%d\n", foo(3));
	printf("%d\n", f(3));

	f = bar;
	printf("%d\n", f(3));
	return 0;
}
