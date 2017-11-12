package searchEngine;

public class DocumentIndex {
    private final Document document;
    private final int occurrences;
    private final double tf;

    public DocumentIndex(Document document, int occurrences) {
        this.document = document;
        this.occurrences = occurrences;
        this.tf=occurrences;
    }

    public int getOccurrences() {
        return occurrences;
    }
    public double getTf() {
        return tf;
    }

    public Document getDocument() {
        return document;
    }
}
