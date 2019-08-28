package com.furrow.expression

import com.furrow.expression.node.ValueNode
import com.furrow.expression.operation.IntAddition
import com.furrow.expression.operation.IntMultiplication

class FactoryFunction {
    fun evaluate(): Int {
        val multiplicationNode = IntMultiplication(ValueNode(5), ValueNode(4))
        val additionNode = IntAddition(ValueNode(3), multiplicationNode)
        return additionNode.evaluate()
    }
}