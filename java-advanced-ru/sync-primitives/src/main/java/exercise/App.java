package exercise;

class App {

    public static void main(String[] args) throws InterruptedException {
        // BEGIN
        var safeList = new SafetyList();
        var thread1 = new ListThread(safeList);
        var thread2 = new ListThread(safeList);
        System.out.println(safeList.getSize());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(safeList.getSize());
        // END
    }
}
