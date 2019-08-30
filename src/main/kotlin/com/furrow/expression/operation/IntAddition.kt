package com.furrow.expression.operation

import com.furrow.expression.alias.IntNode

class IntAddition(override val firstOperand: IntNode, override val secondOperand: IntNode): IntNode() {

    override fun evaluate(): Int = firstOperand.evaluate() + secondOperand.evaluate()

    override fun description(): String = "Int Addition"
}