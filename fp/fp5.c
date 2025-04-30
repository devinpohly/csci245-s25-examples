#include <stdio.h>

int g = 3;

int foo(int x) {
	return x + 1;
}

int bar(int x) {
	return x * 3;
}

int baz(int x) {
	return -x;
}

int (*pickone(int i))(int) {
	//array of function pointers
	int (*fa[3])(int);

	fa[0] = foo;
	fa[1] = bar;
	fa[2] = baz;

	return fa[i];
}

int main(int argc, char **argv) {

	printf("%d\n", foo(3));
	for (int i = 0; i < 3; i++) {
		printf("%d\n", pickone(i)(3));
	}

	return 0;
}
