#include <stdio.h>

struct node;

struct node {
	int datum;
	struct node next;
};

//      public class Node {
//              public int datum;
//       	public Node next;
//	}

struct list {
	struct node head;
};

int main(void)
{
	struct node a;
	struct node b;
	struct node c;

	a.datum = 8;
	b.datum = 10;
	c.datum = 200;

	a.next = b;
	b.next = c;

	struct list l;
	l.head = a;

	return 0;
}
