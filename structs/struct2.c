#include <stdio.h>

struct point {
	double x;
	double y;
};

void print_point(struct point p)
{
	printf("(%g, %g)\n", p.x, p.y);
	p.x = 0;
	p.y = 0;
}

int main(void)
{
	struct point p;

	p.x = 3.0;
	p.y = -1.0;

	print_point(p);

	struct point q;
	q.x = 10;
	q.y = 10;

	print_point(q);

	p = q;
	print_point(p);

	q.x = -8;
	print_point(q);
	print_point(p);


	return 0;
}
