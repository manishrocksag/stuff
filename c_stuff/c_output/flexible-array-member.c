#include <stddef.h>
#include <stdio.h>
#include <stdlib.h>

int main(void) {
	typedef struct {
		int len;
		float array[ ];
	} DynArray_t;

	// Sizeof DynArray_t excludes the sizeof flexible array member

	DynArray_t *daPtr = (DynArray_t *)malloc(sizeof(DynArray_t) + 
		10 * sizeof(float));
	int i;
	
	printf("%d %d\n", sizeof(DynArray_t), offsetof(DynArray_t, array ));
	daPtr->len = 10;
	for (i = 0; i < daPtr->len; ++i)
		daPtr->array[i] = 1.0F / (i + 1);
	for (i = 0; i < daPtr->len; ++i)
		printf("%f\n", daPtr->array[i]);

	{
		DynArray_t da1;
		da1 = *daPtr;
		printf("%d %f\n", da1.len, da1.array[0]);
		{
			DynArray_t da1 = { 100 };                       // Okay.
			DynArray_t da2 = { 3, { 1.0F, 0.5F, 0.25F } };  // Error.
			printf("%f\n", daPtr->array[1]);
		}
	}

	return 0;
}
