package net.sf.anathema.character.generic.dummy;

import net.sf.anathema.character.generic.IBasicCharacterData;
import net.sf.anathema.character.generic.caste.ICasteType;
import net.sf.anathema.character.generic.template.ITemplateType;
import net.sf.anathema.character.generic.type.CharacterType;

public class DummyBasicCharacterData implements IBasicCharacterData {

  private ICasteType casteType;
  private CharacterType characterType;

  @Override
  public ICasteType getCasteType() {
    return casteType;
  }

  @Override
  public CharacterType getCharacterType() {
    return characterType;
  }

  @Override
  public boolean isExperienced() {
    return false;
  }

  public void setCasteType(ICasteType casteType) {
    this.casteType = casteType;
  }

  public void setCharacterType(CharacterType characterType) {
    this.characterType = characterType;
  }

  @Override
  public ITemplateType getTemplateType() {
    return null;
  }
}