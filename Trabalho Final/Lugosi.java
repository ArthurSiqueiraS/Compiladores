/* Generated By:JavaCC: Do not edit this line. Lugosi.java */
import java.io.*;
import java.util.ArrayList;

class ArvoreLugosi {
  Main main;
  ArrayList<Func> funcs;

  public ArvoreLugosi(Main main, ArrayList<Func> funcs) {
    this.main = main;
    this.funcs = funcs;
  }
}

class Main {
  ArrayList<VarDecl> varDecls;
  ArrayList<Comando> comandos;

  public Main(ArrayList<VarDecl> varDecls, ArrayList<Comando> comandos) {
    this.varDecls = varDecls;
    this.comandos = comandos;
  }
}

class VarDecl {
  Tipo tipo;
  String var;

  public VarDecl(Tipo tipo, String var) {
    this.tipo = tipo;
    this.var = var;
  }
}

abstract class Tipo {}

class Int extends Tipo {}

class Bool extends Tipo {}

abstract class Comando {}

class Atribuicao extends Comando {
  String var;
  Exp exp;

  public Atribuicao(String var, Exp exp) {
    this.var = var;
    this.exp = exp;
  }
}

class ChamadaFuncao extends Comando {
  String nomeFuncao;
  ArrayList<Exp> argumentos;

  public ChamadaFuncao(String nomeFuncao, ArrayList<Exp> argumentos) {
    this.nomeFuncao = nomeFuncao;
    this.argumentos = argumentos;
  }
}

class If extends Comando {
  Exp cond;
  ArrayList<Comando> then;

  public If(Exp cond, ArrayList<Comando> then) {
    this.cond = cond;
    this.then = then;
  }
}

class While extends Comando {
  Exp cond;
  ArrayList<Comando> then;

  public While(Exp cond, ArrayList<Comando> then) {
    this.cond = cond;
    this.then = then;
  }
}

class DoWhile extends Comando {
  Exp cond;
  ArrayList<Comando> then;

  public DoWhile(Exp cond, ArrayList<Comando> then) {
    this.cond = cond;
    this.then = then;
  }
}

class Return extends Comando {
  Exp exp;

  public Return(Exp exp) {
    this.exp = exp;
  }
}

class Print extends Comando {
  Exp exp;

  public Print(Exp exp) {
    this.exp = exp;
  }
}

class Func {
  Tipo tipo;
  String nome;
  ArrayList<Arg> argumentos;
  ArrayList<VarDecl> varDecls;
  ArrayList<Comando> comandos;

  public Func(Tipo tipo, String nome, ArrayList<Arg> argumentos, ArrayList<VarDecl> varDecls, ArrayList<Comando> comandos) {
    this.tipo = tipo;
    this.nome = nome;
    this.argumentos = argumentos;
    this.varDecls = varDecls;
    this.comandos = comandos;
  }
}

abstract class Exp {}

class OperadorInfixo extends Exp {
  Exp arg1, arg2;
  String op;

  public OperadorInfixo(Exp arg1, Exp arg2, String op) {
    this.arg1 = arg1;
    this.arg2 = arg2;
    this.op = op;
  }
}

abstract class Fator extends Exp {}

class TokenId extends Fator {
  String token;

  public TokenId(String token) {
    this.token = token;
  }
}

class FuncFator extends Fator {
  String func;
  ArrayList<Exp> argumentos;

  public FuncFator(String func, ArrayList<Exp> argumentos) {
    this.func = func;
    this.argumentos = argumentos;
  }
}

class TokenNum extends Fator {
  String num;

  public TokenNum(String num) {
    this.num = num;
  }
}

class True extends Fator {}

class False extends Fator {}

class Arg {
  Tipo tipo;
  TokenId tokenId;

  public Arg(Tipo tipo, TokenId tokenId) {
    this.tipo = tipo;
    this.tokenId = tokenId;
  }
}

public class Lugosi implements LugosiConstants {

  public static void main(String args[]) throws ParseException,IOException {

    Lugosi parser = new Lugosi(new FileInputStream(args[0]));
    ArvoreLugosi arvore = parser.Lugosi();
  }

  static final public ArvoreLugosi Lugosi() throws ParseException {
  Main main;
  ArrayList<Func> funcs = new ArrayList<Func>();
    main = Main();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case FUNCTION:
      Func(funcs);
      break;
    default:
      jj_la1[0] = jj_gen;
      ;
    }
    jj_consume_token(0);
    {if (true) return new ArvoreLugosi(main, funcs);}
    throw new Error("Missing return statement in function");
  }

  static final public Main Main() throws ParseException {
  ArrayList<VarDecl> varDecls;
  ArrayList<Comando> comandos;
    jj_consume_token(MAIN);
    jj_consume_token(ACHAVES);
    varDecls = VarDecl();
    comandos = SeqComandos();
    jj_consume_token(FCHAVES);
    {if (true) return new Main(null, null);}
    throw new Error("Missing return statement in function");
  }

  static final public ArrayList<VarDecl> VarDecl() throws ParseException {
  ArrayList<VarDecl> varDecls = new ArrayList<VarDecl>();
  Tipo tipo;
  Token var, tokenTipo;
  Int tipoInt = new Int();
  Bool tipoBool = new Bool();
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case VAR:
        ;
        break;
      default:
        jj_la1[1] = jj_gen;
        break label_1;
      }
      jj_consume_token(VAR);
      tokenTipo = jj_consume_token(TIPO);
      var = jj_consume_token(ID);
      jj_consume_token(PTVIRG);
      tipo = tokenTipo.toString().equals("int") ? tipoInt : tipoBool;
      varDecls.add(new VarDecl(tipo, var.toString()));
    }
    {if (true) return varDecls;}
    throw new Error("Missing return statement in function");
  }

  static final public ArrayList<Comando> SeqComandos() throws ParseException {
  ArrayList<Comando> comandos = new ArrayList<Comando>();
  Comando comando;
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IF:
      case WHILE:
      case DO:
      case RETURN:
      case PRINT:
      case ID:
        ;
        break;
      default:
        jj_la1[2] = jj_gen;
        break label_2;
      }
      comando = ComanCondBlock();
      comandos.add(comando);
    }
    {if (true) return comandos;}
    throw new Error("Missing return statement in function");
  }

  static final public Comando ComanCondBlock() throws ParseException {
  Comando comando;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ID:
    Token nomeFuncao;
    ArrayList<Exp> argumentos;
      nomeFuncao = jj_consume_token(ID);
      comando = Comando_(nomeFuncao.toString());
    {if (true) return comando;}
      break;
    case IF:
    case WHILE:
    case DO:
    Exp cond;
    ArrayList<Comando> then;
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IF:
        jj_consume_token(IF);
        cond = ExpPar();
        then = CondBlock();
        jj_consume_token(PTVIRG);
      {if (true) return new If(cond, then);}
        break;
      case WHILE:
        jj_consume_token(WHILE);
        cond = ExpPar();
        jj_consume_token(DO);
        then = CondBlock();
        jj_consume_token(PTVIRG);
      {if (true) return new While(cond, then);}
        break;
      case DO:
        jj_consume_token(DO);
        then = CondBlock();
        jj_consume_token(WHILE);
        cond = ExpPar();
        jj_consume_token(PTVIRG);
      {if (true) return new DoWhile(cond, then);}
        break;
      default:
        jj_la1[3] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
    case RETURN:
    case PRINT:
     Exp exp;
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case RETURN:
        jj_consume_token(RETURN);
        exp = Exp();
        jj_consume_token(PTVIRG);
      {if (true) return new Return(exp);}
        break;
      case PRINT:
        jj_consume_token(PRINT);
        exp = ExpPar();
        jj_consume_token(PTVIRG);
      {if (true) return new Print(exp);}
        break;
      default:
        jj_la1[4] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
    default:
      jj_la1[5] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static final public ArrayList<Comando> CondBlock() throws ParseException {
  ArrayList<Comando> comandos;
    jj_consume_token(ACHAVES);
    comandos = SeqComandos();
    jj_consume_token(FCHAVES);
    {if (true) return comandos;}
    throw new Error("Missing return statement in function");
  }

  static final public Exp ExpPar() throws ParseException {
  Exp exp;
    jj_consume_token(APARNTS);
    exp = Exp();
    jj_consume_token(FPARNTS);
    {if (true) return exp;}
    throw new Error("Missing return statement in function");
  }

  static final public Comando Comando_(String id) throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ATRIB:
    Exp argumento;
      jj_consume_token(ATRIB);
      argumento = Exp();
      jj_consume_token(PTVIRG);
    {if (true) return new Atribuicao(id, argumento);}
      break;
    case APARNTS:
    ArrayList<Exp> argumentos = new ArrayList<Exp>();
      jj_consume_token(APARNTS);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case APARNTS:
      case NUM:
      case BOOL:
      case ID:
        ListaExp(argumentos);
        break;
      default:
        jj_la1[6] = jj_gen;
        ;
      }
      jj_consume_token(FPARNTS);
      jj_consume_token(PTVIRG);
    {if (true) return new ChamadaFuncao(id, argumentos);}
      break;
    default:
      jj_la1[7] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static final public Exp Exp() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case APARNTS:
    Exp arg1, arg2;
    Token op;
      jj_consume_token(APARNTS);
      arg1 = Exp();
      op = jj_consume_token(OP);
      arg2 = Exp();
      jj_consume_token(FPARNTS);
    {if (true) return new OperadorInfixo(arg1, arg2, op.toString());}
      break;
    case NUM:
    case BOOL:
    case ID:
    Exp fator;
      fator = Fator();
    {if (true) return fator;}
      break;
    default:
      jj_la1[8] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static final public Fator Fator() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ID:
    Token token;
    String func = null;
    ArrayList<Exp> argumentos = new ArrayList<Exp>();
      token = jj_consume_token(ID);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case APARNTS:
        func = token.toString();
        jj_consume_token(APARNTS);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case APARNTS:
        case NUM:
        case BOOL:
        case ID:
          ListaExp(argumentos);
          break;
        default:
          jj_la1[9] = jj_gen;
          ;
        }
        jj_consume_token(FPARNTS);
        break;
      default:
        jj_la1[10] = jj_gen;
        ;
      }
    {if (true) return func == null ? new FuncFator(token.toString(), argumentos) : new TokenId(func);}
      break;
    case NUM:
    Token num;
      num = jj_consume_token(NUM);
    {if (true) return new TokenNum(num.toString());}
      break;
    case BOOL:
    Fator bool;
    Token boolToken;
      boolToken = jj_consume_token(BOOL);
    {if (true) return boolToken.toString().equals("True") ? new True() : new False();}
      break;
    default:
      jj_la1[11] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static final public void ListaExp(ArrayList<Exp> exps) throws ParseException {
  Exp exp;
    exp = Exp();
    exps.add(exp);
    ListaExp_(exps);
  }

  static final public void ListaExp_(ArrayList<Exp> exps) throws ParseException {
  Exp exp;
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case VIRG:
        ;
        break;
      default:
        jj_la1[12] = jj_gen;
        break label_3;
      }
      jj_consume_token(VIRG);
      exp = Exp();
      exps.add(exp);
    }
  }

  static final public void Func(ArrayList<Func> funcs) throws ParseException {
  Tipo tipo;
  Token nome, tokenTipo;
  ArrayList<Arg> argumentos = new ArrayList<Arg>();
  ArrayList<VarDecl> varDecls;
  ArrayList<Comando> comandos;
  Int tipoInt = new Int();
  Bool tipoBool = new Bool();
    label_4:
    while (true) {
      jj_consume_token(FUNCTION);
      tokenTipo = jj_consume_token(TIPO);
      nome = jj_consume_token(ID);
      jj_consume_token(APARNTS);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case TIPO:
        ListaArg(argumentos);
        break;
      default:
        jj_la1[13] = jj_gen;
        ;
      }
      jj_consume_token(FPARNTS);
      jj_consume_token(ACHAVES);
      varDecls = VarDecl();
      comandos = SeqComandos();
      jj_consume_token(FCHAVES);
      tipo = tokenTipo.toString().equals("int") ? tipoInt : tipoBool;
      funcs.add(new Func(tipo, nome.toString(), argumentos, varDecls, comandos));
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case FUNCTION:
        ;
        break;
      default:
        jj_la1[14] = jj_gen;
        break label_4;
      }
    }
  }

  static final public void ListaArg(ArrayList<Arg> argumentos) throws ParseException {
  Tipo tipo;
  Token token, tokenTipo;
  Int tipoInt = new Int();
  Bool tipoBool = new Bool();
    tokenTipo = jj_consume_token(TIPO);
    token = jj_consume_token(ID);
    tipo = tokenTipo.equals("int") ? tipoInt : tipoBool;
    argumentos.add(new Arg(tipo, new TokenId(token.toString())));
    label_5:
    while (true) {
      ListaArg_(argumentos, tipoInt, tipoBool);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case VIRG:
        ;
        break;
      default:
        jj_la1[15] = jj_gen;
        break label_5;
      }
    }
  }

  static final public void ListaArg_(ArrayList<Arg> argumentos, Int tipoInt, Bool tipoBool) throws ParseException {
  Tipo tipo;
  Token token, tokenTipo;
    jj_consume_token(VIRG);
    tokenTipo = jj_consume_token(TIPO);
    token = jj_consume_token(ID);
    tipo = tokenTipo.equals("int") ? tipoInt : tipoBool;
    argumentos.add(new Arg(tipo, new TokenId(token.toString())));
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public LugosiTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[16];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x2000,0x40,0x1001f00,0x700,0x1800,0x1001f00,0x1310000,0x10080,0x1310000,0x1310000,0x10000,0x1300000,0x40000,0x400000,0x2000,0x40000,};
   }

  /** Constructor with InputStream. */
  public Lugosi(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Lugosi(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new LugosiTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 16; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 16; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public Lugosi(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new LugosiTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 16; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 16; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public Lugosi(LugosiTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 16; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(LugosiTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 16; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[25];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 16; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 25; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}