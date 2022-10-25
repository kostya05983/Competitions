package yandex;

import java.io.*;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class LentaPhoto {
    public static class Photo {
        private double width;
        private double height;

        private double newHeight;

        public Photo(double width, double height, double newWidth) {
            this.width = width;
            this.height = height;
            this.newHeight = Math.ceil((height * newWidth) / width);
        }

        public double getWidth() {
            return width;
        }

        public void setWidth(double width) {
            this.width = width;
        }

        public double getHeight() {
            return height;
        }

        public void setHeight(double height) {
            this.height = height;
        }

        public double getNewHeight() {
            return newHeight;
        }

        public void setNewHeight(double newHeight) {
            this.newHeight = newHeight;
        }
    }

    public static class PhotoMinComporator implements Comparator<Photo> {
        @Override
        public int compare(Photo o1, Photo o2) {
            return Double.compare(o1.newHeight, o2.newHeight);
        }
    }

    public static class PhotoMaxComporator implements Comparator<Photo> {
        @Override
        public int compare(Photo o1, Photo o2) {
            return Double.compare(o2.newHeight, o1.newHeight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));


        int newWidth = Integer.parseInt(reader.readLine());
        String[] secondLine = reader.readLine().split(" ");
        int n = Integer.parseInt(secondLine[0]);
        int k = Integer.parseInt(secondLine[1]);

        ArrayList<Photo> photos = new ArrayList<>(n);

        var maxQueue = new PriorityQueue(k, new PhotoMinComporator());
        var minQueue = new PriorityQueue(k, new PhotoMaxComporator());

        for (int i = 0; i < n; i++) {
            String[] lines = reader.readLine().split("x");

            var photo = new Photo(Integer.parseInt(lines[0]), Integer.parseInt(lines[1]), newWidth);
            var maxQueuePeeked = (Photo) maxQueue.poll();
            var minQueuePeeked = (Photo) minQueue.poll();

            if (maxQueuePeeked == null || photo.newHeight > maxQueuePeeked.newHeight || (maxQueue.size() + 1) < k) {
                maxQueue.offer(photo);
            }
            if (minQueuePeeked == null || photo.newHeight < minQueuePeeked.newHeight || (minQueue.size() + 1) < k) {
                minQueue.offer(photo);
            }
            if (maxQueuePeeked != null && maxQueue.size() < k) {
                maxQueue.offer(maxQueuePeeked);
            }
            if (minQueuePeeked != null && minQueue.size() < k) {
                minQueue.offer(minQueuePeeked);
            }
        }

        var resultMax = 0d;
        var resultMin = 0d;

        for (int i = 0; i < k; i++) {
            resultMax += ((Photo) maxQueue.poll()).newHeight;
        }
        for (int i = 0; i < k; i++) {
            resultMin += ((Photo) minQueue.poll()).newHeight;
        }

        writer.write(String.format("%d", (int) resultMin));
        writer.newLine();
        writer.write(String.format("%d", (int) resultMax));

        reader.close();
        writer.close();
    }
}
