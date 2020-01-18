package ex1;

import java.util.List;

/**
 * This class implements WebPageFilter and can includes two implementations of
 * this: English filter and Javascript filter. It includes the boolean function
 * "accept" that can accepts of rejects internet-pages
 */

public class CompositWebPageFilter implements WebPageFilter  {

    private List<WebPageFilter> filters;

    public CompositWebPageFilter(List<WebPageFilter> filters) {
        this.filters = filters;
    }

    @Override
    public boolean accept(String url, String content) {
        for (WebPageFilter filter :
                filters) {
            if (filter == null || !filter.accept(url, content))
                return false;
        }
        return true;
    }

}

