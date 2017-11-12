package searchEngine;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchEngine {
    private static final Pattern WORD = Pattern.compile("(\\w+)");
    private final List<Document> allDocuments = new ArrayList<>();
    private final Map<String, WordReverseIndex> words = new HashMap<>();

    public void  addDocument(String title, String content){
        int totalWordsInDocument = 0;
        Map<String, Integer> counters = new HashMap<>();
        Matcher m = WORD.matcher(content);
        while(m.find()){
            totalWordsInDocument++;
            String word = m.group(1);
            Integer n=counters.get(word);
            if(n==null){
                counters.put(word,1);
            }else {
                counters.put(word,n+1);
            }
        }

        Document document = new Document(title,content,totalWordsInDocument);
        allDocuments.add(document);

        for(Map.Entry<String,Integer> entry:counters.entrySet()){
            addDocumentIndex(entry.getKey(),entry.getValue(),document);
        }

        int numberOfDocuments= allDocuments.size();
        words.values().forEach(i->i.updateIdf(numberOfDocuments));

    }

    private void addDocumentIndex(String word, int occurrence, Document document){

        WordReverseIndex wordIndices= words.get(word);
        if(wordIndices == null){
            wordIndices = new WordReverseIndex();
            words.put(word,wordIndices);
        }

        DocumentIndex documentIndex = new DocumentIndex(document, occurrence);
        wordIndices.addDocumentsIndex(documentIndex);
    }

    public List<String> result(String word){
        WordReverseIndex res1= words.get(word);
        if(res1 == null){
            return Collections.emptyList();
        }else{
            return res1.changeToList();
        }
    }
}
