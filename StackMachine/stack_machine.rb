require './tokenizer'

class StackMachine
    def run(file)
        code = open(file, 'r').read
        tokenizer = Tokenizer.new(code)

        args = []
        token = tokenizer.getNextToken

        until token.HALT?
            if token.NUM?
                args.push(token.getNumber)
            else
                arg2 = args.pop
                arg1 = args.pop
                args.push(send(token.lexema.downcase, arg1, arg2))
            end

            token = tokenizer.getNextToken
        end

        args[0]
    end
end

puts StackMachine.new.interpret(ARGV[0])