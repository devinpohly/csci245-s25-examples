#include <stdio.h>

int g = 3;

int foo(int x) {
	return x + 1;
}

int main(int argc, char **argv) {
	int (*f)(int);

	f = foo;

	printf("printf: %lu\n", printf);
	printf("main: %lu\n", main);
	printf(" foo: %lu\n", foo);
	printf("&foo: %lu\n", &foo);
	printf(" f: %lu\n", f);
	printf("&f: %lu\n", &f);
	printf("size of foo: %lu\n", sizeof(foo));

	int x = 3;
	printf("local: %lu\n", &x);
	printf("global: %lu\n", &g);
	return 0;
}
