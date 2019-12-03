package com.furrow.expression.operation

import com.furrow.expression.BINARY_OPERATION
import com.furrow.expression.exception.OperationException
import com.furrow.expression.node.Node
import java.lang.IllegalArgumentException

class Division<T>(params: List<Node<T>>): Node<T>(params) {

    override fun description(): String = "/"

    // Suppressing warnings as we are explicitly checking for type T, verifying
    // what it is and then returning it back to T (which is what it was).
    @Suppress("IMPLICIT_CAST_TO_ANY", "UNCHECKED_CAST")
    override fun evaluate(): T {
        if(params?.size != BINARY_OPERATION) {
            throw OperationException("Invalid number of parameters for ${description()}: ${params?.size}")
        }
        val firstParamResult = params[0].evaluate()
        val secondParamResult = params[1].evaluate()
        // Since we know the first parameter is type X, then all of them will be
        return when(firstParamResult) {
            is Int -> evaluate(firstParamResult, secondParamResult as Int)
            is Long -> evaluate(firstParamResult, secondParamResult as Long)
            is Double -> evaluate(firstParamResult, secondParamResult as Double)
            else -> throw OperationException("Unknown type being for ${description()}")
        } as T
    }

    private fun evaluate(firstOperand: Int, secondOperand: Int): Int {
        checkDivisionByZero(secondOperand)
        return firstOperand / secondOperand
    }

    private fun evaluate(firstOperand: Long, secondOperand: Long): Long {
        checkDivisionByZero(secondOperand)
        return firstOperand / secondOperand
    }

    private fun evaluate(firstOperand: Double, secondOperand: Double): Double {
        checkDivisionByZero(secondOperand)
        return firstOperand / secondOperand
    }

    private fun checkDivisionByZero(denominator: Number) {
        require(denominator.toDouble() != 0.0) { "Dividing by Zero" }
    }
}