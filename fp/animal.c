#include <string.h>
#include <stdio.h>

struct animal {
	char name[100];
	void (*noise)(struct animal *);
};

struct dog {
	struct animal super;
	int excitement_level;
};

void animal_name(struct animal *a) {
	printf("%s\n", a->name);
}

void dog_noise(struct animal *a) {
	struct dog *d = (struct dog *) a;
	for (int i = 0; i < d->excitement_level; i++) {
		printf("woof I am %s\n", d->super.name);
	}
}

void cat_noise(struct animal *a) {
	printf("meow I am %s\n", a->name);
}

int main(int argc, char **argv) {
	struct dog fido;
	strcpy(fido.super.name, "Fido");
	fido.super.noise = dog_noise;
	fido.excitement_level = 5;

	struct animal fluffy;
	strcpy(fluffy.name, "Fluffy");
	fluffy.noise = cat_noise;

	struct animal *arr[] = {&fido.super, &fluffy};

	for (int i = 0; i < 2; i++) {
		struct animal *a = arr[i];
		animal_name(a);
		a->noise(a);
	}

	return 0;
}
