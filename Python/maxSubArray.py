import random
def maxSubArray(A):
    if not isinstance(A, list) or len(A) == 0:
        return []
    
    current_sum = A[0]
    max_sum = A[0]
    start = end = 0
    temp_start = 0

    for i in range(1, len(A)):
        if A[i] > current_sum + A[i]:
            current_sum = A[i]
            temp_start = i
        else:
            current_sum += A[i]

        if current_sum > max_sum:
            max_sum = current_sum
            start = temp_start
            end = i

    return A[start:end + 1]


large_array = [random.randint(-1000, 1000) for _ in range(10**6)]
result = maxSubArray(large_array)
print(f"Max Subarray Sum: {sum(result)}")  
print(f"Max Subarray Length: {len(result)}")
print(f"First 10 elements: {result[:10]}")
