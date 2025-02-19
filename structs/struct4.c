#include <stdio.h>

struct {
	char name;
	double x;
	double y;
} o;

int main(void)
{
	o.name = 'O';
	o.x = o.y = 0;
	printf("%c = (%g, %g)\n", o.name, o.x, o.y);

	return 0;
}
