class SmallestInfiniteSet {

    private int current;
    private TreeSet<Integer> set;

    public SmallestInfiniteSet() {
        current = 1;
        set = new TreeSet<>();
    }

    public int popSmallest() {

        if (!set.isEmpty()) {
            return set.pollFirst();
        }

        return current++;
    }

    public void addBack(int num) {

        if (num < current) {
            set.add(num);
        }
    }
}
/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */