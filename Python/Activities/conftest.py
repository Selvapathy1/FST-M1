import pytest

@pytest.fixture
def num_list():
    return list (range(11))


#activity 24fixture
@pytest.fixture
def wallet_amount():
    amount = 0
    return amount