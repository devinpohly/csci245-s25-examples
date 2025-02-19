#include <stdio.h>

struct point {
	double x;
	double y;
};

int main(void)
{
	struct point p;

	p.x = 3.0;
	p.y = -1.0;

	printf("(%g, %g)\n", p.x, p.y);

	struct point q;
	q.x = 10;
	q.y = 10;

	printf("(%g, %g)\n", q.x, q.y);

	p = q;
	printf("(%g, %g)\n", p.x, p.y);

	q.x = -8;
	printf("(%g, %g)\n", q.x, q.y);
	printf("(%g, %g)\n", p.x, p.y);


	return 0;
}
