package com.furrow.expression.node

class ValueNode<T>(private val value: T): Node<T, T, T>() {

    override val firstOperand: Node<T, T, T>? = null
    override val secondOperand: Node<T, T, T>? = null

    override fun description(): String = "Node's value: $value"

    override fun evaluate(): T = value
}