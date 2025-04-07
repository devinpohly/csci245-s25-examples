#include <stdio.h>
#include <assert.h>
#include <stdlib.h>

struct arrayqueue {
	int *arr;
	int capacity;  // of the array
	int head;
	int size;  // of the list
};

struct arrayqueue *aq_create() {
	struct arrayqueue *aq = calloc(sizeof(struct arrayqueue), 1);
	aq->arr = calloc(sizeof(int), 8);
	aq->capacity = 8;
	return aq;
}

void aq_enqueue(struct arrayqueue *aq, int item) {
	/* if (aq->size + 1 > aq->capacity) { */
	/* 	// grow! */
	/* 	int newcap = (aq->capacity + 1) * 2; */
	/* 	aq->arr = realloc(aq->arr, newcap * sizeof(int)); */
	/* 	aq->capacity = newcap; */
	/* } */

	assert(aq->size < aq->capacity);
	aq->arr[(aq->head + aq->size) % aq->capacity] = item;
	aq->size++;
}

int aq_peek(struct arrayqueue *aq) {
	return aq->arr[aq->head];
}

int aq_dequeue(struct arrayqueue *aq) {
	int ret = aq->arr[aq->head];
	aq->head = (aq->head + 1) % aq->capacity;
	aq->size--;
	return ret;
}

void aq_destroy(struct arrayqueue *aq) {
	free(aq->arr);
	free(aq);
}

int main(void) {
	int x;

	struct arrayqueue *aq = aq_create();

	aq_enqueue(aq, 1);
	aq_enqueue(aq, 2);
	aq_enqueue(aq, 3);
	aq_enqueue(aq, 4);
	x = aq_dequeue(aq);
	printf("4 == %d\n", x);
	x = aq_dequeue(aq);
	printf("3 == %d\n", x);
	aq_enqueue(aq, 5);
	x = aq_dequeue(aq);
	printf("5 == %d\n", x);
	x = aq_peek(aq);
	printf("2 == %d\n", x);

	/* for (int i = 0; i < 51; i++) { */
	/* 	aq_enqueue(aq, i); */
	/* } */
	/* printf("big countdown:"); */
	/* for (int i = 0; i < 51; i++) { */
	/* 	x = aq_dequeue(aq); */
	/* 	printf(" %d", x); */
	/* } */
	/* printf("\n"); */

	x = aq_dequeue(aq);
	printf("2 == %d\n", x);
	x = aq_dequeue(aq);
	printf("1 == %d\n", x);

	aq_destroy(aq);
	return 0;
}
