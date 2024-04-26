def count_positives_sum_negatives(arr):
    lst = []

    if not arr: return []

    positive = 0
    negative = 0

    for element in arr:
        if element > 0:
            positive += 1
        else:
            negative += element

    lst.append(positive)
    lst.append(negative)

    return lst
    # return [len([x for x in arr if x > 0])] + [sum(y for y in arr if y < 0)] if arr else []
    # return [sum(n > 0 for n in arr), sum(n for n in arr if n < 0)] if arr else []

arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14, -15]

print(count_positives_sum_negatives(arr))