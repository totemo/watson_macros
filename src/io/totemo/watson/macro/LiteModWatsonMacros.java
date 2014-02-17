package io.totemo.watson.macro;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

import watson.debug.Log;

import com.google.gson.Gson;
import com.mumfrey.liteloader.LiteMod;
import com.mumfrey.liteloader.modconfig.ConfigStrategy;
import com.mumfrey.liteloader.modconfig.ExposableOptions;

// ----------------------------------------------------------------------------
/**
 * Main LiteMod entry point and event handler.
 * 
 * @author totemo
 */
@ExposableOptions(strategy = ConfigStrategy.Versioned, filename = "watsonmacros.json")
public class LiteModWatsonMacros implements LiteMod
{
  // --------------------------------------------------------------------------
  /**
   * Default constructor.
   */
  public LiteModWatsonMacros()
  {
  }

  // --------------------------------------------------------------------------
  /**
   * getName() should be used to return the display name of your mod and MUST
   * NOT return null
   * 
   * @see com.mumfrey.liteloader.LiteMod#getName()
   */
  @Override
  public String getName()
  {
    return "Watson Macro/Keybind Support";
  }

  // --------------------------------------------------------------------------
  /**
   * Read the mod version from the metadata.
   * 
   * Also works in the Eclipse run configuration if the Ant build runs at least
   * once to update res/litemod.json from build/litemod.template.json.
   * 
   * @see com.mumfrey.liteloader.LiteMod#getVersion()
   */
  @Override
  public String getVersion()
  {
    InputStream is = null;
    try
    {
      Gson gson = new Gson();
      is = getLiteModJsonStream();
      @SuppressWarnings("unchecked")
      Map<String, String> meta = gson.fromJson(new InputStreamReader(is),
        HashMap.class);
      String version = meta.get("version");
      if (version == null)
      {
        version = "(missing version info)";
      }
      return version;
    }
    catch (Exception ex)
    {
      return "(error loading version)";
    }
    finally
    {
      if (is != null)
      {
        try
        {
          is.close();
        }
        catch (Exception ex)
        {
        }
      }
    }
  } // getVersion

  // --------------------------------------------------------------------------
  /**
   * init() is called very early in the initialisation cycle, before the game is
   * fully initialised, this means that it is important that your mod does not
   * interact with the game in any way at this point.
   * 
   * @see com.mumfrey.liteloader.LiteMod#init(java.io.File)
   */
  @Override
  public void init(File configPath)
  {
    try
    {
      new ScriptActionWatson().onInit();
      new VariableProviderWatson().onInit();
      new MacroEventProviderWatson().onInit();
      Log.info(getName() + " initialised");
    }
    catch (Exception ex)
    {
      Log.exception(Level.SEVERE, "failed to initialise " + getName(), ex);
    }
  }

  // --------------------------------------------------------------------------
  /**
   * upgradeSettings is used to notify a mod that its version-specific settings
   * are being migrated
   * 
   * @see com.mumfrey.liteloader.LiteMod#upgradeSettings(java.lang.String,
   *      java.io.File, java.io.File)
   */
  @Override
  public void upgradeSettings(String version, File configPath, File oldConfigPath)
  {
  }

  // --------------------------------------------------------------------------
  /**
   * Return an InputStream that reads "/litemod.json".
   * 
   * When running under the IDE, that's easy because the file is copied to the
   * res/ directory and getResourceAsStream() can access it directly. When
   * running as an installed mod file, getResourceAsStream() may return a
   * reference to the litemod.json file for another mod, depending on the order
   * of the mods in the classloader. In that circumstance, we use a specially
   * crafted URL that references litemod.json via the URL of the .litemod (JAR)
   * file.
   * 
   * @return the InputStream, or null on failure.
   */
  private InputStream getLiteModJsonStream()
  {
    String classURL = getClass().getResource("/" + getClass().getName().replace('.', '/') + ".class").toString();
    if (classURL.contains("!"))
    {
      String jarURL = classURL.substring(0, classURL.indexOf('!'));
      try
      {
        URL resourceURL = new URL(jarURL + "!/litemod.json");
        return resourceURL.openStream();
      }
      catch (IOException ex)
      {
      }
      return null;
    }
    else
    {
      // No JAR. Running under the IDE.
      return getClass().getResourceAsStream("/litemod.json");
    }
  } // getLiteModJsonStream
} // class LiteModWatsonMacros
