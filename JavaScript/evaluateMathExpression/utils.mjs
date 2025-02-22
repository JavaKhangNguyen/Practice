export class Stack {
    constructor() {
      this.stack = [];
    }
  
    push(item) {
      return this.stack.push(item);
    }
  
    pop() {
      return this.stack.pop();
    }
  
    peek() {
      return this.stack[this.length - 1];
    }
  
    get length() {
      return this.stack.length;
    }
  
    isEmpty() {
      return this.length === 0;
    }
}

export function stackExpression(exp){
  // Before initialize stack, check the validity of the expression 
    const isExpValid = validateExpression(exp)
    if(!isExpValid.valid) {
      return isExpValid.value;
    }

    else if (isExpValid.valid) {
      if(typeof exp === 'number'){
        return exp;
      }
      else {
        const expArr = exp.match(/\d+(\.\d+)?|[+\-*/()]/g)
        const expStack = new Stack();
  
        // Push in reverse so the stack represent the expression from left to right
        for (let i = expArr.length - 1; i >= 0; i--) {
            expStack.push(expArr[i]);
        }
        return expStack
      }
    }
}

export function checkParentheses(exp) {
  let openCount = 0;

  // Invalid chars check
  if (/[^0-9.+\-*/%() ]/.test(exp)) {
    return false;
  }

  // Incomplete expressions (missing operators) check
  if (exp.includes('  ')) {
      return false;
  }

  // Check first char should not be the closing parenthesis
  if (exp[0] === ')') {
      return false;
  }

  for (const char of exp) {
      if (char === '(') {
          openCount++;
      }
      else if (char === ')') {
          if (openCount > 0) {
            openCount--;//This means a pair of parenthesis is found
          }
      }
  }

  // If this check is not zero means there is a redundant open parenthesis
  return openCount === 0;
}

export function validateExpression(exp){
  if (typeof exp !== 'string') {
    return typeof exp === 'number' ? 
    {valid: true, value: exp} : { valid: false, value: 'Data type not supported!' };
  }
  if (!checkParentheses(exp)) {
    return { valid: false, value: 'Invalid expression!' };
  }
  return { valid: true, value: exp};
}

export function performOperation(operands, operators){
    const operator = operators.pop();
    const b = operands.pop();
    const a = operands.pop();
    
    switch(operator) {
        case '+':
          operands.push(a + b);
          break;
        case '-':
          operands.push(a - b);
          break;
        case '*':
          operands.push(a * b);
          break;
        case '/':
          if (b === 0){
            throw new Error('Invalid division by zero detected!');
          }
            operands.push(a / b);
            break;
    }
}