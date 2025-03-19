package csc435.app;

public class FileRetrievalEngine {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java FileRetrievalEngine <number_of_worker_threads>");
            System.exit(1);
        }

        int numWorkerThreads;
        try {
            // TO-DO implement workers thread
            
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Usage: java FileRetrievalEngine <number_of_worker_threads>");
            System.exit(1);
        } catch (NumberFormatException e) {
            System.err.println("Invalid number. Please enter a valid integer.");
            System.exit(1);
        }
    }


    public static void cleanup(IndexStore indexStore) {
        // TO-DO Cleaning indexed data
    }
}
