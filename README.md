# Kotlin-Compiler-Crash-Course
A repository of helpful sources to figure out what the Kotlin compiler really is

![Alt Text](https://media.giphy.com/media/3o6Mb774rffWwh0AXm/giphy.gif)

* A compiler is a computer program that translates computer code written in one programming language into another language: the target language.
    * Normally used for programs that translate from one higher language to a lower-level language to create an executable program

* The frontend verifies syntax and semantics. For statically-typed languages, it performs type-checking by collecting type information
    * If the input program is syntactically incorrect, or has a type error, it generates error and/or warning messages, usually identifying the location in the source code
    * Other aspects of the frontend:
        * Lexical analysis
        * Syntax analysis
        * Semantic analysis
    * The frontend transforms the input program into an intermediate representation 
* The middle-end performs optimizations on IR that are independent of the CPU architecture being targets
    * i.e. removing dead code, unreachable code, discovery and propagation of constant value, refactoring
* The back-end takes the optimized IR the middle end. It may perform more analysis, transformations + optimizations that are specific for the target CPU architecture 
    * Responsible for the multithreading and other parallel processing 

![Alt Text](https://github.com/ahinchman1/Kotlin-Compiler-Crash-Course/blob/master/Kotlin_compiler.png)

## Phases of the Frontend

### Lexer

The lexer phase breaks source code text into a sequence of lexical tokens:
* [KotlinLexer.kt](https://github.com/Kotlin/kotlin-spec/blob/master/grammar/src/main/antlr/KotlinLexer.g4)
* This phase can then split into 2 phases:
    * Scanning: segments input text into syntactic units and assign them a category
    * Evaluating: converts lexemes into a processed val

### Parser

* Involves parsing the token sequence to identify the syntactic structure of the program
    * This phase typically builds a parse tree. A parse tree is often analyzed, augmented, and transformed by later phases in the compiler. 
        * Builds symbol table 

* [JetBrains IntelliJ SDK Documentation: Implementing Parser and PSI](https://www.jetbrains.org/intellij/sdk/docs/reference_guide/custom_language_support/implementing_parser_and_psi.html)
* [JetBrains Plugins: PSIViewer Library](https://plugins.jetbrains.com/plugin/227-psiviewer)

### PSI/AST trees
According to the Kotlin compiler, a PSI, or Program Structure Interface, tree is built on top of the AST, adding semantics and methods for manipulating specific language constructs.

The AST nodes have a direct mapping to text ranges in the underlying document. The bottom-most nodes of the AST match individual tokens returned by the lexer, and higher level nodes match multiple-token fragments. Operations performed on nodes of the AST tree, such as inserting, removing, reordering nodes and so on, are immediately reflected as changes to the text of the underlying document ([Implementing Parser and PSI](https://www.jetbrains.org/intellij/sdk/docs/reference_guide/custom_language_support/implementing_parser_and_psi.html)).

The AST is used intensively during semantic analysis, where the compiler checks for correct usage of the elements of the program and the language. It also describes an abstracted representation of what a user writes in Kotlin. AST allows us to change the surface syntax of the language without changing the rest of the compiler (although that rarely happens),

* [Washington CS Course 401: Abstract Syntax Parsing Trees](https://courses.cs.washington.edu/courses/cse401/08wi/lecture/AST.pdf)
* [Grinnell College CS Course 362: Semantic Actions](http://www.cs.grinnell.edu/~rebelsky/Courses/CS362/98F/Outlines/outline.15.html)
* [Grinnell College CS Course 365: Abstract Parse Trees](http://www.cs.grinnell.edu/~rebelsky/Courses/CS362/98F/Outlines/outline.16.html)
* [Architecture-driven Modernization: Abstract Syntax Tree Metamodel (ASTM)](https://www.omg.org/spec/ASTM/1.0/PDF)
* [The Disadvantages of AST](https://vinaytech.wordpress.com/tag/disadvantages-of-ast/)

* [Eclipse plugin: AST View](https://www.eclipse.org/jdt/ui/astview/index.php)

### Semantic analysis
* performs semantic checks such as type-checking, object binding, or definite assignment
    * Semantic analysis usually requires a complete parse tree
* [ResolutionResultsHandler.kt](https://github.com/JetBrains/kotlin/blob/9ba7907b815780531d27fe9be0cfe3308f50111f/compiler/frontend/src/org/jetbrains/kotlin/resolve/calls/results/ResolutionResultsHandler.java)
* [Wikipedia: Compiler](https://en.wikipedia.org/wiki/Compiler)

## Middle-end phases of the Compiler

* Also known as the optimizer, performs optimizations on the intermediate representation
* Analysis: data analysis from the intermediate representation
    * Data-flow analysis
    * Alias analysis
    * Pointer analysis
    * Escape analysis
* Accurate analysis is the basis for any compiler optimization
    * Control flow graph
    * Call graph
* Complier analysis is a prerequisite for any compiler optimization

## Backend of the Complier 

* Responsible for the CPU architecture-specific optimizations and for code generation
* Machine-dependent optimizations: optimizations that depend on the details of the CPU architecture that the compiler targets
* Code Generation: transforms IR into the output language, usually the native machine language of the ysstem
    * Resource and storage decisions

## More resources around the Kotlin Compiler

* [vektory79 CompileTest.kt](https://github.com/vektory79/kotlin-script-parser-test/blob/master/src/main/java/hello/CompileTest.kt)

* [Logo Compiler written by Cesar Enrique](https://github.com/caenrique/logoCompiler)

