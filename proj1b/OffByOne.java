public class OffByOne implements CharacterComparator {
    public OffByOne() {

    }
    @Override
    public boolean equalChars(char x, char y) {
        if (Math.abs(y - x) == 1) {
            return true;
        } else {
            return false;
        }
    }
}
