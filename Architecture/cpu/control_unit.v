module control_unit(opcode, funct, memtoreg, memwrite, branch, alusrc, regdst, regwrite, alucontrol);
  input [5:0] opcode, funct;
  output memtoreg, memwrite, branch, alusrc, regdst, regwrite;
  output [2:0] alucontrol;
  reg memtoreg, memwrite, branch, alusrc, regdst, regwrite;
  reg [2:0] AC;
  reg [1:0] aluOp;
  assign alucontrol = AC;
 
  parameter RType = 6'b000000;
  parameter lw = 6'b100011;
  parameter sw = 6'b101011;
  parameter beq = 6'b000100;
  parameter addi = 6'b001000;
  
  always@(*)begin
    case(opcode)
      RType:begin
        memtoreg = 0;
        memwrite = 0;
        branch = 0;
        alusrc = 0;
        regdst = 1;
        regwrite = 1;
        aluOp = 2'b10;
      end
      lw:begin
        memtoreg = 1;
        memwrite = 0;
        branch = 0;
        alusrc = 1;
        regdst = 0;
        regwrite = 1;
        aluOp = 2'b00;
      end
      sw:begin
        memwrite = 1;
        branch = 0;
        alusrc = 1;
        regwrite = 0;
        aluOp = 2'b00;
      end
      beq:begin
        memwrite = 0;
        branch = 1;
        alusrc = 0;
        regwrite = 0;
        aluOp = 2'b01;
      end
      addi: begin
        memtoreg = 0;
        alusrc = 1;
        branch = 0;
        regdst = 0;
        regwrite = 1;
        aluOp = 2'b00;
        memwrite = 0;
      end
	endcase
  end
  
  always@(*)begin
    case(aluOp)
      2'b00:begin
        AC = 3'b010;
      end
      2'b01:begin
        AC = 3'b110;
      end
      2'b10:begin
        case(funct)
          6'b100000:begin
            AC = 3'b010;
          end
          6'b100010:begin
            AC = 3'b110;
          end
          6'b100100:begin
            AC = 3'b000;
          end
          6'b100101:begin
            AC = 3'b001;
          end
          6'b101010:begin
            AC = 3'b111;
          end
        endcase
      end
    endcase
  end
  
endmodule

