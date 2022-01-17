/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colorchooser;

import javax.swing.text.*;
import java.util.regex.*;

/**
 *
 * @author nccmac
 */
public class RegExDocument extends PlainDocument {

    private String exp;
    private Pattern pattern;
    private Matcher matcher;

    public RegExDocument(String exp) {
        if (exp == null) {
            exp = "\\.*"; //accept anything
        }
        this.exp = exp;
        pattern = Pattern.compile(exp);
    }

    public boolean validate(String str) {
        matcher = pattern.matcher(str);
        return matcher.matches();
    }

    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        StringBuilder sb = new StringBuilder(getText(0, getLength()));
        sb.insert(offs, str);
        if (validate(sb.toString())) {
            super.insertString(offs, str, a);
        }
    }
}
