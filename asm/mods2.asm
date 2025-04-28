// for (i = 0; i != 10; i++) {
//     print(i % 3);
// }

	MOVI 17 r5
	MOVI 6 r3
	MOVI printmod r7
	JAL r7

	// we'll just leave this here
	MOVI 3 r3

	// let's use r5 for i
	MOVI 0 r5

again:

	MOVI mod r7
	JAL r7


	OUT r1

	// i++
	MOVI 1 r2
	ADD r2 r5

	MOV r5 r1
	MOVI 10 r4
	SUB r4 r1

	MOVI again r7
	JNZ r1 r7

	HALT


// CALLING CONVENTION:
//
// find r5 % r3
// rp holds the address to jump back to
// r5 is the first parameter
// r3 is the second parameter (which better not be 0)
// clobbers r2 and r1
// r1 is the return value
mod:
	PUSH rp
	MOV r5 r2

	IDIV r3 r2
	MUL r3 r2
	MOV r5 r1
	SUB r2 r1

	POP rp
	RET


printmod:
	PUSH rp

	MOVI mod r7
	JAL r7

	OUT r1

	POP rp
	RET
