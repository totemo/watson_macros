package io.totemo.watson.macro;

import net.eq2online.macros.scripting.ScriptAction;
import net.eq2online.macros.scripting.ScriptContext;
import net.eq2online.macros.scripting.api.IMacro;
import net.eq2online.macros.scripting.api.IMacroAction;
import net.eq2online.macros.scripting.api.IReturnValue;
import net.eq2online.macros.scripting.api.IScriptActionProvider;
import net.minecraft.client.Minecraft;
import watson.LiteModWatson;

// ----------------------------------------------------------------------------
/**
 * A Macro/Keybind Mod script action for a WATSON(&lt;string&gt;) command.
 */
public class ScriptActionWatson extends ScriptAction
{
  // --------------------------------------------------------------------------
  /**
   * Default constructor.
   */
  public ScriptActionWatson()
  {
    super(ScriptContext.MAIN, "watson");
  }

  // --------------------------------------------------------------------------
  /**
   * @see net.eq2online.macros.scripting.api.IMacrosAPIModule#OnInit()
   */
  @Override
  public void onInit()
  {
    getContext().getCore().registerScriptAction(this);
  }

  // --------------------------------------------------------------------------
  /**
   * @see net.eq2online.macros.scripting.ScriptAction#execute(net.eq2online.macros.scripting.api.IScriptActionProvider,
   *      net.eq2online.macros.scripting.api.IMacro,
   *      net.eq2online.macros.scripting.api.IMacroAction, java.lang.String,
   *      java.lang.String[])
   */
  @Override
  public IReturnValue execute(IScriptActionProvider provider, IMacro macro,
                              IMacroAction action, String command, String[] args)
  {
    LiteModWatson.sendChatMessage(Minecraft.getMinecraft().thePlayer, command);
    return null;
  }
} // class ScriptActionWatson
