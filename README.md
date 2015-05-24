# booleancompliler
A small "compiler" for boolean expression for a tiny stack machine using a Recursive Descent Parser and the Visitor Pattern for the compiler

You can find a description of the project [here](https://unnikked.ga/how-to-compile-a-boolean-expression)

## Instruction Set

This tiny VM as a small instruction set just to support a boolean expression. 

- `PUSH` push a value onto the stack
- `AND` performs AND logic operation by popping two operands from the stack
- `OR` performs OR logic operation by popping two operands from the stack
- `NOT` performs NOT logic operation by popping one operand from the stack

The Virtual Machine handle 1 as `true` and 0 as `false`.  

## How to use

Clone the repository with: 

```
git clone https://github.com/unnikked-ga/booleancompliler.git
```

Compile:

```
javac src/ga/unnikked.booleancompliler/*.java src/ga/unnikked/booleancompliler/*/*.java
```

And execute it with (remember to `cd src`): 

```
java ga/unnikked/booleancompliler/Main
```

You can also pipe in a file using `-f` directive

```
cat yourfile | java ga/unnikked/booleancompliler/Main -f
```

Here an execution example:

```
$ cat test | java ga/unnikked/booleancompliler/Main -f
(true & ((true | false) & !(true & false)))
AST: (true & ((true | false) & !(true & false)))
CODE: [0, 1, 0, 1, 0, 0, 2, 0, 1, 0, 0, 1, 3, 1, 1]
RES: true
```

##License

Check `LICENSE`