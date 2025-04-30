main:

  MOVI 5 r1    
  PUSH r1      
  MOVI myst r4 
  JAL  r4      
  POP  r9      
               

  OUT  r1      
  HALT         

myst:
  PUSH rp      
  PUSH fp      
  MOV  sp fp   
  MOVI 1 r1    
  ADD  r1 sp   

  LDLO -3 r5   
  STLO 0 r5    

  MOVI then r6 
  JNZ  r5 r6   
  MOVI 1 r1    

  
  POP  r9      
               
  POP  fp      
  POP  rp      
  RET          

then:          
// (x- 1)
  MOVI 1 r3    
  SUB  r3 r5   


// myst(x - 1)
  PUSH r5      
  MOVI myst r4 
  JAL  r4      
  POP  r2      
               

  LDLO 0 r5    
  MUL  r5 r1   



  POP  r9      
               
  POP  fp      
  POP  rp      
  RET          
