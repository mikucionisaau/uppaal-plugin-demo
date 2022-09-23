package com.uppaal;

import com.uppaal.plugin.PluginWorkspace;

import java.awt.Component;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * The class describes the tab to be loaded into UPPAAL GUI.
 */
public class WorkspaceDemo implements PluginWorkspace
{
    static final String hello = "Hello Uppaal Plugin World!";
    private JPanel panel = new JPanel();

    public WorkspaceDemo() { panel.add(new JLabel(hello)); }

    /** The title for the tab title. */
    public String getTitle() { return "Plugin Demo"; }

    /** Icon image for the tab title. */
    public Icon getIcon() { return null; }

    /** Tooltip when mouse hovers above the tab title. */
    public String getTitleToolTip() { return hello; }

    /** The component to be placed into the tab. */
    public Component getComponent() { return panel; }
    /**
     * The development index controls the placement of tab among other tabs.
     * Editor is at 100,
     * Symbolic simulator is at 200,
     * Concrete simulator is at 300,
     * Verifier is at 400,
     * Test generator is at 500.
     */
    public int getDevelopmentIndex() { return 657; }

    /** Enables/disables the zoom tools accordingly. */
    public boolean getCanZoom() { return true; }
    public boolean getCanZoomToFit() { return true; }
    public double getZoom() { return 1.0; }

    /** Called when user asked to zoom to specific scale. */
    public void setZoom(double value) {
        System.out.println("zoom to "+value);
    }

    /** Called when user asked to zoom to fit into the area dedicated for this tab component. */
    public void zoomToFit() {
        System.out.println("zoom to fit");
    }

    /** Called when user asked to increase the scale. */
    public void zoomIn() {
        System.out.println("zoom-in");
    }

    /** Called when user asked to decrease the scale. */
    public void zoomOut() {
        System.out.println("zoom-out");
    }

    /**
     * Called whenever the status of this workspace changes.
     * @param selected indicates whether the workspace is openned.
     */
    public void setActive(boolean selected)
    {
        if (selected) {
            System.out.println(getTitle()+" is active");
        } else {
            System.out.println(getTitle()+" is inactive");
        }
    }
}
