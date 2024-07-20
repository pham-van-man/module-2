package ss11_stack_quece.bai_tap.bai_tap_7;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class QueueManager {
    Queue<Record> femaleQueue = new LinkedList<>();
    Queue<Record> maleQueue = new LinkedList<>();

    public void enqueueRecord(Record record) {
        if (record.gender.equalsIgnoreCase("female")) {
            femaleQueue.add(record);
        } else if (record.gender.equalsIgnoreCase("male")) {
            maleQueue.add(record);
        }
    }

    public void writeRecordsToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            while (!femaleQueue.isEmpty()) {
                Record record = femaleQueue.poll();
                writer.write(record.toString());
                writer.newLine();
            }
            while (!maleQueue.isEmpty()) {
                Record record = maleQueue.poll();
                writer.write(record.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayQueues() {
        System.out.println("Female Queue:");
        for (Record record : femaleQueue) {
            System.out.println(record);
        }
        System.out.println("Male Queue:");
        for (Record record : maleQueue) {
            System.out.println(record);
        }
    }
}

