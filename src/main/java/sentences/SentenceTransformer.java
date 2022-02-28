package sentences;

import java.util.Locale;

public class SentenceTransformer {

    public String shortenSentence(String sentence){
        String start = sentence.substring(0,1).toUpperCase();
        if (!(sentence.startsWith(start))) {
            throw new IllegalArgumentException("Must start with capital letter!");
        }

        if (!((sentence.endsWith(".") || sentence.endsWith("?") || sentence.endsWith("!")))){
            throw new IllegalArgumentException("Must end with . ! or ?");
        }

        String[] parts = sentence.split(" ");
        if (parts.length>4) {
            return parts[0]+" ... "+parts[parts.length-1];
        }else{
            return sentence;
        }
    }
}
