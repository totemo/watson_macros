package io.totemo.watson.macro;

import net.eq2online.macros.scripting.ScriptActionBase;
import net.eq2online.macros.scripting.api.IMacro;
import net.eq2online.macros.scripting.api.IMacroAction;
import net.eq2online.macros.scripting.api.IMacroActionProcessor;
import net.eq2online.macros.scripting.api.IMacroActionStackEntry;
import net.eq2online.macros.scripting.api.IReturnValue;
import net.eq2online.macros.scripting.api.IScriptAction;
import net.eq2online.macros.scripting.api.IScriptActionProvider;
import net.eq2online.macros.scripting.parser.ScriptContext;
import net.minecraft.client.Minecraft;
import watson.LiteModWatson;

// ----------------------------------------------------------------------------
/**
 * A Macro/Keybind Mod script action for a WATSON(&lt;string&gt;) command.
 */
public class ScriptActionWatson extends ScriptActionBase
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

  // --------------------------------------------------------------------------
  /**
   * @see net.eq2online.macros.scripting.api.IScriptAction#isThreadSafe()
   */
  @Override
  public boolean isThreadSafe()
  {
    return false;
  }

  // --------------------------------------------------------------------------
  /**
   * @see net.eq2online.macros.scripting.api.IScriptAction#isStackPushOperator()
   */
  @Override
  public boolean isStackPushOperator()
  {
    return false;
  }

  // --------------------------------------------------------------------------
  /**
   * @see net.eq2online.macros.scripting.api.IScriptAction#isStackPopOperator()
   */
  @Override
  public boolean isStackPopOperator()
  {
    return false;
  }

  // --------------------------------------------------------------------------
  /**
   * @see net.eq2online.macros.scripting.api.IScriptAction#canBePoppedBy(net.eq2online.macros.scripting.api.IScriptAction)
   */
  @Override
  public boolean canBePoppedBy(IScriptAction action)
  {
    return false;
  }

  // --------------------------------------------------------------------------
  /**
   * @see net.eq2online.macros.scripting.api.IScriptAction#executeStackPush(net.eq2online.macros.scripting.api.IScriptActionProvider,
   *      net.eq2online.macros.scripting.api.IMacro,
   *      net.eq2online.macros.scripting.api.IMacroAction, java.lang.String,
   *      java.lang.String[])
   */
  @Override
  public boolean executeStackPush(IScriptActionProvider provider, IMacro macro, IMacroAction instance, String rawParams,
                                  String[] params)
  {
    return false;
  }

  // --------------------------------------------------------------------------
  /**
   * @see net.eq2online.macros.scripting.api.IScriptAction#executeStackPop(net.eq2online.macros.scripting.api.IScriptActionProvider,
   *      net.eq2online.macros.scripting.api.IMacro,
   *      net.eq2online.macros.scripting.api.IMacroAction, java.lang.String,
   *      java.lang.String[], net.eq2online.macros.scripting.api.IMacroAction)
   */
  @Override
  public boolean executeStackPop(IScriptActionProvider provider, IMacro macro, IMacroAction instance, String rawParams,
                                 String[] params, IMacroAction popAction)
  {
    return false;
  }

  // --------------------------------------------------------------------------
  /**
   * @see net.eq2online.macros.scripting.api.IScriptAction#canBreak(net.eq2online.macros.scripting.api.IMacroActionProcessor,
   *      net.eq2online.macros.scripting.api.IScriptActionProvider,
   *      net.eq2online.macros.scripting.api.IMacro,
   *      net.eq2online.macros.scripting.api.IMacroAction,
   *      net.eq2online.macros.scripting.api.IMacroAction)
   */
  @Override
  public boolean canBreak(IMacroActionProcessor processor, IScriptActionProvider provider, IMacro macro, IMacroAction instance,
                          IMacroAction breakAction)
  {
    return false;
  }

  // --------------------------------------------------------------------------
  /**
   * @see net.eq2online.macros.scripting.api.IScriptAction#isConditionalOperator()
   */
  @Override
  public boolean isConditionalOperator()
  {
    return false;
  }

  // --------------------------------------------------------------------------
  /**
   * @see net.eq2online.macros.scripting.api.IScriptAction#isConditionalElseOperator(net.eq2online.macros.scripting.api.IScriptAction)
   */
  @Override
  public boolean isConditionalElseOperator(IScriptAction action)
  {
    return false;
  }

  // --------------------------------------------------------------------------
  /**
   * @see net.eq2online.macros.scripting.api.IScriptAction#matchesConditionalOperator(net.eq2online.macros.scripting.api.IScriptAction)
   */
  @Override
  public boolean matchesConditionalOperator(IScriptAction action)
  {
    return false;
  }

  // --------------------------------------------------------------------------
  /**
   * @see net.eq2online.macros.scripting.api.IScriptAction#executeConditional(net.eq2online.macros.scripting.api.IScriptActionProvider,
   *      net.eq2online.macros.scripting.api.IMacro,
   *      net.eq2online.macros.scripting.api.IMacroAction, java.lang.String,
   *      java.lang.String[])
   */
  @Override
  public boolean executeConditional(IScriptActionProvider provider, IMacro macro, IMacroAction instance, String rawParams,
                                    String[] params)
  {
    return false;
  }

  // --------------------------------------------------------------------------
  /**
   * @see net.eq2online.macros.scripting.api.IScriptAction#executeConditionalElse(net.eq2online.macros.scripting.api.IScriptActionProvider,
   *      net.eq2online.macros.scripting.api.IMacro,
   *      net.eq2online.macros.scripting.api.IMacroAction, java.lang.String,
   *      java.lang.String[],
   *      net.eq2online.macros.scripting.api.IMacroActionStackEntry)
   */
  @Override
  public void executeConditionalElse(IScriptActionProvider provider, IMacro macro, IMacroAction instance, String rawParams,
                                     String[] params, IMacroActionStackEntry top)
  {
  }

  // --------------------------------------------------------------------------
  /**
   * @see net.eq2online.macros.scripting.api.IScriptAction#canExecuteNow(net.eq2online.macros.scripting.api.IScriptActionProvider,
   *      net.eq2online.macros.scripting.api.IMacro,
   *      net.eq2online.macros.scripting.api.IMacroAction, java.lang.String,
   *      java.lang.String[])
   */
  @Override
  public boolean canExecuteNow(IScriptActionProvider provider, IMacro macro, IMacroAction instance, String rawParams,
                               String[] params)
  {
    return true;
  }

  // --------------------------------------------------------------------------
  /**
   * @see net.eq2online.macros.scripting.api.IScriptAction#onTick(net.eq2online.macros.scripting.api.IScriptActionProvider)
   */
  @Override
  public int onTick(IScriptActionProvider provider)
  {
    return 0;
  }

  // --------------------------------------------------------------------------
  /**
   * @see net.eq2online.macros.scripting.api.IScriptAction#isClocked()
   */
  @Override
  public boolean isClocked()
  {
    return false;
  }

  // --------------------------------------------------------------------------
  /**
   * @see net.eq2online.macros.scripting.api.IScriptAction#isPermissable()
   */
  @Override
  public boolean isPermissable()
  {
    return false;
  }

  // --------------------------------------------------------------------------
  /**
   * @see net.eq2online.macros.scripting.api.IScriptAction#getPermissionGroup()
   */
  @Override
  public String getPermissionGroup()
  {
    return null;
  }

  // --------------------------------------------------------------------------
  /**
   * @see net.eq2online.macros.scripting.api.IScriptAction#registerPermissions(java.lang.String,
   *      java.lang.String)
   */
  @Override
  public void registerPermissions(String actionName, String actionGroup)
  {
  }

  // --------------------------------------------------------------------------
  /**
   * @see net.eq2online.macros.scripting.api.IScriptAction#checkExecutePermission()
   */
  @Override
  public boolean checkExecutePermission()
  {
    return true;
  }

  // --------------------------------------------------------------------------
  /**
   * @see net.eq2online.macros.scripting.api.IScriptAction#checkPermission(java.lang.String,
   *      java.lang.String)
   */
  @Override
  public boolean checkPermission(String actionName, String permission)
  {
    return false;
  }

  // --------------------------------------------------------------------------
  /**
   * @see net.eq2online.macros.scripting.api.IScriptAction#onStopped(net.eq2online.macros.scripting.api.IScriptActionProvider,
   *      net.eq2online.macros.scripting.api.IMacro,
   *      net.eq2online.macros.scripting.api.IMacroAction)
   */
  @Override
  public void onStopped(IScriptActionProvider provider, IMacro macro, IMacroAction instance)
  {
  }
} // class ScriptActionWatson
