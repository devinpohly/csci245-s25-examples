#include "print_factors.h"
#include "pfh.h"

void print_factors_halves(int x) {
	print_factors(x / 100);
	print_factors(x % 100);
}
