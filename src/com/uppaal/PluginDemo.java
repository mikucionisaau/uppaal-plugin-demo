package com.uppaal;

/* public UPPAAL model interface: */
import com.uppaal.plugin.Plugin;
import com.uppaal.plugin.PluginWorkspace;
/* public UPPAAL plugin framework interface: */
import com.uppaal.plugin.Registry;
import java.awt.Component;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PluginDemo extends JPanel implements Plugin, PluginWorkspace
{
    static final String hello = new String("Hello Uppaal Plugin World!");

    private Registry registry = null;
    private PluginWorkspace[] workspaces = new PluginWorkspace[1];

    public PluginDemo(Registry registry)
    {
        System.out.println(hello);
        this.registry = registry;
        workspaces[0] = (PluginWorkspace) this;
        add(new JLabel(hello));
    }

    /* Plugin methods: */
    public PluginWorkspace[] getWorkspaces() { return workspaces; }

    /* PluginWorkspace methods: */
    public String getTitle() { return "TestPlugin"; }
    public Icon getIcon() { return null; }
    public String getTitleToolTip() { return hello; }
    public Component getComponent() { return this; }
    public int getDevelopmentIndex()
    {
        /*
           verifier is at 400,
           code generation will probably be at 500,
           some testing at 600,
           and we aim at final system testing, hence >600
        */
        return 657;
    }

    public boolean getCanZoom() { return false; }
    public boolean getCanZoomToFit() { return true; }
    public double getZoom() { return 1.0; }
    public void setZoom(double value) {}
    public void zoomToFit() {}
    public void zoomIn() {}
    public void zoomOut() {}

    /**
     * Called whenever the status of this workspace changes.
     * @param selected indicates whether the workspace is currently selected
     * in a tabbedpane.
     */
    public void setActive(boolean selected)
    {
        if (selected) {
            System.out.println("TestPlugin is active");
        } else {
            System.out.println("TestPlugin is not active");
        }
    }
}
