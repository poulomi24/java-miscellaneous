package com.sorting;

public class BubbleSort {
    public static void swap(int[] array, int i, int j)
    {
        if(i==j)
            return;
        int temp = 0;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] intArray = {20,35,-15,7,55,1,-22};
        for(int i = intArray.length-1;i>0;--i) //i = lastUnsortedIndex... evaluation will start from the last index
        {
            for(int j=0;j<i;++j)
            {
                if(intArray[j]>intArray[j+1])
                    swap(intArray,j,j+1);
            }
        }

        for(int i=0;i< intArray.length;++i)
        {
            System.out.println(intArray[i]);
        }
    }
}
