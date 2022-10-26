module ternary_max(a1, a2, b1, b2, out0, out1);
  
  input a1, a2, b1, b2;
  output out0, out1;
  wire w0, w1, w2;
  
  and_switch my_and(w0, w1, w2);
  or_switch my_or00(a1, b1, w0);
  or_switch my_or01(a2, b2, w1);
  or_switch my_or10(a1, b1, out0);
  xor_switch my_xor(w1, w2, out1);
  
endmodule

module and_switch(a, b, out);
  
  input a, b;
  output out;
  wire w;
  
  supply0 ground;
  supply1 power;
  
  pmos n1(out, ground, a);
  pmos n2(out, ground, b);
  
  nmos p1(w, power, a);
  nmos p2(out, w, b);
  
endmodule

module or_switch(a, b, out);
  
  input a, b;
  output out;
  wire w;
  
  nor_switch my_nor(a, b, w);
  not_switch my_not(w, out);
  
endmodule

module not_switch(in, out);
  
  input in;
  output out;
  
  supply0 ground;
  supply1 power;
  
  pmos(out, power, in);
  nmos(out, ground, in);
  
endmodule

module nor_switch(a, b, out);
  
  input a, b;
  output out;
  wire w;
  
  supply0 ground;
  supply1 power;
  
  nmos n1(out, ground, a);
  nmos n2(out, ground, b);
  
  pmos p1(w, power, a);
  pmos p2(out, w, b);
  
endmodule

module xor_switch(a, b, out);
  
  input a, b;
  output out;
  wire w0, w1, w2, w3;
  
  supply0 ground;
  supply1 power;
  
  and_switch my_and(w0, w3, out);
  or_switch my_or1(a, b, w0);
  or_switch my_or2(w1, w2, w3);
  not_switch my_not1(a, w1);
  not_switch my_not2(b, w2);
  
endmodule

module ternary_consensus(a1, a2, b1, b2, out0, out1);
  
  input a1, a2, b1, b2;
  output out0, out1;
  wire w0, w1, w2;
  
  and_switch my_and(a1, b1, out0);
  xor_switch my_xor(a1, b1, w0);
  or_switch my_or1(w0, a2, w1);
  or_switch my_or2(w1, b2, out1);
  
endmodule
