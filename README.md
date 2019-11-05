# Kotlin-Compiler-Crash-Course
A repository of helpful sources to figure out what the Kotlin compiler really is

![Alt Text](https://media.giphy.com/media/3o6Mb774rffWwh0AXm/giphy.gif)

## Lexer
The lexer phase breaks source code text into a sequence of lexical tokens:
* [KotlinLexer.kt](https://github.com/Kotlin/kotlin-spec/blob/master/grammar/src/main/antlr/KotlinLexer.g4)

## Parser and PSI/AST
* [JetBrains IntelliJ SDK Documentation: Implementing Parser and PSI](https://www.jetbrains.org/intellij/sdk/docs/reference_guide/custom_language_support/implementing_parser_and_psi.html)
* [JetBrains Plugins: PSIViewer Library](https://plugins.jetbrains.com/plugin/227-psiviewer)

## PSI/AST
According to the Kotlin compiler, a PSI, or Program Structure Interface, tree is built on top of the AST, adding semantics and methods for manipulating specific language constructs.

The AST nodes have a direct mapping to text ranges in the underlying document. The bottom-most nodes of the AST match individual tokens returned by the lexer, and higher level nodes match multiple-token fragments. Operations performed on nodes of the AST tree, such as inserting, removing, reordering nodes and so on, are immediately reflected as changes to the text of the underlying document ([Implementing Parser and PSI](https://www.jetbrains.org/intellij/sdk/docs/reference_guide/custom_language_support/implementing_parser_and_psi.html)).

The AST is used intensively during semantic analysis, where the compiler checks for correct usage of the elements of the program and the language. It also describes an abstracted representation of what a user writes in Kotlin. AST allows us to change the surface syntax of the language without changing the rest of the compiler (although that rarely happens),

* [Washington CS Course 401: Abstract Syntax Parsing Trees](https://courses.cs.washington.edu/courses/cse401/08wi/lecture/AST.pdf)
* [Grinnell College CS Course 362: Semantic Actions](http://www.cs.grinnell.edu/~rebelsky/Courses/CS362/98F/Outlines/outline.15.html)
* [Grinnell College CS Course 365: Abstract Parse Trees](http://www.cs.grinnell.edu/~rebelsky/Courses/CS362/98F/Outlines/outline.16.html)
* [Architecture-driven Modernization: Abstract Syntax Tree Metamodel (ASTM)](https://www.omg.org/spec/ASTM/1.0/PDF)
* [The Disadvantages of AST](https://vinaytech.wordpress.com/tag/disadvantages-of-ast/)

* [Eclipse plugin: AST View](https://www.eclipse.org/jdt/ui/astview/index.php)

## The Compiler

![Alt Text](https://github.com/ahinchman1/Kotlin-Compiler-Crash-Course/blob/master/Kotlin%20Compiler%20Modified.png)

* [vektory79 CompileTest.kt](https://github.com/vektory79/kotlin-script-parser-test/blob/master/src/main/java/hello/CompileTest.kt)

### The Resolution Phase
* [ResolutionResultsHandler.kt](https://github.com/JetBrains/kotlin/blob/9ba7907b815780531d27fe9be0cfe3308f50111f/compiler/frontend/src/org/jetbrains/kotlin/resolve/calls/results/ResolutionResultsHandler.java)
* [Wikipedia: Compiler](https://en.wikipedia.org/wiki/Compiler)
