package net.sf.anathema.character.main.xml.trait.types;

import net.sf.anathema.character.main.traits.groups.AllAttributeTraitTypeList;
import net.sf.anathema.character.main.traits.groups.DefaultTraitTypeList;
import net.sf.anathema.character.main.xml.registry.IXmlTemplateRegistry;
import net.sf.anathema.character.main.xml.trait.GenericTraitTemplateFactory;
import net.sf.anathema.character.main.xml.trait.pool.GenericTraitTemplatePool;

public class AttributePoolParser extends AbstractPoolTemplateParser {

  private static final String TAG_ATTRIBUTES = "attributes";

  public AttributePoolParser(IXmlTemplateRegistry<GenericTraitTemplatePool> poolTemplateRegistry, GenericTraitTemplateFactory templateFactory) {
    super(poolTemplateRegistry, templateFactory);
  }

  @Override
  protected void executeResult(GenericTraitTemplatePool traitPool) {
    templateFactory.setAttributesPool(traitPool);
  }

  @Override
  protected String getTagName() {
    return TAG_ATTRIBUTES;
  }

  @Override
  protected DefaultTraitTypeList getTraitTypeGroup() {
    return AllAttributeTraitTypeList.getInstance();
  }
}