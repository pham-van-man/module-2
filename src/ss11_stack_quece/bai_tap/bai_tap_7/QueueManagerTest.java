package ss11_stack_quece.bai_tap.bai_tap_7;

import java.util.ArrayList;
import java.util.List;

public class QueueManagerTest {
    public static void main(String[] args) {
        List<Record> records = new ArrayList<>();
        records.add(new Record("Alice", "female", "1990-05-12"));
        records.add(new Record("Bob", "male", "1985-07-24"));
        records.add(new Record("Catherine", "female", "1992-03-16"));
        records.add(new Record("David", "male", "1988-11-30"));
        records.add(new Record("Eva", "female", "1995-04-22"));

        QueueManager queueManager = new QueueManager();

        // Thêm các bản ghi vào Queue
        for (Record record : records) {
            queueManager.enqueueRecord(record);
        }

        // Hiển thị các Queue
        queueManager.displayQueues();

        // Ghi dữ liệu ra file
        queueManager.writeRecordsToFile("sorted_records.txt");

        System.out.println("Dữ liệu đã được ghi vào file sorted_records.txt");
    }
}

