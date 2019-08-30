package com.furrow.expression.operation

import com.furrow.expression.node.Node

typealias DoubleNode=Node<Double>

class DoubleAddition(override val firstOperand: DoubleNode, override val secondOperand: DoubleNode): DoubleNode() {

    override fun description(): String = "Adds a Double to a Double and returns a Double"

    override fun evaluate(): Double = firstOperand.evaluate() + secondOperand.evaluate()
}