package csc435.app;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class IndexStore {
    private static IndexStore instance;
    private final ConcurrentHashMap<String, Set<String>> documentMap; 
    private final ConcurrentHashMap<String, Map<String, Integer>> termInvertedIndex; 

    private IndexStore() {
        this.documentMap = new ConcurrentHashMap<>();
        this.termInvertedIndex = new ConcurrentHashMap<>();
    }
	
    public void clearIndexStore() {
    // TO-DO Cleaning indexed data
    }


    public static synchronized IndexStore getInstance() {
        if (instance == null) {
            instance = new IndexStore();
        }
        return instance;
    }
    
    public void putDocument(String documentPath, List<String> keywords) {
        // TO-DO implement storing document paths in the document map for a given keyword
    }
    
    public void updateIndex(String term, String documentPath, int frequency) {
        // TO-DO implement updating the index with term frequency for a document
    }

    
    public Set<String> getDocument(String keyword) {
        // TO-DO implement getting documents matching a keyword
    }

    
    public List<String> sortedByOccurrences(String[] terms) {
       // TO-DO implement retrieval of documents sorted by occurrences of terms
        }

        // Sort files by occurrences in descending order
        List<String> sortedFiles = new ArrayList<>(fileOccurrences.keySet());
        sortedFiles.sort((file1, file2) -> Integer.compare(fileOccurrences.get(file2), fileOccurrences.get(file1)));
        return sortedFiles;
    }

    public void indexFolderInBatches(String folderPath, int batchSize) {
        // TO-DO implement indexing of documents in batches to reduce memory usage

        // Process any remaining files that didn't make up a full batch
        if (!batch.isEmpty()) {
            processBatch(new ArrayList<>(batch));
            processBatch(batch);
        }

        System.out.println("Indexing complete.");
    }


    private void processBatch(List<File> batch) {
        Map<String, Map<String, Integer>> termFrequencyInBatch = new HashMap<>();
        for (File file : batch) {
            String documentPath = file.getAbsolutePath();
            Map<String, Integer> termFrequency = extractTerms(file);
            termFrequencyInBatch.put(documentPath, termFrequency);
            termFrequency.forEach((term, freq) -> updateIndex(term, documentPath, freq));
        }

        termFrequencyInBatch.forEach((documentPath, termFrequency) ->
            termFrequency.forEach((term, freq) -> updateIndex(term, documentPath, freq))
        );
        System.out.println("Processed " + batch.size() + " files.");
    }

        private Map<String, Integer> extractTerms(File file) {
        Map<String, Integer> termFrequency = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            // TO-DO implement extraction of terms and their frequency from a file
        } catch (IOException e) {
            e.printStackTrace();
        }
        return termFrequency;
    }
}
