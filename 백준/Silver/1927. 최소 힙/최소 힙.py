import heapq
import sys

def input():
    return sys.stdin.readline().strip()


N = int(input())
lst = []
heapq.heapify(lst)
for _ in range(N):
    x = int(input())
    if x == 0:
        if len(lst) > 0:
            print(heapq.heappop(lst))
        else:
            print(0)
    else:
        heapq.heappush(lst, x)
