import math
import random


def simulator(n):
    n_in_a_circle = 0
    for i in range(n):
        # random.().random(): (0, 1)
        x = random.random()
        y = random.random()
        if math.sqrt(x*x + y*y) < 1:
            n_in_a_circle += 1
    return n_in_a_circle


def compute_pi(n_in_a_circle, n_in_a_square):
    return 4 * n_in_a_circle / n_in_a_square

if __name__ == '__main__':
    n = 7000000
    m = simulator(n)
    pi = 4 * m / n
    print(pi)

