package com.uppaal;

import com.uppaal.WorkspaceDemo;

/* public UPPAAL plugin interface: */
import com.uppaal.plugin.Plugin;
import com.uppaal.plugin.PluginWorkspace;

/* public UPPAAL model framework interface: */
import com.uppaal.plugin.Registry;

public class PluginDemo implements Plugin
{
    private Registry registry = null;
    private PluginWorkspace[] workspaces = new PluginWorkspace[1];

    public PluginDemo(Registry registry)
    {
        System.out.println("PluginDemo created");
        workspaces[0] = new WorkspaceDemo();
        this.registry = registry;
    }

    /** Returns workspaces to be loaded into separate tabs. */
    public PluginWorkspace[] getWorkspaces() { return workspaces; }
}
