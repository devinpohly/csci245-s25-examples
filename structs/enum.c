#include <stdio.h>

enum suit {
	CLUBS,
	SPADES,
	DIAMONDS,
	HEARTS,
};

struct card {
	int value;
	enum suit suit;
	// 0 = clubs
	// 1 = spades
	// 2 = diamonds
	// 3 = hearts

};

int main(void)
{
	struct card c;
	c.value = 3;
	c.suit = 9;

	switch (c.suit) {
		case CLUBS:
			printf("%d of clubs\n", c.value);
			break;
		case HEARTS:
			printf("%d of hearts\n", c.value);
			break;
		case DIAMONDS:
			printf("%d of diamonds\n", c.value);
			break;
		case SPADES:
			printf("%d of spades\n", c.value);
			break;
		default:
			printf("what kind of deck is this??\n");
			break;
	}

	return 0;
}
