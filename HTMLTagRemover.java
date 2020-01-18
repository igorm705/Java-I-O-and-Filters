package ex1;//
//  HTMLTagRemover.java
//


import java.io.*;
import javax.swing.text.html.*;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.parser.*;


/** needs to be tested on latest JDK!
 * A class to remove HTML tags from a HTML file.
 * includes a main for testing, that expect the input file as single argument.
 */
public class HTMLTagRemover extends HTMLEditorKit.ParserCallback {
    StringBuffer s;
    boolean isInsideStyleTag = false;
    //static HTML.Tag STYLE = new HTML.Tag("STYLE");
    public HTMLTagRemover() {}

    /**
     * Parse a HTML input stream. The result is then available thru the method getText().
     * @param in The input stream, expected to be HTML.
     * @exception IOException thrown in case of problem with the input stream.
     */
    public void parse(Reader in) throws IOException {
        s = new StringBuffer();
        ParserDelegator delegator = new ParserDelegator();
        // the third parameter is TRUE to ignore charset directive
        delegator.parse(in, this, Boolean.TRUE);
    }

    public void handleStartTag(HTML.Tag t,MutableAttributeSet a,int pos) {
//  System.out.println(t.toString());
        if(HTML.Tag.STYLE.equals(t)) {
            isInsideStyleTag = true;
            System.out.println("got STYLE!!");
        }
    }

    public void	handleEndTag(HTML.Tag t, int pos) {
        if (HTML.Tag.STYLE.equals(t)) {
            isInsideStyleTag = false;
        }
    }

    /**
     * Method supplied to the HTML parser to handle the result.
     * @param text the result of the parser.
     * @param pos unused parameter.
     */
    public void handleText(char[] text, int pos) {
        if(isInsideStyleTag) return;
        s.append(text);
    }

    /**
     * Returns the output of the parser. The method parse() should be called before.
     * @return A string of the HTML-clean text.
     */
    public String getText() {
        return s.toString();
    }
 }