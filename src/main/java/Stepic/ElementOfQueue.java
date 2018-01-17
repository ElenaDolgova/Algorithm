package Stepic;

class ElementOfQueue {
    private int priority;
    //private int data;

    ElementOfQueue(int priority) {
        this.priority = priority;
        //this.data = data;
    }

    public int getPriority() {
        return this.priority;
    }

//    public int getData() {
//        return this.data;
//    }

    public boolean changePriority(int newPriority) {
        this.priority = newPriority;
        if (this.priority == newPriority) {
            return true;
        } else {
            return false;
        }
    }
}
