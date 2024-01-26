from collections import deque

N, M = map(int, input().split())

extract_nums = deque(map(int, input().split()))
nums = deque(i + 1 for i in range(N))
count = 0

while extract_nums:
    if nums[0] == extract_nums[0]:
        nums.popleft()
        extract_nums.popleft()
    else:
        if nums.index(extract_nums[0]) <= len(nums) // 2:
            nums.rotate(-1)
            count += 1
        else:
            nums.rotate(1)
            count += 1

print(count)