#include <stdio.h>
#include <stdlib.h>

struct node {
	int datum;
	struct node *next;
};

struct listqueue {
	struct node *head;
	struct node *tail;
};

struct listqueue *lq_create() {
	struct listqueue *new = malloc(sizeof(struct listqueue));
	new->head = NULL;
	new->tail = NULL;
	return new;
}

void lq_enqueue(struct listqueue *lq, int item) {
	struct node *n = malloc(sizeof(struct node));
	n->datum = item;
	n->next = NULL;
	if (lq->tail != NULL) {
		lq->tail->next = n;
	} else {
		lq->head = n;
	}
	lq->tail = n;
}

int lq_peek(struct listqueue *lq) {
	return lq->head->datum;
}

int lq_dequeue(struct listqueue *lq) {
	struct node *prev_head = lq->head;
	int im = lq->head->datum;
	lq->head = lq->head->next;
	free(prev_head);
	if (lq->head == NULL)
		lq->tail = NULL;
	return im;
}

void lq_destroy(struct listqueue *lq) {
	while (lq->head != NULL) {
		lq_dequeue(lq);
	}
	free(lq);
}

int main(void) {
	int x;

	struct listqueue *lq = lq_create();

	lq_enqueue(lq, 1);
	lq_enqueue(lq, 2);
	lq_enqueue(lq, 3);
	lq_enqueue(lq, 4);
	x = lq_dequeue(lq);
	printf("4 == %d\n", x);
	x = lq_dequeue(lq);
	printf("3 == %d\n", x);
	lq_enqueue(lq, 5);
	x = lq_dequeue(lq);
	printf("5 == %d\n", x);
	x = lq_peek(lq);
	printf("2 == %d\n", x);

	for (int i = 0; i < 51; i++) {
		lq_enqueue(lq, i);
	}
	printf("big countdown:");
	for (int i = 0; i < 51; i++) {
		x = lq_dequeue(lq);
		printf(" %d", x);
	}
	printf("\n");

	x = lq_dequeue(lq);
	printf("2 == %d\n", x);
	x = lq_dequeue(lq);
	printf("1 == %d\n", x);

	lq_destroy(lq);
	return 0;
}
