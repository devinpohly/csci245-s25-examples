     MOVI arr r1        // r1 is arr
     MOVI 2 r2          // r2 = 2  // r2 is i

first:
     MOV r1 r3
     ADD r2 r3          // r3 = arr + i
     MOVI 1 r4          // r4 = 1
     ST r3 r4           //  *(arr + i) = 1 // arr[i] = 1

     MOVI 1 r3          //  r3 = 1
     ADD r3 r2          //  i++                         // body

     MOVI 100 r3        // r3 = 100                     // of
     SUB r2 r3          // r3 = 100 - i                 // first
     MOVI first r4      //  r4 = first                  // loop
     JNZ r3 r4          // if i != 100 then go to first




     MOVI 2 r2          // i = 2 (initialization of second loop)
second:
// U {{{
     MOV r1 r3
     ADD r2 r3          //   r3 = arr + i   // beginning of body of second loop
     LD r3 r3           //  r3 = arr[i]

     MOVI 1 r4          // 
     SUB r4 r3          //  r3 = arr[i] - 1 // r3 = ! arr[i]
     MOVI bail r4       // if !arr[i] go to bail
     JNZ r3 r4          // (if arr[i] is not prime, skip inner loop)
     // U2 {{{

     MOVI 2 r3          // r3 = 2
     MUL r2 r3          // j = 2 * i  // r3 is j (initialization of inner loop)

	//MOVI innertest r4
	//JMP r4

inner:
     MOVI 0 r4          //  r4 = 0             // body of
     MOV r1 r5
     ADD r3 r5          //  r5 = arr + j         // inner loop
     ST r5 r4           // arr[j] = 0 

     ADD r2 r3          // j = i + j  (increment of inner loop)       

innertest:
     MOV r3 r4
     MOVI 100 r5        //  r4 = 100          // guard of
     IDIV r5 r4         // r4 = j / 100       // inner loop 
     MOVI bail r5       // r5 = bail
     JNZ r4 r5          //  if j >= 100 jump to bail  // bail out of inner loop 

     MOVI inner r5      // r5 = inner
     JMP r5             // always jump to inner (otherwise, repeat inner loop body)

// }}}
bail:                   // second loop, after inner loop
// }}}
     MOVI 1 r3          // 
     ADD r3 r2          // i++ // increment of second loop
     MOVI 100 r3        //  r3 = 100
     SUB r2 r3          // r3 = 100 - i
     MOVI second r4     //   
     JNZ r3 r4          // if i != 100 go to second (repeat body of second loop)  




     MOVI 2 r2          // i = 2  // initialization of third loop
third:
     MOV r1 r3
     ADD r2 r3          // r3 = arr + i
     LD r3 r3           // r3 = arr[i]

     MOVI 1 r4          // r4 = 1
     SUB r4 r3          // r3 = arr[i] - 1

     MOVI skipnum r4    //   
     JNZ r3 r4          // if !arr[i] skip next line  (if arr[i], do the next line)

     OUT r2             // print i

skipnum:

     MOVI 1 r3          // 
     ADD r3 r2          // i++

     MOVI 100 r3        //
     SUB r2 r3          // r3 = 100 - i
     MOVI third r4      //  
     JNZ r3 r4          // if i != 100, go back to body of third loop 

     HALT               // done!

arr:
     .DATA 101          // reserve 101 words for arr
