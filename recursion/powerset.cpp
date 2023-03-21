#include <stdio.h>

// powerset(멱집합) : 어떤 집합의 모든 부분집합의 집합
// 원소의 갯수가 n개인 집합의 모든 가능한 집합의 갯수 : 2^n개

// powerset 함수는 여러 개의 집합들을 return해야 한다.
//  함수가 두개의 집합을 매개변수로 받도록 설계해야한다.

// 집합 s와 p를 설계
char data[] = {'a', 'b', 'c', 'd', 'e', 'f'};
// 집합 s는 data[k],...,data[n-1]이고 집합 p는 include[i] = true 인 원소들이다.
bool include[8] = {false, false, false, false, false, false, false, false};
int n = sizeof(data) / sizeof(data[0]);

void powerset(int k)
{
    if (k == n)
    {
        for (int i = 0; i < n; i++)
            if (include[i])
                printf("%c ", data[i]);
        printf("\n");
        return;
    }
    // data[k]를 포함하지 않는 집합의 부분 집합을 출력
    include[k] = false;
    powerset(k + 1);
    // data[k]를 포함하는 집합의 부분 집합을 출력
    include[k] = true;
    powerset(k + 1);

    // 처음 이 함수를 호출할 때는  powerset(0)로 호출한다. 즉 p는 공집합이고 s는 전체집합이다.
}

int main()
{
    powerset(0);
}

// 상태공간트리에 대한 개념...
