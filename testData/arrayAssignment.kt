/**
 * Generated tests, only for this one class. Classes are located in testData files -
 * original code put through transformations
 *
 * Directory guide:
 * arrayAssignment.raw-fir.txt - generated in :compiler:fir:raw-fir:psi2ir
 * arrayAssignment.visualizer.psi.fir.kt - generated in :visualizer/testData/rawBuilder/expressions
 * arrayAssignment.ir.kt - generated in :compiler/testData/ir/irText/expressions
 * arrayAssignment.fir.ir.kt - generated in :compiler/testData/ir/irText/expressions
 *
 */


fun test() {
    val x = intArrayOf(1, 2, 3)
    x[1] = 0
}

fun foo() = 1

fun test2() {
    intArrayOf(1, 2, 3)[foo()] = 1
}