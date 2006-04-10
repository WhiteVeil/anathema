package net.sf.anathema.lib.workflow.textualdescription;

import net.disy.commons.core.exception.UnreachableCodeReachedException;
import net.sf.anathema.lib.control.stringvalue.IStringValueChangedListener;

// FIXME: Have calling classes extend TextualPresentation instead of making static calls
public class TextualPresentation {

  private TextualPresentation() {
    throw new UnreachableCodeReachedException();
  }

  public static void initView(final ITextView textView, final ISimpleTextualDescription textualDescription) {
    textView.addTextChangedListener(new IStringValueChangedListener() {
      public void valueChanged(String newValue) {
        textualDescription.setText(newValue);
      }
    });
    textView.setText(textualDescription.getText());
    textualDescription.addTextChangedListener(new IStringValueChangedListener() {
      public void valueChanged(String newValue) {
        textView.setText(newValue);
      }
    });
  }
}