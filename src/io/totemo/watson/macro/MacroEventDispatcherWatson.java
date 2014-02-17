package io.totemo.watson.macro;

import net.eq2online.macros.scripting.api.IMacroEventDispatcher;
import net.eq2online.macros.scripting.api.IMacroEventManager;
import net.minecraft.client.Minecraft;
import watson.Controller;

// ----------------------------------------------------------------------------
/**
 * Decides when to dispatch Watson custom events.
 */
public class MacroEventDispatcherWatson implements IMacroEventDispatcher
{
  // --------------------------------------------------------------------------
  /**
   * @see net.eq2online.macros.scripting.api.IMacroEventDispatcher#onTick(net.eq2online.macros.scripting.api.IMacroEventManager,
   *      net.minecraft.client.Minecraft)
   */
  @Override
  public void onTick(IMacroEventManager manager, Minecraft minecraft)
  {
    if (minecraft == null || minecraft.thePlayer == null || minecraft.theWorld == null)
    {
      return;
    }

    if (Controller.instance.isSelectionChanged())
    {
      manager.sendEvent(MacroEventProviderWatson.ON_WATSON_SELECTION, 10);
    }
    if (Controller.instance.getDisplaySettings().isDisplayVisibilityChanged())
    {
      manager.sendEvent(MacroEventProviderWatson.ON_WATSON_DISPLAY, 10);
    }
  }
} // class MacroEventDispatcherWatson