package io.totemo.watson.macro;

import net.eq2online.macros.core.MacroModCore;
import net.eq2online.macros.scripting.api.IMacroEvent;
import net.eq2online.macros.scripting.api.IMacroEventDispatcher;
import net.eq2online.macros.scripting.api.IMacroEventManager;
import net.eq2online.macros.scripting.api.IMacroEventProvider;

// ----------------------------------------------------------------------------
/**
 * Provides custom Watson events.
 */
public class MacroEventProviderWatson implements IMacroEventProvider
{
  // --------------------------------------------------------------------------
  /**
   * Name of the onWatsonDisplay event.
   */
  public static String ON_WATSON_DISPLAY   = "onWatsonDisplay";

  /**
   * Name of the onWatsonDisplay event.
   */
  public static String ON_WATSON_SELECTION = "onWatsonSelection";

  // --------------------------------------------------------------------------
  /**
   * @see net.eq2online.macros.scripting.api.IMacrosAPIModule#onInit()
   */
  @Override
  public void onInit()
  {
    MacroModCore.getMacroManager().getEventManager().registerEventProvider(this);
  }

  // --------------------------------------------------------------------------
  /**
   * @see net.eq2online.macros.scripting.api.IMacroEventProvider#getDispatcher()
   */
  @Override
  public IMacroEventDispatcher getDispatcher()
  {
    return _eventDispatcher;
  }

  // --------------------------------------------------------------------------
  /**
   * @see net.eq2online.macros.scripting.api.IMacroEventProvider#registerEvents(net.eq2online.macros.scripting.api.IMacroEventManager)
   */
  @Override
  public void registerEvents(IMacroEventManager manager)
  {
    manager.registerEvent(this, ON_WATSON_DISPLAY);
    manager.registerEvent(this, ON_WATSON_SELECTION);
  }

  // --------------------------------------------------------------------------
  /**
   * @see net.eq2online.macros.scripting.api.IMacroEventProvider#getHelp(net.eq2online.macros.scripting.api.IMacroEvent,
   *      int, int)
   */
  @Override
  public String getHelp(IMacroEvent macroEvent, int eventId, int line)
  {
    // TODO Auto-generated method stub
    return "";
  }

  // --------------------------------------------------------------------------
  /**
   * Decides when to dispatch events.
   */
  protected MacroEventDispatcherWatson _eventDispatcher = new MacroEventDispatcherWatson();
} // class MacroEventProviderWatson