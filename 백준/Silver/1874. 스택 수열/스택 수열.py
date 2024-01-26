def check_stack(data):
    stack = []
    result = []
    oper = []
    count = 0
    sorted_data = sorted(data)
    for i in sorted_data:
        stack.append(i)
        oper.append("+")
        for j in range(len(stack)):
            if stack[-1] == data[count]:
                oper.append('-')
                count += 1
                result.append(stack.pop())


    if result == data:
        return '\n'.join(oper)
    else:
        return "NO"

n = int(input())
data = [int(input()) for _ in range(n)]

result = check_stack(data)
print(result)