# N-Queens
# 1)같은 행에는 한개의 queen만 올 수 있다.
# 2)같은 열에는 한개의 queen만 올 수 있다.

# i열에 배치한 퀸의 위치가 j행에 있다면, pos[i]의 값을 j로 한다.
# ex) pos[0] = 0 : 0열에 위치한 queen은 0행에 있다.

# set()함수를 정의해보자.
# set() : pos[i]에 0~7까지의 값을 차례로 대입하여 i열에 퀸을 1개만 배치하는 8가지의 조합을 만드는 재귀함수이다.


# 우선 위의 상황을 나타내보자.

pos = [0]*8  # 각 열에서 퀸의 위치
flag_row = [False]*8  # 각 행에 퀸을 배치했는지 체크
flag_diagonal1 = [False]*15
flag_fdiagonal2 = [False]*15
# 함수의 반환값이 없을때 ->none
put_count = 0


'''이 수정된 코드에서는 0으로 초기화되는 새 변수 put_count를 추가하고 함수
    내에서 액세스하고 수정할 수 있도록 put() 함수 내부에 전역 변수로 선언했습니다.
    put() 함수가 호출될 때마다 put_count를 증가시킵니다.
    set(0) 함수 호출 후 put_count 값을 출력하여 put() 함수가 실행된 횟수를 얻습니다.'''


def put() -> None:
    """각열에 배치한 퀸의 위치를 출력"""
    global put_count
    put_count += 1
    for i in range(8):
        print(f'{pos[i]:2}', end='')

    print()


def set(i: int) -> None:
    """i열에 퀸을 배치"""
    for j in range(8):
        if (not flag_row[j]
                and not flag_diagonal1[i+j]
                and not flag_fdiagonal2[i-j+7]):  # j행에 퀸을 배치하지 않았으면
            pos[i] = j
            if i == 7:
                put()
            else:
                flag_row[j] = flag_diagonal1[i +
                                             j] = flag_fdiagonal2[i-j+7] = True  # j행에 queen을 배치했다면
                set(i+1)
                flag_row[j] = flag_diagonal1[i +
                                             j] = flag_fdiagonal2[i-j+7] = False


"""0열에 퀸을 배치하였을때 나올 수 있는 모든 경우의 수 출력"""
set(0)
print(put_count)
