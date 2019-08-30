package com.furrow.expression.node

/**
 * This node represents a constant value. It is a leaf node.
 *
 * @param value The value of the constant
 * @param T The type of the constant value
 */
class ValueNode<T>(private val value: T): Node<T>() {

    override val firstOperand: Node<T>? = null
    override val secondOperand: Node<T>? = null

    override fun description(): String = "Node's value: $value"

    override fun evaluate(): T = value
}