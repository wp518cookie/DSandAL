package collection.exercise;

import collection.MyArrayList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by ping.wu on 2017/2/24.
 */
public class exe3_4 {
    public static void main(String[] args) {
        MyArrayList<Integer> c1 = new MyArrayList();
        for (int i = 0; i < 10; i += 2) {
            c1.add(i);
        }
        MyArrayList<Integer> c2 = new MyArrayList();
        for (int i = 1; i < 10; i += 2) {
            c2.add(i);
        }
        MyArrayList<Integer> result = union(c1, c2);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
    }

    public static MyArrayList<Integer> retain(MyArrayList<Integer> c1, MyArrayList<Integer> c2) {
        MyArrayList<Integer> result = new MyArrayList();
        Iterator<Integer> it1 = c1.iterator();
        Iterator<Integer> it2 = c2.iterator();
        if (!it1.hasNext() || !it2.hasNext()) {
            return result;
        }
        int t1 = it1.next();
        int t2 = it2.next();
        while (true) {
            if (t1 > t2) {
                if (it2.hasNext()) {
                    t2 = it2.next();
                    continue;
                } else {
                    break;
                }
            }
            if (t1 < t2) {
                if (it1.hasNext()) {
                    t1 = it1.next();
                    continue;
                } else {
                    break;
                }
            }
            if (t1 == t2) {
                result.add(t1);
                if (it1.hasNext() && it2.hasNext()) {
                    t1 = it1.next();
                    t2 = it2.next();
                    continue;
                }
            }
            if (!it1.hasNext() || !it2.hasNext()) {
                break;
            }
        }
        return result;
    }

    public static MyArrayList<Integer> union(MyArrayList<Integer> c1, MyArrayList<Integer> c2) {
        MyArrayList<Integer> result = new MyArrayList();
        Iterator<Integer> it1 = c1.iterator();
        Iterator<Integer> it2 = c2.iterator();
        if (!it1.hasNext() && it2.hasNext()) {
            return c2;
        } else if (it1.hasNext() && !it2.hasNext()) {
            return c1;
        } else if (!it1.hasNext() && !it2.hasNext()) {
            return null;
        }
        int t1 = it1.next();
        int t2 = it2.next();
        while (true) {
            if (t1 > t2) {
                result.add(t2);
                if (it2.hasNext()) {
                    t2 = it2.next();
                    continue;
                } else {
                    result.add(t1);
                    while (it1.hasNext()) {
                        result.add(it1.next());
                    }
                    break;
                }
            }
            if (t1 < t2) {
                result.add(t1);
                if (it1.hasNext()) {
                    t1 = it1.next();
                    continue;
                } else {
                    result.add(t2);
                    while (it2.hasNext()) {
                        result.add(it2.next());
                    }
                    break;
                }
            }
            if (t1 == t2) {
                result.add(t1);
                if (!it1.hasNext() || !it2.hasNext()) {
                    while (it1.hasNext()) {
                        result.add(it1.next());
                    }
                    while (it2.hasNext()) {
                        result.add(it2.next());
                    }
                } else {
                    t1 = it1.next();
                    t2 = it2.next();
                    continue;
                }
            }
        }
        return result;
    }

    //answer
    public static <AnyType extends Comparable<? super AnyType>> void intersection(List<AnyType> L1, List<AnyType> L2, List<AnyType> intersect) {
        ListIterator<AnyType> iterL1 = L1.listIterator();
        ListIterator<AnyType> iterL2 = L2.listIterator();
        AnyType itemL1 = null, itemL2 = null;
        if (iterL1.hasNext() && iterL2.hasNext()) {
            itemL1 = iterL1.next();
            itemL2 = iterL2.next();
        }
        while (itemL1 != null && itemL2 != null) {
            int compareResult = itemL1.compareTo(itemL2);
            if (compareResult == 0) {
                intersect.add(itemL1);
                itemL1 = iterL1.hasNext() ? iterL1.next() : null;
                itemL2 = iterL2.hasNext() ? iterL2.next() : null;
            } else if (compareResult < 0) {
                itemL1 = iterL1.hasNext() ? iterL1.next() : null;
            } else {
                itemL2 = iterL2.hasNext() ? iterL2.next() : null;
            }
        }
    }

    public static <AnyType extends Comparable<? super AnyType>> void union(List<AnyType> L1, List<AnyType> L2, List<AnyType> result) {
        ListIterator<AnyType> iterL1 = L1.listIterator();
        ListIterator<AnyType> iterL2 = L2.listIterator();
        AnyType itemL1 = null, itemL2 = null;
        if (iterL1.hasNext()) {
            itemL1 = iterL1.next();
        }
        while (itemL1 != null && itemL2)
    }
}
