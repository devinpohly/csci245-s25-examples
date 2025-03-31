#include <stdio.h>
#include <stdlib.h>

struct node {
	int datum;
	struct node *next;
};

struct liststack {
	struct node *head;
};

struct liststack *ls_create() {
	struct liststack *new = malloc(sizeof(struct liststack));
	new->head = NULL;
	return new;
}

void ls_push(struct liststack *ls, int item) {
	struct node *n = malloc(sizeof(struct node));
	n->datum = item;
	n->next = ls->head;
	ls->head = n;
}

int ls_peek(struct liststack *ls) {
	return ls->head->datum;
}

int ls_pop(struct liststack *ls) {
	struct node *prev_head = ls->head;
	int im = ls->head->datum;
	ls->head = ls->head->next;
	free(prev_head);
	return im;
}

void ls_destroy(struct liststack *ls) {
	while (ls->head != NULL) {
		ls_pop(ls);
	}
	free(ls);
}

int main(void) {
	int x;

	struct liststack *ls = ls_create();

	ls_push(ls, 1);
	ls_push(ls, 2);
	ls_push(ls, 3);
	ls_push(ls, 4);
	x = ls_pop(ls);
	printf("4 == %d\n", x);
	x = ls_pop(ls);
	printf("3 == %d\n", x);
	ls_push(ls, 5);
	x = ls_pop(ls);
	printf("5 == %d\n", x);
	x = ls_peek(ls);
	printf("2 == %d\n", x);
	x = ls_pop(ls);
	printf("2 == %d\n", x);
	x = ls_pop(ls);
	printf("1 == %d\n", x);

	ls_destroy(ls);
	return 0;
}
