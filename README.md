Watson Macro/Keybind Support
============================
This is a Minecraft mod that allows [Watson](https://github.com/totemo/watson) to be controlled using the [Macro/Keybind Mod](http://www.minecraftforum.net/topic/467504-172-macro-keybind-mod-01002-beta-release/).


Downloads and Installation Instructions
---------------------------------------

For Minecraft 1.7.2 and later, see the [releases page for this project](https://github.com/totemo/watson_macros/releases) for downloads and installation instructions.

If you're running Minecraft 1.6.4 or earlier, Watson has the Macro/Keybind Mod support built-in.  You just need to download and install the appropriate version of [LiteLoader](http://www.minecraftforum.net/topic/1868280-172api-liteloader-for-minecraft-172/) and [Macro/Keybind Mod](http://www.minecraftforum.net/topic/467504-172-macro-keybind-mod-01002-beta-release/) and you're done.


Features
--------

### Script Actions

Watson defines a WATSON(command) script action, which performs any command supported by the Watson command line interface.  To invoke a script action using the Macro/Keybind Mod, the code needs to be wrapped up in $${ }$$ delimiters.  For example, the Macro/Keybind Mod code to toggle the Watson display is:

    $${ WATSON(/w display); }$$


### Script Variables

Watson defines the following global, read-only variables for interrogating its current state:

<table>
  <tr>
    <th>Variable</th> <th>Description</th>
  </tr>
  <tr>
    <td>WATSON_DISPLAY</td> <td>True if the Watson display is currently enabled.  False if not.</td>
  </tr>
  <tr>
    <td>WATSON_OUTLINE</td> <td>True if the Watson outline display is currently enabled.  False if not.</td>
  </tr>
  <tr>
    <td>WATSON_VECTOR</td> <td>True if the Watson vector display is currently enabled.  False if not.</td>
  </tr>
  <tr>
    <td>WATSON_LABEL</td> <td>True if the Watson ore label display is currently enabled.  False if not.</td>
  </tr>
  <tr>
    <td>WATSON_ANNOTATION</td> <td>True if the Watson annotation display is currently enabled.  False if not.</td>
  </tr>
  <tr>
    <td>WATSON_PLAYER</td> <td>The name of the player who performed the most recently selected edit.</td>
  </tr>
  <tr>
    <td>WATSON_ACTION</td> <td>The action performed on the block (either "created" or "destroyed").</td>
  </tr>
  <tr>
    <td>WATSON_BLOCK</td> <td>The name of the type of block that was edited.</td>
  </tr>
  <tr>
    <td>WATSON_ID</td> <td>The numeric ID of the block type.</td>
  </tr>
  <tr>
    <td>WATSON_DATA</td> <td>The numeric data value of the block type, most often 0.</td>
  </tr>
  <tr>
    <td>WATSON_X</td> <td>The X coordinate of the edit.</td>
  </tr>
  <tr>
    <td>WATSON_Y</td> <td>The Y coordinate of the edit.</td>
  </tr>
  <tr>
    <td>WATSON_Z</td> <td>The Z coordinate of the edit.</td>
  </tr>
  <tr>
    <td>WATSON_XYZ</td> <td>The 3-D coordinates of the edit, of the form "X, Y, Z".</td>
  </tr>
  <tr>
    <td>WATSON_DATE</td> <td>The date of the edit, of the form YYYY-MM-DD.</td>
  </tr>
  <tr>
    <td>WATSON_TIME</td> <td>The time of the edit, of the form hh:mm:ss (24 hour clock).</td>
  </tr>
  <tr>
    <td>WATSON_DATETIME</td> <td>The concatenation of WATSON_DATE and WATSON_TIME, separated by a single space.</td>
  </tr>
</table>


### Events

Watson provides two custom events to the Macro/Keybind Mod.  

<table>
  <tr>
    <th>Event</th> <th>Description</th>
  </tr>
  <tr>
    <td>onWatsonDisplay</td> <td>Sent whenever the Watson display is hidden or shown, either by command (/w display) or when Watson enables the display automatically (when entering ModMode).  Use the value of the WATSON_DISPLAY variable to ascertain whether the display is currently visible in scripts bound to these events.</td>
  </tr>
  <tr>
    <td>onWatsonSelection</td> <td>Sent whenever the currently selected position (WATSON_X, WATSON_Y, WATSON_Z) or edit (position plus WATSON_PLAYER, WATSON_ACTION, WATSON_BLOCK, WATSON_DATETIME, etc.) is changed or cleared.  This may occur either as a result of inspecting a block or performing a query, or as a result of the "/w clear" command.</td> 
  </tr>
</table>

![Custom Macro/Keybind Mod buttons.](https://raw.github.com/totemo/watson_macros/master/wiki/images/events.png)


### Sample Configurations

Sample Macro/Keybind Mod configuration files are provided for the latest version [here](https://github.com/totemo/watson_macros/tree/master/config/macros/latest) and for versions prior to 1.7 [here](https://github.com/totemo/watson_macros/tree/master/config/macros/1.6.4).

To install the sample configuration, download the two files, .gui.xml and .macros.txt, and place them in your Macro/Keybind Mod configuration folder, .minecraft/mods/macros/.  These will replace your current Macro/Keybind Mod configuration.  If you already have custom keybinds or on-screen elements that you want to preserve, you will need to merge these files into your existing configuration with a text editor.  If merging, take particular care to include the changes to the events.layout setting, since without it, the controls to edit the custom Watson events will not be displayed.

The provided configuration includes an on-screen display with custom buttons.  To display it, press the Macro key, which by default is the backwards quote character (` - the key above Tab).  This is what the display looks like:

![Custom Macro/Keybind Mod buttons.](https://raw.github.com/totemo/watson_macros/master/wiki/images/buttons.png)

The function of most of these buttons should be self-explanatory.  Directly underneath the Moody and Bright buttons, which switch between the two extremes of brightness setting, there are some labels that display information about the most recently selected edit.  It would be possible to use the Macro/Keybind Mod to show this information all the time (as opposed to only showing it when the Macro key is pressed) but due to current limitations of the Macro/Keybind Mod, there would be no way to hide that display.  The "Mod Mode" button issues the /modmode command to toggle between Moderator and normal player roles.  If you are using a different server plugin for this function, it is of course easy to rebind or remove this button.

The sample configuration also binds the following key combinations:

<table>
  <tr>
    <th>Event</th> <th>Action</th>
  </tr>
  <tr>
    <td>Ctrl-o</td> <td>Toggle the Watson overlay on or off.</td>
  </tr>
  <tr>
    <td>Ctrl-n</td> <td>Run "/lb next" to request the next page of LogBlock query results.</td>
  </tr>
  <tr>
    <td>Ctrl-c</td> <td>Query all edits by the most recently selected player in a 30 block radius.  Use the LogBlock inspector tool to select the player by querying a single edit first.  The Macro/Keybind script is: $${ECHO(/lb coords player %WATSON_PLAYER% area 30);}$$</td>
  </tr>
  <tr>
    <td>Ctrl-t</td> <td>Query the total number of constructive and destructive edits by the most recently selected player in a 30 block radius.  Use the LogBlock inspector tool to select the player by querying a single edit first.  The bound Macro/Keybind script assumes a /trace-r &lt;player&gt; &lt;range&gt; command.  Roughly equivalent code that runs LogBlock directly would be: $${ECHO(/lb player %WATSON_PLAYER% area 30 time 28d sum blocks);}$$</td>
  </tr>
  <tr>
    <td>Ctrl-y</td> <td>Query the total number of constructive and destructive edits by the most recently selected player with no distance restriction.  Use the LogBlock inspector tool to select the player by querying a single edit first.  The bound Macro/Keybind script assumes a /trace &lt;player&gt; command.  Roughly equivalent code that runs LogBlock directly would be: $${ECHO(/lb player %WATSON_PLAYER% area 10000 time 28d sum blocks);}$$ </td>
  </tr>
  <tr>
    <td>Ctrl-m</td> <td>Toggle ModMode (issue the /modmode command).</td>
  </tr>
  <tr>
    <td>Ctrl-1 through Ctrl-9</td> <td>Issue the commands /check p:1 through /check p:9, for use with the ModReq plugin.</td>
  </tr>
</table>

Note that as of version 0.12.0, Watson itself supports configurable keybinds for some common Watson commands.


Contact Details
---------------

If this mod's not working for you or you want to suggest improvements, I'm happy to help.  You can contact me directly in the following ways:

* On http://reddit.com and the http://nerd.nu forums, I have the same user name.
* On gmail.com, append the word "research" to my name to get my address.

You can also raise bug reports or feature requests via GitHub, [here](https://github.com/totemo/watson_macros/issues).

