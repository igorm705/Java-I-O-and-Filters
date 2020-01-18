package ex1;


import java.util.ArrayList;
import java.util.List;

/**
 * This class implements WebPageFilter and blockes all sites
 * if these languages not English
 */

public class  EnglishDocumentsFilter implements WebPageFilter{

 private List<String> common_words = new ArrayList<>();
 private ReadFromFile rdf = new ReadFromFile();

public boolean accept(String url, String content){

    int counter = 0;
    common_words = rdf.return_file();

    //check for common English words in a document. If the document contains
    //minimum two words from this we get the conlcusion that a page in English


    for (int i = 0; i < common_words.size(); i ++) {
        if (content.contains(" " + common_words.get(i)+ " ")){
            counter++;
            if (counter == 5){
                return true;
            }
        }
    }

   return false;
  }

}
