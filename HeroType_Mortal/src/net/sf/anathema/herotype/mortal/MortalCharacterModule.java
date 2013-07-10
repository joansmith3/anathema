package net.sf.anathema.herotype.mortal;

import net.sf.anathema.character.main.framework.module.CharacterModule;
import net.sf.anathema.character.main.framework.module.CharacterTypeModule;

@CharacterModule
public class MortalCharacterModule extends CharacterTypeModule {

  public MortalCharacterModule() {
    super(new MortalCharacterType());
  }
}