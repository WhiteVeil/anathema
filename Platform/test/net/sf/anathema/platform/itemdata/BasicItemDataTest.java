package net.sf.anathema.platform.itemdata;

import net.sf.anathema.framework.itemdata.model.BasicItemData;
import net.sf.anathema.framework.itemdata.model.IBasicItemData;
import net.sf.anathema.framework.presenter.itemmanagement.PrintNameAdjuster;
import net.sf.anathema.framework.repository.IItem;
import net.sf.anathema.framework.styledtext.model.ITextPart;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BasicItemDataTest {

  private IBasicItemData itemData = new BasicItemData();

  @Test
  public void hasNoContentAfterCreation() throws Exception {
    assertEquals("", itemData.getDescription().getName().getText()); //$NON-NLS-1$
    assertArrayEquals(new ITextPart[0], itemData.getDescription().getContent().getTextParts());
  }

  @Test
  public void usesAdjusterForPrintName() throws Exception {
    IItem item = mock(IItem.class);
    itemData.setPrintNameAdjuster(new PrintNameAdjuster(item));
    itemData.getDescription().getName().setText("New Name"); //$NON-NLS-1$
    verify(item).setPrintName("New Name");
  }
}