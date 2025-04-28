// register 1 gets the value 1
OUT r0
MOVI 1 r1

	// prints r1
topofloop:
	OUT  r1

	// r1++
	MOVI 1 r2
	ADD  r2 r1

	// r3 = r1 - 11
	MOV  r1 r3
	MOVI 11 r2
	SUB  r2 r3

	// r3 = 11 - r1
	//MOVI 11 r3
	//SUB r1 r3

	MOVI topofloop r2
	// if r3 is not zero, jump to address 3 (the OUT instruction)
	JNZ  r3 r2

HALT
