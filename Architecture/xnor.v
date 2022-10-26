module xnor_mos(a, b, out);
  input a, b;
  output out;
  
  
  wire not_wire, notand_wire, ornot_wire, xoror_wire, out_and_wire;
  
  supply1 power;
  supply0 ground;
  
  my_not nota_switch(a, not_wire);
  my_not notb_switc(b, notand_wire);
  my_or ornot_switch(not_wire, notand_wire, ornot_wire);
  my_or or_switch(a, b, xoror_wire);
  my_and andor_out(xoror_wire, ornot_wire, out_and_wire);
  my_not not_out(out_and_wire, out);
  
 
endmodule
module my_not(a, out);
  input a;
  output out;
  
  supply1 power;
  supply0 ground;
  
  nmos n0(out, ground, a);
  pmos p0(out, power, a);
  
endmodule

module my_and(a, b, out);
  input a, b;
  output out;
  supply1 power;
  supply0 ground;
  
  wire w, out_w;
  
  pmos p0(out_w, power, a);
  pmos p1(out_w, power, b);
  nmos n1(w, ground, b);
  nmos n0(out_w, w, a);
  
  my_not not_switch(out_w, out);
  
endmodule

module my_or(a, b, out);
  input a, b;
  output out;
  supply1 power;
  supply0 ground;
  
  wire w, out_wire;
  
  pmos p0(w, power, a);
  pmos p1(out_wire, w, b);
  nmos n1(out_wire, ground, b);
  nmos n0(out_wire, ground, a);
  
  my_not not_switch(out_wire, out);
  
endmodule