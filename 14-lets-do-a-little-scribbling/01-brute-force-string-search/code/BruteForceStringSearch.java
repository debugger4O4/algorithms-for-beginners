import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class BruteForceStringSearch {

    // Алгоритм
    public static Queue<Integer> bruteForceStringSearch(String p, String t) {
        Queue<Integer> q = new Queue<>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Integer> iterator() {
                return null;
            }

            @Override
            public void forEach(Consumer<? super Integer> action) {
                Queue.super.forEach(action);
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public <T> T[] toArray(IntFunction<T[]> generator) {
                return Queue.super.toArray(generator);
            }

            @Override
            public boolean add(Integer integer) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Integer> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean removeIf(Predicate<? super Integer> filter) {
                return Queue.super.removeIf(filter);
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public boolean equals(Object o) {
                return false;
            }

            @Override
            public int hashCode() {
                return 0;
            }

            @Override
            public Spliterator<Integer> spliterator() {
                return Queue.super.spliterator();
            }

            @Override
            public Stream<Integer> stream() {
                return Queue.super.stream();
            }

            @Override
            public Stream<Integer> parallelStream() {
                return Queue.super.parallelStream();
            }

            @Override
            public boolean offer(Integer integer) {
                return false;
            }

            @Override
            public Integer remove() {
                return null;
            }

            @Override
            public Integer poll() {
                return null;
            }

            @Override
            public Integer element() {
                return null;
            }

            @Override
            public Integer peek() {
                return null;
            }
        };
        int m = p.length();
        int n = t.length();
        int i = 0;
        int j = 0;
        while (i < n) {
            if (j < m) {
                break;
            }
            j++;
            i++;
        }
        for (int k = 0; k < m; k++) {
            for (int z = 0; z < m; z++) {
                if (p.charAt(k + z) == t.charAt(k + z)) {
                    q.offer(k);
                    break;
                }
            }
        }
        return q;
    }
}
