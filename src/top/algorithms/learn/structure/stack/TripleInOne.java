package top.algorithms.learn.structure.stack;

/**
 * @author jrl
 * @date Create in 17:54 2022/9/14
 */
public class TripleInOne {

    // 下一个要被插入的位置
    int p0;
    int p1;
    int p2;
    int[] arr;
    int stackSize;

    public TripleInOne(int stackSize) {
        arr = new int[stackSize * 3];
        p0 = 0;
        p1 = stackSize;
        p2 = stackSize * 2;
        this.stackSize = stackSize;
    }

    public void push(int stackNum, int value) {
        int p = -1;
        switch (stackNum) {
            case 0:
                if (p0 < stackSize) {
                    p = p0++;
                }
                break;
            case 1:
                if (p1 < stackSize * 2) {
                    p = p1++;
                }
                break;
            case 2:
                if (p2 < stackSize * 3) {
                    p = p2++;
                }
                break;
        }
        if (p >= 0) {
            arr[p] = value;
        }
    }

    public int pop(int stackNum) {
        int p = -1;
        switch (stackNum) {
            case 0:
                if (p0 > 0)
                    p = --p0;
                break;
            case 1:
                if (p1 > stackSize)
                    p = --p1;
                break;
            case 2:
                if (p2 > stackSize * 2)
                    p = --p2;
                break;
        }
        if (p >= 0) {
            return arr[p];
        } else {
            return -1;
        }

    }

    public int peek(int stackNum) {
        int p = -1;
        switch (stackNum) {
            case 0:
                p = p0 - 1;
                if (p == -1)
                    return -1;
                break;
            case 1:
                p = p1 - 1;
                if (p == stackSize - 1)
                    return -1;
                break;
            case 2:
                p = p2 - 1;
                if (p == stackSize * 2 - 1)
                    return -1;
                break;
        }
        if (p != -1) {
            return arr[p];
        } else {
            return -1;
        }
    }

    public boolean isEmpty(int stackNum) {

        switch (stackNum) {
            case 0:
                if (p0 == 0) {
                    return true;
                } else {
                    break;
                }

            case 1:
                if (p1 == stackSize) {
                    return true;
                } else {
                    break;
                }

            case 2:
                if (p2 == stackSize * 2) {
                    return true;
                } else {
                    break;
                }

        }
        return false;
    }

/**
 * Your TripleInOne object will be instantiated and called as such:
 * TripleInOne obj = new TripleInOne(stackSize);
 * obj.push(stackNum,value);
 * int param_2 = obj.pop(stackNum);
 * int param_3 = obj.peek(stackNum);
 * boolean param_4 = obj.isEmpty(stackNum);
 */
}