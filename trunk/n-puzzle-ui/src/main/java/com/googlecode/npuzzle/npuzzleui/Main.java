/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.googlecode.npuzzle.npuzzleui;

import com.googlecode.npuzzle.logic.Command;
import java.util.Random;
import org.apache.pivot.collections.Map;
import org.apache.pivot.wtk.Application;
import org.apache.pivot.wtk.BoxPane;
import org.apache.pivot.wtk.Button;
import org.apache.pivot.wtk.ButtonPressListener;
import org.apache.pivot.wtk.DesktopApplicationContext;
import org.apache.pivot.wtk.Display;
import org.apache.pivot.wtk.ListButton;
import org.apache.pivot.wtk.ListButtonSelectionListener;
import org.apache.pivot.wtk.Orientation;
import org.apache.pivot.wtk.Window;

/**
 *
 * @author thiago
 */
public class Main implements Application {

    private StatusBar status = new StatusBar(600);
    private Board board = new Board(status, 600, 400);
    private Menu menu = new Menu(board);
    private Window window;

    @Override
    public void startup(Display dspl, Map<String, String> map) throws Exception {
        window = new Window();
        window.setTitle("N Puzzle Game");
        board.setWindow(window);
        board.refreshCommands();
        menu.addRandomize(new ButtonPressListener() {

            @Override
            public void buttonPressed(Button button) {
                menu.setItem(0);
                Random rand = new Random();
                for (int i = 0; i < 30; i++) {
                    board.getController().addCommand(Command.values()[rand.nextInt(4)]);
                }
                board.getMenu().movingStatus();
            }
        });
        menu.addStart(new ButtonPressListener() {

            @Override
            public void buttonPressed(Button button) {
                board.solve();
            }
        });
        menu.addControllers(new ListButtonSelectionListener() {

            @Override
            public void selectedIndexChanged(ListButton lb, int i) {
                board.setController(lb.getSelectedItem().toString());
            }
        });
        BoxPane boxPane = new BoxPane(Orientation.VERTICAL);
        boxPane.add(menu);
        boxPane.add(board);
        boxPane.add(status);
        window.getComponentKeyListeners().add(new KeyBoardAdapter(board));
        window.setContent(boxPane);
        window.setWidth(boxPane.getWidth());
        window.setHeight(boxPane.getHeight());
        window.open(dspl);
    }

    @Override
    public boolean shutdown(boolean bln) throws Exception {
        if (window != null) {
            window.close();
        }
        return false;
    }

    @Override
    public void suspend() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void resume() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static void main(String[] args) {
        DesktopApplicationContext.main(Main.class, args);
    }
}
