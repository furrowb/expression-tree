package com.furrow.expression.operation

import com.furrow.expression.node.Node

class IntMultiplication(override val firstOperand: Node<Int>, override val secondOperand: Node<Int>): Node<Int>() {

    override fun type(): String = "Int Multiplication"

    override fun evaluate(): Int = evaluateNode(firstOperand) * evaluateNode(secondOperand)

    private fun evaluateNode(operand: Node<Int>): Int = operand.value ?: operand.evaluate()

}