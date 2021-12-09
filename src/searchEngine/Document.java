package searchEngine;

public class Document {

    private final String title;
    private final String newTitle;
    private final String content;
    private final int totalWords;

    public Document(String title, String content, int totalWords) {
        this.title = title;
        this.content = content;
        this.totalWords = totalWords;
    }

    public String getTitle() {
        return title;
    }
    public String getContent() {
        return content;
    }
    public int getTotalWords() {
        return totalWords;
    }
}
