DIGITO	[0-9]
LETRA	[a-zA-Z]
FINALSUBLINHADO [_]({LETRA}|{DIGITO})+
ID	{LETRA}({LETRA}|{DIGITO})*{FINALSUBLINHADO}*
FACAO [.]{DIGITO}+
EXP_OPC ([E][+\-]{DIGITO}+)?
INTEIRO {DIGITO}+{EXP_OPC}
REAL {DIGITO}+{FACAO}{EXP_OPC}
BRANCO [ \n\t]
VOID "void"
MAIN "main"
PALAVRA_RESERVADA {VOID}|{MAIN}|"if"|"while"|"return"|"do"|"skip"
TIPO "int"|"bool"
BOOL "true"|"false"
OP_BOOL "not"|"and"|"or"|"leq"
OP_ARITM1 "+"|"-"
OP_ARITM2 "*"|"/"
PARENTESES_1 "("
PARENTESES_2 ")"
CHAVES_1 "{"
CHAVES_2 "}"
FIM_COM ";"
VIRGULA ","
ATRIB ":="

%%
{PALAVRA_RESERVADA}     {printf("Palavra reservada: %s\n", yytext);}
{INTEIRO}		        {printf("Inteiro: %s\n",yytext);}
{REAL}              	{printf("Real: %s\n",yytext);}
{TIPO}			        {printf("Tipo: %s\n",yytext);}
{BOOL}			        {printf("Booleano: %s\n",yytext);}
{OP_BOOL}			    {printf("Operador lógico: %s\n",yytext);}
{OP_ARITM1}|{OP_ARITM2}	{printf("Operador aritmético: %s\n",yytext);}
{PARENTESES_1}			{printf("Abre parenteses: %s\n",yytext);}
{PARENTESES_2}			{printf("Fecha parenteses: %s\n",yytext);}
{CHAVES_1}			    {printf("Abre chaves: %s\n",yytext);}
{CHAVES_2}			    {printf("Fecha chaves: %s\n",yytext);}
{FIM_COM}			    {printf("Fim de comando: %s\n",yytext);}
{VIRGULA}			    {printf("Vírgula: %s\n",yytext);}
{ATRIB}			        {printf("Atribuição: %s\n",yytext);}
{ID}			        {printf("Var: %s\n",yytext);}
{BRANCO}         { char *c; scanf("%[ \n\t]s", c); }

%%
int yywrap();

main(){
  yylex();
}

int yywrap(){
 return 1;
}
