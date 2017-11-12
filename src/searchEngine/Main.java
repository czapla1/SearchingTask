package searchEngine;

public class Main {

    public static void main(String[] args) {
        SearchEngine se = new SearchEngine();

        se.addDocument("Document1", "the brown fox jumped over the brown dog");
        se.addDocument("Document2", "the lazy brown dog sat in the corner over");
        se.addDocument("Document3", "the red fox bit the lazy dog the");

        System.out.println(se.result("brown"));
        System.out.println(se.result("fox"));
    }
}
