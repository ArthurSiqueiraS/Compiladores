/* Generated By:JavaCC: Do not edit this line. Lugosi.java */
import java.io.*;
public class Lugosi implements LugosiConstants {

  public static void main(String args[]) throws ParseException,IOException {

    Lugosi parser = new Lugosi(new FileInputStream(args[0]));
    parser.Lugosi();
  }

  static final public void Lugosi() throws ParseException {
    Main();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case FUNCTION:
      Func();
      break;
    default:
      jj_la1[0] = jj_gen;
      ;
    }
    jj_consume_token(0);
  }

  static final public void Main() throws ParseException {
    jj_consume_token(MAIN);
    jj_consume_token(ACHAVES);
    VarDecl();
    SeqComandos();
    jj_consume_token(FCHAVES);
  }

  static final public void VarDecl() throws ParseException {
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
      jj_consume_token(TIPO);
      jj_consume_token(ID);
      jj_consume_token(PTVIRG);
    }
  }

  static final public void SeqComandos() throws ParseException {
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
      ComanCondBlock();
    }
  }

  static final public void ComanCondBlock() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ID:
      jj_consume_token(ID);
      Comando_();
      break;
    case IF:
      jj_consume_token(IF);
      ExpPar();
      CondBlock();
      jj_consume_token(PTVIRG);
      break;
    case WHILE:
      jj_consume_token(WHILE);
      ExpPar();
      jj_consume_token(DO);
      CondBlock();
      jj_consume_token(PTVIRG);
      break;
    case DO:
      jj_consume_token(DO);
      CondBlock();
      jj_consume_token(WHILE);
      ExpPar();
      jj_consume_token(PTVIRG);
      break;
    case RETURN:
      jj_consume_token(RETURN);
      Exp();
      jj_consume_token(PTVIRG);
      break;
    case PRINT:
      jj_consume_token(PRINT);
      ExpPar();
      jj_consume_token(PTVIRG);
      break;
    default:
      jj_la1[3] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void CondBlock() throws ParseException {
    jj_consume_token(ACHAVES);
    SeqComandos();
    jj_consume_token(FCHAVES);
  }

  static final public void ExpPar() throws ParseException {
    jj_consume_token(APARNTS);
    Exp();
    jj_consume_token(FPARNTS);
  }

  static final public void Comando_() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ATRIB:
      jj_consume_token(ATRIB);
      Exp();
      jj_consume_token(PTVIRG);
      break;
    case APARNTS:
      jj_consume_token(APARNTS);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case APARNTS:
      case NUM:
      case BOOL:
      case ID:
        ListaExp();
        break;
      default:
        jj_la1[4] = jj_gen;
        ;
      }
      jj_consume_token(FPARNTS);
      jj_consume_token(PTVIRG);
      break;
    default:
      jj_la1[5] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void Exp() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case APARNTS:
      jj_consume_token(APARNTS);
      Exp();
      jj_consume_token(OP);
      Exp();
      jj_consume_token(FPARNTS);
      break;
    case NUM:
    case BOOL:
    case ID:
      Fator();
      break;
    default:
      jj_la1[6] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void Fator() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ID:
      jj_consume_token(ID);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case APARNTS:
        jj_consume_token(APARNTS);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case APARNTS:
        case NUM:
        case BOOL:
        case ID:
          ListaExp();
          break;
        default:
          jj_la1[7] = jj_gen;
          ;
        }
        jj_consume_token(FPARNTS);
        break;
      default:
        jj_la1[8] = jj_gen;
        ;
      }
      break;
    case NUM:
      jj_consume_token(NUM);
      break;
    case BOOL:
      jj_consume_token(BOOL);
      break;
    default:
      jj_la1[9] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void ListaExp() throws ParseException {
    Exp();
    ListaExp_();
  }

  static final public void ListaExp_() throws ParseException {
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case VIRG:
        ;
        break;
      default:
        jj_la1[10] = jj_gen;
        break label_3;
      }
      jj_consume_token(VIRG);
      Exp();
    }
  }

  static final public void Func() throws ParseException {
    label_4:
    while (true) {
      jj_consume_token(FUNCTION);
      jj_consume_token(TIPO);
      jj_consume_token(ID);
      jj_consume_token(APARNTS);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ID:
        ListaArg();
        break;
      default:
        jj_la1[11] = jj_gen;
        ;
      }
      jj_consume_token(FPARNTS);
      jj_consume_token(ACHAVES);
      VarDecl();
      SeqComandos();
      jj_consume_token(FCHAVES);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case FUNCTION:
        ;
        break;
      default:
        jj_la1[12] = jj_gen;
        break label_4;
      }
    }
  }

  static final public void ListaArg() throws ParseException {
    jj_consume_token(ID);
    ListaArg_();
  }

  static final public void ListaArg_() throws ParseException {
    label_5:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case VIRG:
        ;
        break;
      default:
        jj_la1[13] = jj_gen;
        break label_5;
      }
      jj_consume_token(VIRG);
      jj_consume_token(ID);
      ListaArg_();
    }
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
  static final private int[] jj_la1 = new int[14];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x2000,0x40,0x1001f00,0x1001f00,0x1310000,0x10080,0x1310000,0x1310000,0x10000,0x1300000,0x40000,0x1000000,0x2000,0x40000,};
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
    for (int i = 0; i < 14; i++) jj_la1[i] = -1;
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
    for (int i = 0; i < 14; i++) jj_la1[i] = -1;
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
    for (int i = 0; i < 14; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 14; i++) jj_la1[i] = -1;
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
    for (int i = 0; i < 14; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(LugosiTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 14; i++) jj_la1[i] = -1;
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
    for (int i = 0; i < 14; i++) {
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
