package ex1;

/**
 * interface of WebPageFilter
 */

public interface WebPageFilter {

  boolean accept(String url, String content);
 
}
