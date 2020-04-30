/***************************************
* Filename: View.java
* Short description: This class ...
* @author Nannette D'Imperio
* @version  ??/??/2019
***************************************/

package view;

import java.util.ArrayList;

/**
 *
 * @author nxd13
 */
public class View {
    // GUI attributes
    InitialFrame iFrame;
    InitialPanel iPanel;
    CenterPanel cPanel;

    public View() {
        iFrame = new InitialFrame();
        iPanel = iFrame.getiPanel();
        cPanel = iFrame.getcPanel();
    }
    
    // Methods needed for L04C
    public void CenterInitialSetup(int lines, int headers) {
        cPanel.setupCenterPanel(lines, headers);
    }

    public void CenterUpdate(ArrayList<ArrayList<String>> lines,
            ArrayList<String> headers) {
        cPanel.panelUpdate(lines, headers);
    }


    
    
    // Methods to display data
    public void displayGenEdInfo() {
    }
    
    public void displayCourseInfo(String text, String data) {
        System.out.println(text + data);
        
    }

}
