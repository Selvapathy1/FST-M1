import pytest

def test_sum(num_list):
    sum = 0
    for num in num_list:    
        sum += num
    # Assertion
    assert sum  == 55