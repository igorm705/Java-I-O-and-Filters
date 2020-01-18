package ex1;

/**The class for creating class of filter. Creates English filter and javascript filter
 *
 */

public class WebPageFilterFactory {


 public WebPageFilter createFilter(String filterName) throws NoSuchFilterException{


       if (filterName.equalsIgnoreCase("english")) {
           return new EnglishDocumentsFilter();
       } else if (filterName.equalsIgnoreCase("javascript")) {
           return new RejectJavaScriptFilter();
       } else  {
         throw new  NoSuchFilterException ();
       }

 }
}
