package searchEngine;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class WordReverseIndex {
    private double idf;
    private final List<DocumentIndex> documents = new ArrayList<>();

    public void addDocumentsIndex(DocumentIndex index) {
        documents.add(index);
    }

    private void sortDocuments() {
        Comparator<DocumentIndex> comparator = Comparator.comparingDouble(di -> di.getTf() * getIdf());
        documents.sort(comparator.reversed());
    }

    public void updateIdf(int totalDocumentsCount) {
        idf = Math.log(1+totalDocumentsCount / (double) documents.size());//inverse document frequency smooth
        sortDocuments();
    }

    public double getIdf() {
        return idf;
    }

    public List<String> changeToList() {
        return documents.stream()
                .map(DocumentIndex::getDocument)
                .map(Document::getTitle)
                .collect(Collectors.toList());

    }
}
