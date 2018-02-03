//package Stepic;
//
//public interface InTreePQ {
//
//    /**
//     * Add a new element with priority @param p
//     * @param p priority of new element in heap
//     */
//    void insert(int p);
//
//    /**
//     * Delete element
//     *
//     * @param iterator iterator of removing element
//     * @return true if operation was successfully complete
//     */
//    default void remove(Iterator iterator) {
//        System.out.println("Method remove is not realize");
//    }
//
//    /**
//     * @return element with minimal priority
//     */
//    int getMax();
//
//    /**
//     * Extract element with minimal priority
//     * @return element with minimal priority
//     */
//    int extractMax();
//
//    /**
//     * Change priority of element with iterator
//     * @param iterator
//     * @param newPriority
//     * @return true if operation was successfully complete
//     */
//    void changePriority(Iterator iterator, int newPriority);
//}
