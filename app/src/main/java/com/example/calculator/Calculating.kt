package com.example.calculator

class Calculating {

    companion object {

        private fun replaceWith(expr: String, rgx: Regex, operation: Char) : String
        {
            var replacedExpr = expr
            var toFind = rgx.find(replacedExpr)?.value
            while (toFind != null)
            {
                var calc = toFind.slice(0 until toFind.lastIndexOf(operation)).toFloat()
                if (operation != '/')
                {
                    if (toFind.last() == '%')
                    {
                        if (operation == '+') calc += toFind.slice(toFind.lastIndexOf(operation) + 1 until toFind.length - 1).toFloat()/100 * calc
                        if (operation == '-') calc -= toFind.slice(toFind.lastIndexOf(operation) + 1 until toFind.length - 1).toFloat()/100 * calc
                        if (operation == '*') calc *= toFind.slice(toFind.lastIndexOf(operation) + 1 until toFind.length - 1).toFloat()/100
                    }
                    else {
                        if (operation == '+') calc += toFind.slice(toFind.lastIndexOf(operation) + 1 until toFind.length).toFloat()
                        if (operation == '-') calc -= toFind.slice(toFind.lastIndexOf(operation) + 1 until toFind.length).toFloat()
                        if (operation == '*') calc *= toFind.slice(toFind.lastIndexOf(operation) + 1 until toFind.length).toFloat()
                    }
                }
                else
                {
                    if (toFind.last() == '%')
                    {
                        if (toFind.slice(toFind.lastIndexOf(operation) + 1 until toFind.length-1).toFloat() != 0.0f)
                        {
                            calc /= toFind.slice(toFind.lastIndexOf(operation) + 1 until toFind.length-1).toFloat()/100
                        }
                        else return ""
                    }
                    else
                    {
                        if (toFind.slice(toFind.lastIndexOf(operation) + 1 until toFind.length).toFloat() != 0.0f)
                        {
                            calc /= toFind.slice(toFind.lastIndexOf(operation) + 1 until toFind.length).toFloat()
                        }
                        else return ""
                    }
                }

                replacedExpr = replacedExpr.replaceFirst(toFind, calc.toString())
                toFind = rgx.find(replacedExpr)?.value
            }
            return replacedExpr
        }

        fun calculate(expr: String) : String
        {
            var expr = expr
            var answer = "Error"

            if (Regex("^-?[0-9]+([+\\-*/.][0-9]+%?)*$").find(expr)?.value == expr)
            {

                expr = replaceWith(expr, Regex("-?[0-9]+(\\.[0-9]+)?\\*[0-9]+(\\.[0-9]+)?%?"), '*')

                expr = replaceWith(expr, Regex("-?[0-9]+(\\.[0-9]+)?/[0-9]+(\\.[0-9]+)?%?"), '/')

                expr = replaceWith(expr, Regex("-?[0-9]+(\\.[0-9]+)?\\-[0-9]+(\\.[0-9]+)?%?"), '-')

                expr = replaceWith(expr, Regex("-?[0-9]+(\\.[0-9]+)?\\+[0-9]+(\\.[0-9]+)?%?"), '+')

                if (expr.indexOf('.') < 0) return answer
                else if (((expr[expr.indexOf('.') + 1]) == '0') and (expr.length - expr.indexOf('.') <= 2)) answer = expr.toFloat().toInt().toString()
                else answer = expr
            }
            return answer
        }
    }
}