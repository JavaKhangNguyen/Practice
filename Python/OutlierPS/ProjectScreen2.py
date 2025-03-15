def sieve(limit):
    if limit < 2:
        return []
    
    if limit == 2:
        return [2]
    
    is_prime = [True] * (limit + 1)
    is_prime[0] = is_prime[1] = False
    
    res = []
    
    for i in range(2, limit + 1):
        if is_prime[i]:
            res.append(i)
        
        j = 0
        while j < len(res) and i * res[j] <= limit:
            is_prime[i * res[j]] = False
            if i % res[j] == 0:
                break
            j += 1
    
    return res


def pick_prime(primes, min_size=1000):
    """returns a suitable prime to use as modulus"""
    for prime in primes:
        if prime >= min_size:
            return prime
        
    return primes[-1] if primes else 1
    

def hash(string, modulus):
    """implements polynomial rolling of string keys"""
    hash_value = 5381
    for char in string:
        # hash = 33 XOR ord(c)
        hash_value = ((hash_value << 5) + hash_value) ^ ord(char)
    return hash_value % modulus


if __name__ == '__main__':
    # generate primes list to use as modulus
    primes = sieve(10000) # modify limit based on your needs
    modulus = pick_prime(primes, 1000)
    test_array = ["alpha","beta","gamma","delta","epsilon"]

    for string in test_array:
        hash_value = hash(string, modulus)
        print(f"Hash of {string} is {hash_value}")
