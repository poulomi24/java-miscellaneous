package com.pratice;

public class ProducerConsumer {
    public static void main(String[] args) {
        Message message = new Message();
        Thread producerThread = new Thread(new Producer(message));
        Thread consumerThread = new Thread(new Consumer(message));
        producerThread.start();
        consumerThread.start();
    }
}

class Message {
    private String content;
    private boolean isReady = false;

    public synchronized void setContent(String content) {
        while (isReady) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.content = content;
        isReady = true;
        notifyAll();
    }

    public synchronized String getContent() {
        while (!isReady) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        isReady = false;
        notifyAll();
        return content;
    }
}

class Producer implements Runnable {
    private Message message;

    public Producer(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        String[] messages = {"hellp", "world", "goodbye"};
        for (String msg : messages) {
            message.setContent(msg);
            System.out.println("Produced: " + msg);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        message.setContent("EOF");
    }
}

class Consumer implements Runnable {
    private Message message;

    public Consumer(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        String content = "";
        while (!content.equals("EOF")) {
            content = message.getContent();
            System.out.println("consumed: " + content);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}