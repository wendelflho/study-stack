def sum_array(arr):
    if (arr == None or len(arr) < 3):
        return 0
    
    return (sum(arr) - max(arr) - min(arr))

arr = [ 6, 2, 1, 8, 10 ]

print(sum_array(arr))