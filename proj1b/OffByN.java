public class OffByN implements CharacterComparator {
    int offset;
    public OffByN(int n) {
        offset = n;
    }

    public boolean equalChars(char x, char y) {
        if (Math.abs(y - x) == offset) {
            return true;
        } else {
            return false;
        }
    }
}
