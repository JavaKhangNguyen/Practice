function performOperation(operands, operators){
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

function evalRPN(A){
    let operands = [];
    let operator = [];
    for(let i = 0; i < A.length; i++){
        const token = A[i];
        if(!isNaN(token)) {
            operands.push(parseInt(token));
        }
        else {
            operator.push(token);
            performOperation(operands, operator);
        }
    }

    return Math.floor(operands.pop())
}
