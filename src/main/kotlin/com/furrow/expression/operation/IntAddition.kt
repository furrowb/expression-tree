package com.furrow.expression.operation

import com.furrow.expression.node.Node

class IntAddition(override val firstOperand: Node<Int>, override val secondOperand: Node<Int>): Node<Int>() {

    override fun calculate(): Int = calculateNode(firstOperand) + calculateNode(secondOperand)

    private fun calculateNode(operand: Node<Int>): Int = operand.value ?: operand.calculate()

    override fun type(): String = "Int Addition"
}