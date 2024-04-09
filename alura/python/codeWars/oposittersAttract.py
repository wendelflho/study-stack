def love_func( flower1, flower2 ):
    if ( is_odd(flower1) and is_even(flower2)
            or is_odd(flower2) and is_even(flower1) ):
        return True
    else:
        return False

def is_odd( number ):
    return True if number % 2 != 0 else False

def is_even( number ):
    return True if number % 2 == 0 else False

def lovefunc( flower1, flower2 ):
    return bool((flower1+flower2) % 2)

# print(love_func(2, 2))
print(lovefunc(10, 5))