import { Stack, performOperation, stackExpression } from "./utils.mjs";

// Javascript built-in utility for evaluation
function evaluationExpressionMethodOne(exp) {
   return eval(exp) 
}

// Traditional algorithm - using Stack data structure
function evaluationExpressionMethodTwo(exp) {
    //Initialize stacks for expressions, waiting operators and operands
    const expStack = stackExpression(exp);
    const operators = new Stack();
    const operands = new Stack();
    const precedence = {'+': 1, '-': 1, '*': 2, '/': 2}
    
    // Process the expression 
    try { // Because the performOperation check for division by 0, wrap in trycatch to safely handle exceptions
        
        // Recheck expStack. Because it validates expression before stacking, if type is not Stack then the expression is invalid already
        if(typeof expStack === 'number' || typeof expStack === 'string') {
            return expStack
        }

        // Main processing
        while (!expStack.isEmpty()) {
            const token = expStack.pop();
            
            if (!isNaN(token)) {
                operands.push(parseFloat(token));
            }
            else if (token === '(') {// Check for presence of parenthesis - priority expression
                operators.push(token);
            }
            else if (token === ')') {// Ends priority expression, check if next priority expression presents, then perform the calculation
                while (!operators.isEmpty() && operators.peek() !== '(') {
                    performOperation(operands, operators);
                }
                operators.pop(); 
            }
            else { // Check remaining operators and their precedence
                while (!operators.isEmpty() && operators.peek() !== '(' && precedence[operators.peek()] >= precedence[token]) {
                    performOperation(operands, operators);
                }
                operators.push(token);
            }
        }
        
        // Last step with the remaining operators and operands
        while (!operators.isEmpty()) {
            performOperation(operands, operators);
        }
        
        return operands.pop();
    } 
    catch (error) {
        return error.message
    }                                                                 
}


// Test cases
console.log(evaluationExpressionMethodTwo("9 + 9 + 5 * 2 * 3 + 5 - 2 / 0")) // Division by zero exception
console.log(evaluationExpressionMethodTwo("9 + 9 + 5 * 2 * 3 + 5 - 2")) // 51
console.log(evaluationExpressionMethodTwo("(9 + 9 + 5) * 2 * 3 + 5 - 2")) // 141
console.log(evaluationExpressionMethodTwo("9 + 9 + (5) * 2) * 3 + 5 - 2")) // 87
console.log(evaluationExpressionMethodTwo("(9 + 9 + 5) * 2 * (3 + 5 - 2)")) // 276
console.log(evaluationExpressionMethodTwo("9 + (9 + 5) * 2 * 3 + 5 - 2")) // 96
console.log(evaluationExpressionMethodTwo("9.5 + 9 + 5 * (2 * 3 + 5.5) - 2")) // 74
console.log(evaluationExpressionMethodTwo("9.5 + 9 + 5 * 2 * (3 + 5 - 2)")) // 78.5
console.log(evaluationExpressionMethodTwo("9 + 9 + 5) * 2) * 3 + 5 - 2")) // 141
console.log(evaluationExpressionMethodTwo((9 + 9 + 5) * 2 * 3 + 5 - 2)) // 141

// Cases of invalid expression
console.log(evaluationExpressionMethodTwo("(9 + 9 + (5 * 2 * 3 + 5 - 2"))
console.log(evaluationExpressionMethodTwo(")9 + 9 + (5 * 2 * 3 + 5 - 2"))
console.log(evaluationExpressionMethodTwo("9 + 9 + (5 * 2 * 3 + 5 - 2"))
console.log(evaluationExpressionMethodTwo("(9 + 9 + 5 * 2 * 3 + 5 - 2"))
console.log(evaluationExpressionMethodTwo("(9 + 9 5 * 2 * 3 + 5 - 2"))
console.log(evaluationExpressionMethodTwo("a + 9 + (5 * 2 * 3 + 5 - 2"))
console.log(evaluationExpressionMethodTwo("9 + [ + (5 * 2 * 3 + 5 - 2"))
console.log(evaluationExpressionMethodTwo("9 + 9 + ({ * 2 * 3 + 5 - 2"))
console.log(evaluationExpressionMethodTwo("] + 9 + (5 * 2 * 3 + 5 - 2"))
console.log(evaluationExpressionMethodTwo("9 + 9 + ({ * 2 * 3 + 5 - 2"))
console.log(evaluationExpressionMethodTwo("9 + 9 + (5 * 2 * 3 + 5 - 2}"))
