package day13;

public class ThreadJoinExample {
    static class TaskTread extends Thread{
        private String taskName;
        public TaskTread(String taskName) {
            this.taskName = taskName;
        }
        public void run() {
            System.out.println(taskName + "작업시작");
            try{
                Thread.sleep(2000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(taskName+"작업완료");
        }
    }

    public static void main(String[] args) {
        TaskTread task1 = new TaskTread("작업1");
        TaskTread task2 = new TaskTread("작업2");

        task1.start();
        task2.start();
        try {
            System.out.println("모든 작업의 완료를 기다립니다");
            task1.join();
            task2.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("모든 작업이 완료되었습니다.");


    }
}
