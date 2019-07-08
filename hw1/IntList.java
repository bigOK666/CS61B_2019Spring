public class IntList{
	public int first;
    public IntList rest;        

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }

    public int get(int i) {
		IntList p = this;
		int count = 0;
		while(count != i){
			p = p.rest;
			count++;

		}
		return p.first;
	}

	public static void main(String[] args) {
		IntList L = new IntList(15, null);
		L = new IntList(10, L);
		L = new IntList(5, L);

		System.out.print(L.get(1));
	}
}