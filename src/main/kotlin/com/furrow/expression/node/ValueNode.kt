package com.furrow.expression.node

class ValueNode<T>(value: T): Node<T>(value) {

    override val firstOperand: Node<T>? = null
    override val secondOperand: Node<T>? = null

    override fun type(): String = "Node's value: $value"

    override fun calculate(): T = value ?: throw NullPointerException()
}