#include <stdio.h>

int main() {

	int n;
	scanf("%d", &n);

	int a1 = 1;
	int a2 = 1;
	int a3;

	if (n == 0) {
		a3 = 0;
	}
	else if (n == 1 || n == 2) {
		a3 = 1;
	}
	else {
		for (int i = 3; i <= n; i++) {

			a3 = a1 + a2;
			a1 = a2;
			a2 = a3;


		}
	}


	printf("%d", a3);

	return 0;

}

	