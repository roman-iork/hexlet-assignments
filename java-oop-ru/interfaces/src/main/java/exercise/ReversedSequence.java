package exercise;

// BEGIN
public class ReversedSequence implements CharSequence {

    private String sequence;

    public ReversedSequence(String sequence) {
        String reversedSequence = "";
        for (int i = sequence.length() - 1; i >= 0; i--) {
            reversedSequence += sequence.charAt(i);
        }
        this.sequence = reversedSequence;
    }

    public char charAt(int index) {
        return sequence.charAt(index);
    }

    public CharSequence subSequence(int start, int end) {
        return sequence.subSequence(start, end);
    }

    public int length() {
        return sequence.length();
    }

    public String toString() {
        return sequence;
    }
}
// END
