#include <stdio.h>
#include <stdlib.h>

struct arraystack {
	struct node *head;
};

struct arraystack *as_create() {
}

void as_push(struct arraystack *as, int item) {
}

int as_peek(struct arraystack *as) {
}

int as_pop(struct arraystack *as) {
}

void as_destroy(struct arraystack *as) {
}

int main(void) {
	int x;

	struct arraystack *as = as_create();

	as_push(as, 1);
	as_push(as, 2);
	as_push(as, 3);
	as_push(as, 4);
	x = as_pop(as);
	printf("4 == %d\n", x);
	x = as_pop(as);
	printf("3 == %d\n", x);
	as_push(as, 5);
	x = as_pop(as);
	printf("5 == %d\n", x);
	x = as_peek(as);
	printf("2 == %d\n", x);
	x = as_pop(as);
	printf("2 == %d\n", x);
	x = as_pop(as);
	printf("1 == %d\n", x);

	as_destroy(as);
	return 0;
}
