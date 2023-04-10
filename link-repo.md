
## Resources, Links, and notes around testing

### Resources and additional links:
* The K2 Compiler is going stable in Kotlin 2.0 by Roman Elizarov [JB] - https://blog.jetbrains.com/kotlin/2023/02/k2-kotlin-2-0/
* The Road to the K2 Compiler by Svetlana Isaokva :https://blog.jetbrains.com/kotlin/2021/10/the-road-to-the-k2-compiler/
* Kotlin Language Specification by Marat Akhin and Mikhail Belyaev https://kotlinlang.org/spec/pdf/kotlin-spec.pdf
* Writing your First Kotlin Compiler Plugin by Kevin Most KotlinConf ’18 - https://www.youtube.com/watch?v=w-GMlaziIyo&ab_channel=JetBrains
* Kotlin plugins https://github.com/JetBrains/kotlin/tree/master/plugins
* Hitchhiker's Guide to Compose: https://www.droidcon.com/2022/09/29/a-hitchhikers-guide-to-compose-compiler-composers-compiler-plugins-and-snapshots-3/
* JB notes on diagrams: https://docs.google.com/presentation/d/e/2PACX-1vTzajwYJfmUi_Nn2nJBULi9bszNmjbO3c8K8dHRnK7vgz3AELunB6J7sfBodC2sKoaKAHibgEt_XjaQ/pub?slide=id.g955e8c1462_0_221

### Community notes
* overminder/kitchen-sink. Github. Kotlin Compiler Reading Notes by Yuxiang Jiang - [https://github.com/overminder/kitchen-sink/blob/master/writings/kotlin-compiler/notes/main.pdf]
* Compiler Diagrams by Abel Naya + community feedback - https://kotlinlang.slack.com/archives/C7L3JB43G/p1615394755006000

### Kotlinlang Slack
* compiler transforming IR in a plugin conversations : https://slack-chats.kotlinlang.org/c/compiler/26#62ca7141-1b02-454d-8e43-0e3897691a5b
* Dmitriy Novozhilov’s FIR notes - https://kotlinlang.slack.com/archives/C7L3JB43G/p1622478266038500
* The Kotlin compiler - https://slack-chats.kotlinlang.org/t/8294557/hey-i-am-really-interested-in-studying-the-source-code-but-i#b8d76d63-3c33-4c84-8eb8-460fc438784d
* Resolution notes - https://kotlinlang.slack.com/archives/C7L3JB43G/p1615394755006000 
    * https://docs.google.com/presentation/d/e/2PACX-1vTzajwYJfmUi_Nn2nJBULi9bszNmjbO3c8K8dHRnK7vgz3AELunB6J7sfBodC2sKoaKAHibgEt_XjaQ/pub?slide=id.g955e8c1462_0_45


### Kotlin Compiler Debugging Points
* Triggers frontend to resolve all the files https://github.com/JetBrains/kotlin/blob/master/compiler/cli/src/org/jetbrains/kotlin/cli/jvm/compiler/FirKotlinToJvmBytecodeCompiler.kt#L313
* Converts Frontend IR into Backend IR - https://github.com/JetBrains/kotlin/blob/master/compiler/cli/src/org/jetbrains/kotlin/cli/jvm/compiler/FirKotlinToJvmBytecodeCompiler.kt#L189
* Triggers the backend - https://github.com/JetBrains/kotlin/blob/master/compiler/cli/src/org/jetbrains/kotlin/cli/jvm/compiler/FirKotlinToJvmBytecodeCompiler.kt#L166

### Setting up FIR testing
- run ./gradlew publish
- Useful tests:
  - `FirDiagnosticTestGenerated` in `:compiler:fir:analysis-tests`: tests takes some program as input, give it to 
    the frontend and render diagnostics reported by the frontend
  - `FirBlackBoxCodegenTestGenerated` in `:compiler:fir:fir2ir`: tests takes some program as input, runs FIR, fir2ir and JVM IR backend and then runs `box` method from compiled code. If `box` returns `"OK"` then the test is passed

### Analysis API
- mixins for Analysis API: https://github.com/JetBrains/kotlin/blob/81336820e2865cdd3faa9ca7d3804037a8ab1a99/analysis/analysis-api/src/org/jetbrains/kotlin/analysis/api/KtAnalysisSession.kt
- ComposableDeclarationChecker: https://github.com/androidx/androidx/blob/androidx-main/compose/compiler/compiler-hosted/src/main/java/androidx/compose/compiler/plugins/kotlin/ComposableDeclarationChecker.kt
- 
