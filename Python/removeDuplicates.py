def removeDuplicates(numList):
    if(len(numList) == 0):
        return ValueError("List is empty")
    
    counts = {}
    removed = []
    max_count = 0
    max_elems = []

    for val in numList:
        if val not in counts:
            counts[val] = 0
            removed.append(val)

        counts[val] += 1

        # Track maximum count and update max elements
        if counts[val] > max_count:
            max_count = counts[val]
            max_elems = [val]
        elif counts[val] == max_count:
            max_elems.append(val)

    return {
        "maxOccurElements": max_elems,
        "maxTimeOccur": max_count,
        "removedDuplicates": removed
    }


result = removeDuplicates([11, 11, 15, 15, 15, 13, 16, 13, 16, 11])
# result = removeDuplicates([])
if(type(result) != ValueError):
    print("Element(s) duplicated the most: ", result["maxOccurElements"])
    print("Number of times the most duplicated elements appear: ", result["maxTimeOccur"])
    print("Final array after removing duplicates: ", result["removedDuplicates"])
else:
    print(result)