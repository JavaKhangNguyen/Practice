import sympy
def isPrime(n):
    if n <= 1:
        return False
    else:
        is_prime = True
        for i in range(2, int(n**0.5) + 1):
            if n % i == 0:
                is_prime = False
                break
        return is_prime

def isPerfectNumberMethod1(n):
    if not isinstance(n, int):
        return ValueError('n phải là số nguyên')
    
    if n <= 1:
        return False
    
    p = 2
    while True:
        possible_perfect = (2**(p-1)) * ((2**p) - 1)
        if possible_perfect > n:
            return False
        if possible_perfect == n:
            return sympy.isprime(p) and sympy.isprime((2**p) - 1)  
        p += 1


def isPerfectNumberMethod2(n):
    if not isinstance(n, int):
        return ValueError('n phải là số nguyên')
    
    if n <= 1:
        return False
     
    sum = 1
    for i in range(2, int(n**0.5) + 1):
        if n % i == 0:
            sum += i
            if i != n // i:
                sum += n // i
    return sum == n