/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.ipp.isep.dei.esoft.pot.ui;

import pt.ipp.isep.dei.esoft.pot.ui.console.MenuUI;

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
