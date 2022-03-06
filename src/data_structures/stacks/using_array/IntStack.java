package data_structures.stacks.using_array;

import java.util.Arrays;

public class IntStack {
    int max;    // 스택 용량 (스택에 쌓을 수 있는 최대의 데이터 수)
    int ptr;    // 스택 포인터 (스택에 쌓여있는 데이터 수)
    int[] stk;  // 스택의 본체

    // 스택이 비어있을 시 예외
    public class EmptyIntStackException extends RuntimeException{
        public EmptyIntStackException(){
        }
    }

    // 스택이 가득 찼을때 예외
    public class OverflowIntStackException extends RuntimeException{
        public OverflowIntStackException(){
        }
    }

    public IntStack(int capacity){
        ptr = 0;
        max = capacity;
        try{
            stk = new int[max]; // 스택 본체 배열 생성
        } catch (OutOfMemoryError e){   // 생성 할 수 없음
            max = 0;
        }
    }

    // push method
    public int push(int x) throws OverflowIntStackException{
        if (ptr >= max) throw new OverflowIntStackException();
        return stk[ptr++] = x;
    }

    // pop method
    public int pop() throws EmptyIntStackException{
        if (ptr <= 0) throw new EmptyIntStackException();
        return stk[--ptr];
    }

    // peek method : 스택의 꼭대기에 있는 데이터 몰레 엿보는 메소드
    public int peek() throws EmptyIntStackException{
        if (ptr <= 0) throw new EmptyIntStackException();
        return stk[ptr-1];
    }
    // indexOf method : 검색 메소드. stk에 x와 같은 값 포함 되어있는지, 포함되어 있따면 배열 어디에 들어있는지 조사
    public int indexOf(int x){
        for (int i = 0; i <= ptr -1; i ++){
            if (stk[i]==x) return i;
        }
        return -1; //검색 실패
    }

    // clear method : 모든 요소 삭제하는 메소드
    /* stack의 push와 pop은 stack pointer(ptr)를 바탕으로 이루어 지기 때문에 배열 요소의 값을 변경할 필요가 없다.
    * 그냥 ptr값을 0으로 초기화 시켜 주면 된다.*/
    public void clear(){
        ptr = 0;
    }

    // capacity method : 스택의 용량값(max)를 반환하는 메소드
    public int capacity(){
        return max;
    }

    // size method : 데이터 수 확인
    public int size(){
        return ptr;
    }

    // isEmpty method : 스택이 비어있는지 검사
    public boolean isEmpty(){
        return ptr <= 0;
    }
    // isFull method : 스택이 가득찼는지 검사
    public boolean isFull(){
        return ptr >= max;
    }
    // dump method : stack안의 모든 데이터를 표시.
    public void dump(){
        if (ptr <= 0) System.out.println("Stack is empty");
        else {
            System.out.print("[ ");
            for (int i = 0; i < ptr ; i++) {
                System.out.print(stk[i] + " ");
            }
            System.out.print("]");
        }
    }
}

