package com.furrow.expression.operation

import com.furrow.expression.node.Node
import com.furrow.expression.node.ValueNode

class IntToDouble(val value: Int): Node<Double>() {
    override val firstOperand: Node<Double>? = null
    override val secondOperand: Node<Double>? = null

    override fun description(): String = "Converts an Int to a Double"

    override fun evaluate(): Double = value.toDouble()
}