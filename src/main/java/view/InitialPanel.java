/***************************************
* Filename: InitialPanel.java
* Short description: This class ...
* @author Nannette D'Imperio
* @version  ??/??/2019
***************************************/

package view;

import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 *
 * @author nxd13
 */
public class InitialPanel extends JPanel {
    // attributes
    CenterPanel cPanel;
    
    public InitialPanel() {
        super();
        setLayout(new BorderLayout());
        cPanel = new CenterPanel();
        add(cPanel, "Center");
    }
    
    public CenterPanel getCPanel() {
        return cPanel;
    }
}
