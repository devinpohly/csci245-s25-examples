#include <stdio.h>

struct node {
	int datum[9999];
	struct node *next;
};

void print_list(struct node *head) {
	for (struct node *c = &first; c != NULL; c = c->next) {
		printf("%d\n", c->datum);
	}
}

int main(void) {
	struct node first, second, third;

	first.datum = 2;
	second.datum = 3;
	third.datum = 5;

	first.next = &second;
	second.next = &third;
	third.next = NULL;

	print_list(&first);

	return 0;
}
