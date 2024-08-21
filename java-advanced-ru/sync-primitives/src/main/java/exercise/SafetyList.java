package exercise;

class SafetyList {
    // BEGIN
    private Integer[] intArray = new Integer[]{};

    public synchronized void add(int number) {
        var currentSize = intArray.length;
        var newIntArray = new Integer[currentSize + 1];
        for (var i = 0; i < currentSize; i++) {
            newIntArray[i] = intArray[i];
        }
        newIntArray[currentSize] = number;
        intArray = newIntArray;
    }

    public Integer get(int index) {
        if (index >= intArray.length) {
            return null;
        }
        return intArray[index];
    }

    public int getSize() {
        return intArray.length;
    }
    // END
}
