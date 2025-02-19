#include <stdio.h>

struct point {
	char name;
	double x;
	double y;
} o;

void print_point(struct point p)
{
	printf("%c = (%g, %g)\n", p.name, p.x, p.y);
	p.x = 0;
	p.y = 0;
}

struct point reflect(struct point p) {
	struct point r;
	r.x = p.y;
	r.y = p.x;
	return r;
}

int main(void)
{
	o.name = 'O';
	o.x = o.y = 0;
	print_point(o);

	struct point p;

	p.name = 'P';
	p.x = 3.0;
	p.y = -1.0;

	print_point(p);

	struct point q = reflect(p);
	q.name = 'Q';
	print_point(q);

	return 0;
}
