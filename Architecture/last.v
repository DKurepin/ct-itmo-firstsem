module mux_4_1(a, b, d0, d1, d2, d3, out);
  input a, b, d0, d1, d2, d3;
  output out;

  reg out;

  always @ (a or b or d0 or d1 or d2 or d3) begin
    case ({a, b})
      2'b00: out = d0;
      2'b01: out = d1;
      2'b10: out = d2;
      2'b11: out = d3;
    endcase
  end
endmodule

module nand_mux(a, b, out);
  input a, b;
  output out;
  
  supply1 power;
  supply0 ground;
  
  mux_4_1 my_mux(a,b,power,power,power,ground,out);

endmodule

module nor_mux(a, b, out);
  input a, b;
  output out;
  
  supply1 power;
  supply0 ground;
  
  mux_4_1 my_mux(a,b,power,ground,ground,ground,out);
