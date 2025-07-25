def heapify(A, k, n):
    largest = k
    left = 2 * k + 1
    right = 2 * k + 2
    
    if left < n and A[left] > A[largest]:
        largest = left
    if right < n and A[right] > A[largest]:
        largest = right
    if largest != k:
        A[k], A[largest] = A[largest], A[k]
        heapify(A, largest, n)
        
def heap_sort(A):
    n = len(A)
    for i in range((n - 2) // 2, -1, -1):
        heapify(A, i, n)
    for i in range(n - 1, 0, -1):
        A[0], A[i] = A[i], A[0]
        heapify(A, 0, i)

# N개의 수 입력 받기
n = int(input())
A = [int(input()) for _ in range(n)]

# 힙 정렬 실행
heap_sort(A)

# 정렬된 결과 출력
for num in A:
    print(num)