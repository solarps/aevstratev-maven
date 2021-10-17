package HW12;

import java.util.Objects;

public class StringCollectionImp implements StringCollection {
    private String[] arr = new String[0];

    @Override
    public String get(int index) {
        try {
            return arr[index];
        }catch (IndexOutOfBoundsException exception){
            return "Index out of bounds";
        }

    }

    @Override
    public boolean add(String str) {
        String[] newArr = new String[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        newArr[newArr.length - 1] = str;
        this.arr = newArr;
        return true;
    }

    @Override
    public boolean add(int index, String str) {
        if (index > arr.length) return false;
        String[] firstArr = new String[index];
        String[] secondArr = new String[arr.length - index];
        String[] newArr = new String[arr.length + 1];
        for (int i = 0; i < firstArr.length; i++) {
            firstArr[i] = arr[i];
        }
        for (int i = 0; i < secondArr.length; i++) {
            secondArr[i] = arr[i + index];
        }
        for (int i = 0; i < newArr.length; i++) {
            if (i < firstArr.length) newArr[i] = firstArr[i];
            if (i == firstArr.length) newArr[i] = str;
            if (i > firstArr.length) newArr[i] = secondArr[i - firstArr.length - 1];
        }
        this.arr = newArr;
        return true;
    }

    @Override
    public boolean delete(String str) {
        boolean isExist = false;
        for (int i = 0; i < arr.length; i++) {
            if (Objects.equals(arr[i], str)) {
                isExist = true;
                break;
            }
        }
        if (isExist) {
            String[] tempArr = arr;
            String[] newArr = new String[tempArr.length - 1];
            if (arr.length == 1) {
                clear();
                return true;
            }
            if (!Objects.equals(tempArr[tempArr.length - 1],str)) {
                for (int i = 0; i < newArr.length; i++) {
                    newArr[i] = tempArr[i];
                    if (Objects.equals(tempArr[i], str)) {
                        for (int j = i; j < newArr.length; j++) {
                                newArr[j] = tempArr[j + 1];
                            }
                    }
                }
            } else {
                for (int i = 0; i < newArr.length; i++) {
                    newArr[i] = tempArr[i];
                }
            }
            this.arr = newArr;
            return true;
        } else return false;
    }

    @Override
    public boolean contains(String str) {
        for (String string : arr) {
            if (Objects.equals(string, str)) return true;
        }
        return false;
    }

    @Override
    public boolean equals(StringCollection collection) {
        if (collection.size() == size()) {
            for (int i = 0; i < arr.length; i++) {
                if (!Objects.equals(arr[i], collection.get(i))) return false;
            }
            return true;
        } else return false;
    }

    @Override
    public boolean clear() {
        arr = new String[0];
        return true;
    }

    @Override
    public int size() {
        return arr.length;
    }
}
