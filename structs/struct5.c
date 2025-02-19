#include <stdio.h>
#include "geometry.h"

int main(void)
{
	struct point p;

	p.name = 'P';
	p.x = 3.0;
	p.y = -1.0;

	print_point(p);

	struct circle c;
	c.center = p;
	c.radius = 2;

	struct point q;
	q.name = 'Q';
	q.x = -1.5;
	q.y = -1.5;

	if (contains(c, q)) {
		printf("inside\n");
	}
	else {
		printf("outside\n");
	}

	return 0;
}
