function balancedParenthesis(A){
    let paren_arr = A.split('');
    let openCount = 0;
    let closeCount = 0;
    for (let i = 0; i < paren_arr.length; i++) {
        if (paren_arr[i] === '(') {
            openCount++;
        }
        if (paren_arr[i] === ')') {
            closeCount++;
        }
    }
    if (openCount === closeCount && paren_arr[0] === '(' && paren_arr[paren_arr.length - 1] === ')') {
        return 1;
    } 
    else {
        return 0;
    }
}