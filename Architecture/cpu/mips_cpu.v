`include "alu.v"
`include "control_unit.v"
`include "util.v"


module mips_cpu(clk, instruction_memory_a, instruction_memory_rd, data_memory_a, data_memory_rd, data_memory_we, data_memory_wd,
                register_a1, register_a2, register_a3, register_we3, register_wd3, register_rd1, register_rd2);
  input clk;
  output data_memory_we;
  output [31:0] instruction_memory_a, data_memory_a, data_memory_wd;
  inout [31:0] instruction_memory_rd, data_memory_rd;
  output register_we3; 
  output [4:0] register_a1, register_a2, register_a3;
  output [31:0] register_wd3;
  inout [31:0] register_rd1, register_rd2;
	
  output reg [31:0] pc;
  output wire PCsrc;
  output wire [31:0] pcExt4, entry, res;
  output memtoreg, memwrite, branch, alusrc, regdst, regwrite, zero;
  inout [2:0] alucontrol;
  wire [31:0] sign_lmm, srcb, toPC, aluresult, pcStroke;
  
  initial begin
    pc = 0;
  end
  
  assign instruction_memory_a = pc;
  
   control_unit my_ctrlunit(instruction_memory_rd [31:26], instruction_memory_rd [5:0], memtoreg, memwrite, branch, alusrc, regdst, regwrite, alucontrol);
  
  adder final_adder(pc, 32'b00000000000000000000000000000100, pcExt4);
  
  
  assign register_a1 = instruction_memory_rd [25:21];
  assign register_a2 = instruction_memory_rd [20:16];
  assign register_we3 = regwrite;
  
  
  mux2_5 my_mux2_5(register_a2, instruction_memory_rd [15:11], regdst, register_a3);
  
  sign_extend sgnext(instruction_memory_rd [15:0], sign_lmm);
 
  mux2_32 my_mux2_32(register_rd2, sign_lmm, alusrc, srcb);
  
  assign toPC = sign_lmm;
  
  alu my_alu(register_rd1, srcb, alucontrol , aluresult, zero);
  
  assign PCsrc = zero & branch;
  assign data_memory_we = memwrite;
  assign data_memory_a = aluresult;
  assign data_memory_wd = register_rd2;
  
  mux2_32 my_mux32_2(aluresult, data_memory_rd, memtoreg, res);
  
  assign register_wd3 = res;                                   
                                   
  adder addi(toPC, pcExt4, entry);
                                      
  mux2_32 mumu(pcExt4, entry, PCsrc, pcStroke);
                                      
  always @(posedge clk) begin
     pc = pcStroke;
  end                                  
                                      
endmodule