package com.furrow.expression.operation

import com.furrow.expression.BINARY_OPERATION
import com.furrow.expression.node.Node

// The sealed class allows us to create an instance of an operation node easily.
sealed class OperationType<T>(val numOfOperands: Int) {
    class AdditionType<T>: OperationType<T>(BINARY_OPERATION) {
        override fun name(): String = "AdditionType"
        override fun createOperation(params: List<Node<T>>): Node<T> = Addition(params)
    }

    class MultiplicationType<T>: OperationType<T>(BINARY_OPERATION) {
        override fun name(): String = "MultiplicationType"
        override fun createOperation(params: List<Node<T>>): Node<T> = Multiplication(params)
    }

    class DivisionType<T>: OperationType<T>(BINARY_OPERATION) {
        override fun name(): String = "DivisionType"
        override fun createOperation(params: List<Node<T>>): Node<T> = Division(params)
    }

    abstract fun createOperation(params: List<Node<T>>): Node<T>
    abstract fun name(): String
}