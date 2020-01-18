package ex1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**Filter for web-sites: blocks sites with java-script code inside
 *
 */

public class RejectJavaScriptFilter implements WebPageFilter {


public boolean accept(String url, String content3)  {

try {
    URL oracle = new URL(url);
    URLConnection yc = oracle.openConnection();
    BufferedReader in = new BufferedReader(new InputStreamReader(
            yc.getInputStream()));
    String inputLine;//variable for current string of internet-page

    while ((inputLine = in.readLine()) != null) {
        if (inputLine.contains("<script>")) {
            return false;
        }
    }
    in.close();
}
    catch (Exception e){
    System.out.println ("page not found");
    }




    return true;
  }
}
