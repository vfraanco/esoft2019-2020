
package pot.ui;

import pot.ui.console.MenuUI;

/**
 *
 * @author lol
 */
public class Main
{
    public static void main(String[] args)
    {
        try
        {
            MenuUI uiMenu = new MenuUI();

            uiMenu.run();
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }
    }
}
