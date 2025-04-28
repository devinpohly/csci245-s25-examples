main:

  MOVI 9 r1    // r1 = 5
  PUSH r1      // write parameter 
  MOVI myst r4 // r4 = 18 (beginning of a function)
  JAL  r4      // function call !!!!!!! mys(5)
  POP  r9      // clean up stack (value is unused)
               //   (alternatively, subtract 1 from sp)

  MOV  r1 r5   // read return value to r5 ;  r5 = mys(5)
  OUT  r5      // print result
  HALT         // all done, go home

myst:
  PUSH rp      // save RP
  PUSH fp      // save old FP
  MOV  sp fp   // move FP to where SP is
  MOVI 1 r1    // make space for 1 local
  ADD  r1 sp   //   on the stack  (FP + 0)

  LDLO -3 r5   // read formal parameter (r5 is x)
  STLO 0 r5    // and save it as a local variable

  MOVI then r6 // r6 = address of label "then"
  JNZ  r5 r6   // if x != 0 then jump to line 41
  MOVI 1 r1    // "else" branch: write 1 as return value

  // epilogue
  POP  r9      // remove space for 1 local
               //  from the stack
  POP  fp      // restore saved FP
  POP  rp      // restore saved RP
  RET          // jump back to RP

then:          // "then" branch of the conditional
  MOVI 1 r3    // r3 = 1
  SUB  r3 r5   // r5 = x - 1


	// myst(x - 1)
  PUSH r5      // write parameter
  MOVI myst r4 // r4 = 18 (beginning of a function)
  JAL  r4      // recursive call to mys ;  mys(x-1)
  POP  r2      // clean up stack (unused)
               //   (again, could also subtract 1 from sp)

  MOV  r1 r7   // r7 = mys(x-1)  (the return value)
  LDLO 0 r5    // get local var x in r5
  MUL  r7 r5   // r5 = r5 * r7 = x * mys(x-1)
  MOV  r5 r1   // write r5 as return value


// epilogue
  POP  r9      // remove space for 1 local
               //   from the stack
  POP  fp      // restore saved FP
  POP  rp      // restore saved RP
  RET          // return
