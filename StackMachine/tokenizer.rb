require './operators'

class Token
    def initialize(lexema)
        @lexema = lexema
        @type = enum(lexema)
    end

    def lexema
        @lexema
    end

    def getNumber
        if NUM?
            return @lexema.split(" ")[1].to_i
        end

        nil
    end

    def NUM?
        return @type == "NUM"
    end

    def OP?
        return @type == "OP"
    end

    def HALT?
        return @type == "HALT"
    end

    private

    def enum(lexema)
        case lexema
        when /PUSH .*/
            line = lexema.split(" ")
            if line.length == 2 && numeric?(line[1])
                return "NUM"
            end
        when "SUM", "SUB", "MULT", "DIV"
            return "OP"
        when "EOF"
            return "HALT"
        end
    end

    def numeric?(lexema)
        Float(lexema) != nil rescue false
    end
end

class Tokenizer
    def initialize(code)
        @stack = code.split("\n").reverse!
    end

    def getNextToken
        lexema = @stack.pop || "EOF"
        Token.new(lexema)
    end
end