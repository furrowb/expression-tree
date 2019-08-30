package com.furrow.expression.node

/**
 * A node in the expression tree.
 * @param <F> The description of the first operand
 * @param <S> The description of the second operand
 * @param <T> The output description of the evaluation of the node
 */
abstract class Node<F, S, out T> {

    protected abstract val firstOperand: Node<F, S, T>?
    protected abstract val secondOperand: Node<F, S, T>?

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
