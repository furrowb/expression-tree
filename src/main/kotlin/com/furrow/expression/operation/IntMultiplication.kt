package com.furrow.expression.operation

import com.furrow.expression.node.Node

class IntMultiplication<F,S>(override val firstOperand: Node<F, S, Int>, override val secondOperand: Node<F, S, Int>): Node<F, S, Int>() {

    override fun description(): String = "Int Multiplication"

    override fun evaluate(): Int = firstOperand.evaluate() * secondOperand.evaluate()

}