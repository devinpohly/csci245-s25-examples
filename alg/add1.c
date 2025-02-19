// Return the number that is one more than x
int add1(int x) {
	return x + 1;
}

int add1(int x) {
	return (2 * x + 2) / 2;
}

int add1(int x) {
	if (x % 2 == 0) {
		return (x / 2) * 2 + 1;
	} else {
		return (x / 2 + 1) * 2;
	}
}

int add(int x, int y) {
	return x + y;
}

int add(int x, int y) {
	return (x + 3) + (y - 3);
}

// PRECONDITION: y >= 0
int add(int x, int y) {
	while (y != 0) {
		y--;
		x++;
	}
	// x + y = sum of the original x and y
	// x = sum of the original x and y
	return x;
}
