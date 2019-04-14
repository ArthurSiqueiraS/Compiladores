## Compilar flex

```
flex mojica.l
```

## Compilar analisador

```
gcc -o mojica lex.yy.c
```

## Executar analisador

```
./mojica
./mojica < teste.moj
```
