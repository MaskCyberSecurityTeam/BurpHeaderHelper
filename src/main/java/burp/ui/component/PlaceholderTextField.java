package burp.ui.component;

import javax.swing.*;
import javax.swing.text.Document;
import java.awt.*;

/**
 * 带有Placeholder效果的TextField - 带有文本提示的输入框<br>
 * 参考来源: http://www.uwenku.com/question/p-pyhaxkpo-bez.html
 */
@SuppressWarnings("all")
public class PlaceholderTextField extends JTextField {

    private String placeholder;

    public PlaceholderTextField() {
    }

    public PlaceholderTextField(final Document pDoc, final String pText, final int pColumns) {
        super(pDoc, pText, pColumns);
    }

    public PlaceholderTextField(final int pColumns) {
        super(pColumns);
    }

    public PlaceholderTextField(final String pText) {
        super(pText);
    }

    public PlaceholderTextField(final String pText, final int pColumns) {
        super(pText, pColumns);
    }

    public String getPlaceholder() {
        return placeholder;
    }

    @Override
    protected void paintComponent(final Graphics pG) {
        super.paintComponent(pG);

        if (placeholder.length() == 0 || getText().length() > 0) {
            return;
        }

        final Graphics2D g = (Graphics2D) pG;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(getDisabledTextColor());
        g.drawString(placeholder, getInsets().left, pG.getFontMetrics().getMaxAscent() + getInsets().top);
    }

    public void setPlaceholder(final String s) {
        placeholder = s;
    }
} 