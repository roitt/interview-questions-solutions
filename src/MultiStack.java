/**
 * Created by rbhoompally on 1/4/18.
 */
public class MultiStack {
    private int[] stackSizes;
    private int[] stackArray;
    private int[] sizes;
    private int numberOfStacks;

    MultiStack(int numberOfStacks) {
        sizes = new int[numberOfStacks];
        stackSizes = new int[numberOfStacks];

        int initialSize = 10;
        stackArray = new int[initialSize * numberOfStacks];
        this.numberOfStacks = numberOfStacks;

        for (int i = 0; i < numberOfStacks; i++) {
            sizes[i] = -1;
            stackSizes[i] = 10;
        }
    }

    public boolean isEmpty(int stack) {
        return sizes[stack] == -1;
    }

    public int pop(int stack) {
        if (sizes[stack] == -1) {
            System.out.print("Empty stack exception\n");
            return -1;
        }

        int top = stack * stackSizes[stack] + sizes[stack];
        int ret = stackArray[top];
        stackArray[top] = 0;
        sizes[stack] -= 1;
        return ret;
    }

    public void push(int stack, int value) {
        int stackMax = getStackLimitInArray(stack);
        if (getStackTop(stack) != -1 && getStackTop(stack) == stackMax) {
            resizeStack(stack);
        }

        int top = getStackTop(stack);
        stackArray[++top] = value;
        sizes[stack] += 1;
    }

    private int getStackTop(int stack) {
        return  getStackStart(stack) + sizes[stack];
    }

    private int getStackStart(int stack) {
        int stackStart = 0;
        for (int i = 0; i < stack; i++) {
            stackStart += stackSizes[i];
        }
        return stackStart;
    }

    private int getStackLimitInArray(int stack) {
        int maxPos = 0;
        for (int i = 0; i <= stack; i++) {
            maxPos += stackSizes[i];
        }
        return maxPos - 1;
    }

    public int getStackSize() {
        return stackArray.length;
    }

    public int[] getStackArray() {
        return stackArray;
    }

    private void resizeStack(int stack) {
        int oldStackSize = stackSizes[stack];
        int[] newArray = new int[getStackSize() + oldStackSize];

        for (int j = 0; j < numberOfStacks; j++) {
            for (int i = getStackStart(j); i < getStackStart(j) + stackSizes[j]; i++) {
                newArray[i] = stackArray[i];
            }
        }

        stackSizes[stack] *= 2;
        stackArray = newArray;

//        for (int i = 0; i < numberOfStacks; i++) {
//            for (int j = 0; j < oldStackSize; j++) {
//                int newStackPos = i * 2 * oldStackSize + j;
//                newArray[newStackPos] = stackArray[(i * oldStackSize) + j];
//            }
//        }
//
//        stackArray = newArray;
    }
}
