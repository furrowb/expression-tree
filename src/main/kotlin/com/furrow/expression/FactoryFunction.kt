package com.furrow.expression

import com.furrow.expression.exception.OperationException
import com.furrow.expression.node.Node
import com.furrow.expression.node.ValueNode
import com.furrow.expression.operation.Addition
import com.furrow.expression.operation.Multiplication
import com.furrow.expression.operation.OperationType
import java.util.*

class FactoryFunction<T> {

    private val stack: Stack<Node<T>> = Stack()

    fun pushValue(value: T) {
        stack.push(ValueNode(value))
    }

    fun pushOperation(operation: OperationType<T>) {
        if(stack.size < operation.numOfOperands) {
            throw OperationException("Not enough operands for OperationType ${operation.name()}")
        }
        val params = ArrayList<Node<T>>()
        for(i in 1..operation.numOfOperands) {
            params.add(stack.pop())
        }

        val operationNode = operation.createOperation(params.reversed())
        stack.push(operationNode)
    }

    fun getRootNode(): Node<T> {
        if(stack.size != 1) {
            throw RuntimeException("Stack is either empty or not all values are associated with a operation. Unable to get the root node")
        }
        val node = stack.pop()
        stack.clear()
        return node
    }

    fun evaluate(): T {
        return getRootNode().evaluate()
    }
}