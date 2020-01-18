package ex1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
/**
 * Open and read a file, and return the lines in the file as a list
 * of Strings.
 * (Demonstrates Java FileReader, BufferedReader, and Java5.)
 */

public class ReadFromFile {


        private List<String> common_words = new ArrayList<>();

        public List<String> return_file () {
            try {
                BufferedReader reader = new BufferedReader(new FileReader("99MostCommonEnglishWords"));
                String line;
                while ((line = reader.readLine()) != null) {
                    common_words.add(line);
                }
                reader.close();
                return common_words;
            } catch (Exception e) {
                System.err.format("Exception occurred trying to read '%s'.", "99MostCommonEnglishWords");
                e.printStackTrace();
                return null;
            }
        }

}

