struct point {
	char name;
	double x;
	double y;
};

struct circle {
	struct point center;
	double radius;
};

void print_point(struct point p);
double circle_area(struct circle c);
double distance(struct point p1, struct point p2);
int contains(struct circle c, struct point p);
struct point reflect(struct point p);
