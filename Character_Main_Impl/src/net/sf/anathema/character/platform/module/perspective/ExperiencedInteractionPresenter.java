package net.sf.anathema.character.platform.module.perspective;

import net.sf.anathema.character.perspective.model.model.ItemSelectionModel;
import net.sf.anathema.interaction.Command;
import net.sf.anathema.interaction.ToggleTool;
import net.sf.anathema.lib.file.RelativePath;

public class ExperiencedInteractionPresenter {
  private ItemSelectionModel model;
  private ToggleTool interaction;

  public ExperiencedInteractionPresenter(ItemSelectionModel model, ToggleTool interaction) {
    this.model = model;
    this.interaction = interaction;
  }

  public void initPresentation() {
    initializeAppearance();
    initializeEnabling();
    initializeToggling();
    initializeCommand();
  }

  private void initializeAppearance() {
    interaction.setIcon(new RelativePath("icons/ToolXp.png"));
    interaction.setTooltip("CharacterTool.ToExperienced.Tooltip");
  }

  private void initializeEnabling() {
    model.whenGetsSelection(new EnableInteraction(interaction));
    interaction.disable();
  }

  private void initializeToggling() {
    model.whenCurrentSelectionBecomesInexperienced(new DeselectInteraction(interaction));
    model.whenCurrentSelectionBecomesExperienced(new SelectInteraction(interaction));
  }

  private void initializeCommand() {
    interaction.setCommand(new Command() {
      @Override
      public void execute() {
        model.convertCurrentToExperienced();
        interaction.select();
      }
    });
  }
}
