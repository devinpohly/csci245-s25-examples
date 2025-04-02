#include <stdio.h>
#include <stdlib.h>

struct arraystack {
	int *arr;
	int capacity;  // of the array
	int size;  // of the list
};

struct arraystack *as_create() {
	return calloc(sizeof(struct arraystack), 1);
}

void as_push(struct arraystack *as, int item) {
	if (as->size + 1 > as->capacity) {
		// grow!
		int newcap = (as->capacity + 1) * 2;
		as->arr = realloc(as->arr, newcap * sizeof(int));
		as->capacity = newcap;
	}

	as->arr[as->size] = item;
	as->size++;
}

int as_peek(struct arraystack *as) {
	return as->arr[as->size - 1];
}

int as_pop(struct arraystack *as) {
	as->size--;
	return as->arr[as->size];
}

void as_destroy(struct arraystack *as) {
	free(as->arr);
	free(as);
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

	for (int i = 0; i < 51; i++) {
		as_push(as, i);
	}
	printf("big countdown:");
	for (int i = 0; i < 51; i++) {
		x = as_pop(as);
		printf(" %d", x);
	}
	printf("\n");

	x = as_pop(as);
	printf("2 == %d\n", x);
	x = as_pop(as);
	printf("1 == %d\n", x);

	as_destroy(as);
	return 0;
}
