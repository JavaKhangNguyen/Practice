def balanced_parenthesis(A):
    stack = []
    opening_brackets = "({["
    closing_brackets = ")}]"
    bracket_pairs = {')': '(', '}': '{', ']': '['}
    
    for char in A:
        if char in opening_brackets:
            stack.append(char)
        elif char in closing_brackets:
            if not stack or stack[-1] != bracket_pairs[char]:
                return False
            stack.pop()
    
    return len(stack) == 0


print(balanced_parenthesis("[[[]]]"))  
print(balanced_parenthesis("{[()]}"))  
print(balanced_parenthesis("({[}])"))  
print(balanced_parenthesis("["))  