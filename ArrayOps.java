public class ArrayOps {
    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,6};
        int[] arr1 = {2,8,3,7,8};
        System.out.println(findMissingInt(arr));
        System.out.println(secondMaxValue(arr));
        System.out.println(secondMaxValue(arr1));
        System.out.println(containsTheSameElements(new int[] {1, 2, 1, 1, 2}, new int[] {2, 1}));
        System.out.println(containsTheSameElements(new int[] {2, 2, 3, 7, 8, 3, 2}, new int[] {8, 2, 7, 7, 3}));
        System.out.println(containsTheSameElements(new int[] {1, 2, 3}, new int[] {1, 2, 3}));
        System.out.println(containsTheSameElements(new int[] {3, -4, 1, 2, 5}, new int[] {1, 3, -4, 5}));
        System.out.println(containsTheSameElements(new int[] {3,1}, new int[] {1, 3, -4, 5}));
        System.out.println(isSorted(new int[] {7, 5, 4, 3, -12}));
        System.out.println(isSorted(new int[] {1, 2, 3}));
        System.out.println(isSorted(new int[] {1, -2, 3}));
        System.out.println(isSorted(new int[] {1, 1, 500}));
        System.out.println(isSorted(new int[] {1, 3, 2}));
        System.out.println(isSorted(new int[] {7,8,11,5,7,8}));


    }

    public static int findMissingInt (int [] array) {
        int N = array.length;
        int missing = 0;
        for  (int i =0 ; i<N+1 ; i++) {
            boolean found = false;
            for (int j = 0; j < N; j++) {
                if (array[j] == i) {
                found = true;
                }
                if (found == true){
                    break;
                }
            }
            if (found == false){
                missing = i;
                break;
            }
        }

        return missing;
    }

    public static int secondMaxValue(int [] array) {
        int max = array[0];
        int secondMax = array[0];
        int indexMax = 0;
        for(int i = 0; i< array.length; i++){
            if (array[i] > max){
                max = array[i];
                indexMax = i;
            }
        }
        for(int i = 0; i< array.length; i++) {
            if(array[i] > secondMax && array[i] <= max && indexMax != i){
                secondMax = array[i];
            }
        }
        return secondMax;
    }

    public static boolean containsTheSameElements(int [] array1,int [] array2) {
        boolean contains = true;
        int max = Math.max(array1.length, array2.length);
        int min = Math.min(array1.length, array2.length);
        if(max == array1.length){
            for(int i = 0; i < max; i++){
                if (!contains){
                    return false;
                }
                 contains = false;
                for (int j=0 ; j<min ; j++){
                    if(array1[i] == array2[j]){
                        contains = true;
                        break;
                    }
                }
            }
        } else {
            for(int i = 0; i<max; i++){
                if (!contains){
                    return false;
                }
                 contains = false;
                for (int j=0 ; j<min ; j++){
                    if (array2[i] == array1[j]){
                        contains =true;
                        break;
                    }
                }
            }
        }
        return contains;
    }

    public static boolean isSorted(int [] array) {
        boolean isSorted = false;
        for (int i = 1; i < array.length; i++) {
            isSorted =false;
            if (array[i] >= array[i - 1]) {
                isSorted = true;
            } else {
                break;
            }
        }
        if (!isSorted) {
            for (int i = 1; i < array.length; i++) {
                isSorted = false;
                if (array[i] <= array[i - 1]) {
                    isSorted = true;
                } else {
                    break;
                }
            }
        }
        return isSorted;
    }

}
