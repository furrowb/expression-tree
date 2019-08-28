package com.furrow.expression.node

abstract class Node<out T>(val value: T? = null) {
    protected abstract val firstOperand: Node<T>?
    protected abstract val secondOperand: Node<T>?

    abstract fun type(): String
    abstract fun calculate(): T
}
