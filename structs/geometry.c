#include <stdio.h>
#include <math.h>
#include "geometry.h"

void print_point(struct point p)
{
	printf("%c = (%g, %g)\n", p.name, p.x, p.y);
	p.x = 0;
	p.y = 0;
}

double circle_area(struct circle c) {
	return 3.14159 * c.radius * c.radius;
}

double distance(struct point p1, struct point p2) {
	double dx = p1.x - p2.x;
	double dy = p1.y - p2.y;
	return sqrt(dx * dx + dy + dy);
}

int contains(struct circle c, struct point p) {
	double dist = distance(c.center, p);
	return dist <= c.radius;
}

struct point reflect(struct point p) {
	struct point r;
	r.x = p.y;
	r.y = p.x;
	return r;
}
