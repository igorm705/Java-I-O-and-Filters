package ex1;

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *Main class for starting the program. Need to submit two arguments:
 * name of web-filter and name of internet-site. The program will print the
 * internet-page only if it accepted by appropriate filter, and in another case
 * it will print "access denied"
 */
 public class RestrictedView {
    public static void main(String[] args) throws Exception {


         WebPageFilterFactory filter = new WebPageFilterFactory();
         List<WebPageFilter> where = new ArrayList<WebPageFilter>();

         for (int i=0; i< args.length; i++) {
             if (args[i].charAt(0) == '-') {

                 String result = args[i].substring(0, 0) + args[i].substring(1);
                 try {
                     WebPageFilter mfilter = filter.createFilter(result);
                     where.add(mfilter);
                 } catch (NoSuchFilterException e) {

                     System.out.println("No Such Filter " + result);
                 }

             }

             else{

                 CompositWebPageFilter composit = new CompositWebPageFilter(where);
                 String page_address = args[i];//save name of page

                 try {
                     // the HTML to convert
                     URL u = new URL(args[i]);
                     InputStreamReader in = new InputStreamReader(u.openStream());
                     HTMLTagRemover parser = new HTMLTagRemover();
                     parser.parse(in);
                     in.close();



                     if (!composit.accept(page_address, parser.getText())) {
                         System.out.println("access denied");
                     }
                     else {
                         System.out.println(parser.getText());
                     }
//

                 } catch (Exception e) {
                     System.out.println("page not found");
                 }
             }
          }

         }
    }

