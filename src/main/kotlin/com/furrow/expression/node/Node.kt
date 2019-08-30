package com.furrow.expression.node

/**
 * A node in the expression tree.
 * @param <T> The output type when the node is evaluated
 */
abstract class Node<T>(val params: List<Node<T>>?) {

    /**
     * The description of this node
     * @return The description
     */
    abstract fun description(): String

    /**
     * Evaluates the results from the two operands
     * @return The result evaluated for the operands
     */
    abstract fun evaluate(): T
}
