
@FunctionalInterface
public interface Komparator<T> {
    int compare(T o1, T o2);

     static <T extends Comparable<? super T>> Komparator<T> naturligOrden() {
        return (x, y) -> x.compareTo(y);
    }

    static <T extends Comparable<? super T>> Komparator<T> omvendtOrden() {
        return (x, y) -> y.compareTo(x);
    }
}
