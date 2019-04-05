import java.io.*;

enum TokenType{ NUM,SOMA, SUB, MULT, DIV, APar,FPar, EOF}

class Token{
  String lexema;
  TokenType token;

 Token (char l, TokenType t)
 	{ lexema="" + l;token = t;}	

 Token (String l, TokenType t)
 	{ lexema=l;token = t;}	

}

class AnaliseLexica {

	PushbackReader arquivo;

	AnaliseLexica(String a) throws Exception
	{

	 	this.arquivo = new PushbackReader(new FileReader(a));

	}

	Token getNextToken() throws Exception
	{	
		Token token;
		int eof = -1;
		char currchar;
		int currchar1;

			do{
				currchar1 =  arquivo.read();
				currchar = (char) currchar1;
			} while (currchar == '\n' || currchar == ' ' || currchar =='\t' || currchar == '\r');
			
			if(currchar1 != eof && currchar1 !=10)
			{
								

				String num = "";
				while (currchar >= '0' && currchar <= '9') {
					num += currchar;
					currchar1 =  arquivo.read();
					currchar = (char) currchar1;
				}

				if (!num.equals("")) {
					arquivo.unread(currchar1);
					return (new Token (num,TokenType.NUM));
				}
				else
					switch (currchar){
						case '(':
							return (new Token (currchar,TokenType.APar));
						case ')':
							return (new Token (currchar,TokenType.FPar));
						case '+':
							return (new Token (currchar,TokenType.SOMA));
						case '-':
							return (new Token (currchar,TokenType.SUB));
						case '*':
							return (new Token (currchar,TokenType.MULT));
						case '/':
							return (new Token (currchar,TokenType.DIV));	
						
						default: throw (new Exception("Caractere inválido: " + ((int) currchar)));
					}
			}

			arquivo.close();
			
		return (new Token(currchar,TokenType.EOF));
		
	}
}
