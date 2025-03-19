#include <stdio.h>
#include <stdlib.h>
#include <assert.h>

struct arraylist {
	int *arr;
	int capacity;  // of the array
	int size;  // of the list
};

struct arraylist *list_create(void) {
	return calloc(sizeof(struct arraylist), 1);
}

void list_destroy(struct arraylist *list) {
	free(list->arr);
	free(list);
}

void list_add(struct arraylist *list, int n) {
	if (list->size + 1 > list->capacity) {
		// grow!
		int newcap = (list->capacity + 1) * 2;
		list->arr = realloc(list->arr, newcap * sizeof(int));
	}

	list->arr[list->size] = n;
	list->size++;
}

// Precondition: 0 <= i < list->size
int list_get(struct arraylist *list, int i) {
	assert(i >= 0);
	assert(i < list->size);
	return list->arr[i];
}

int list_size(struct arraylist *list) {
	return list->size;
}

int main(void)
{
	struct arraylist *l = list_create();

	printf("size 0 = %d\n", list_size(l));
	list_add(l, 2);
	list_add(l, 3);
	list_add(l, 5);
	list_add(l, 7);
	list_add(l, 11);
	list_add(l, 2);
	list_add(l, 3);
	list_add(l, 5);
	list_add(l, 7);
	list_add(l, 11);
	list_add(l, 2);
	list_add(l, 3);
	list_add(l, 5);
	list_add(l, 7);
	list_add(l, 11);
	list_add(l, 2);
	list_add(l, 3);
	list_add(l, 5);
	list_add(l, 7);
	list_add(l, 11);
	list_add(l, 2);
	list_add(l, 3);
	list_add(l, 5);
	list_add(l, 7);
	list_add(l, 11);
	list_add(l, 2);
	list_add(l, 3);
	list_add(l, 5);
	list_add(l, 7);
	list_add(l, 11);
	list_add(l, 2);
	list_add(l, 3);
	list_add(l, 5);
	list_add(l, 7);
	list_add(l, 11);
	printf("size 5 = %d\n", list_size(l));
	printf("l[0] 2 = %d\n", list_get(l, 0));
	printf("l[29] 11 = %d\n", list_get(l, 29));

	list_destroy(l);
	return 0;
}
