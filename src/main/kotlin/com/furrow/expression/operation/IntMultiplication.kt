package com.furrow.expression.operation

import com.furrow.expression.alias.IntNode

class IntMultiplication(override val firstOperand: IntNode, override val secondOperand: IntNode): IntNode() {

    override fun description(): String = "Int Multiplication"

    override fun evaluate(): Int = firstOperand.evaluate() * secondOperand.evaluate()

}