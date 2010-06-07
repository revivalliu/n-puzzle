/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.googlecode.npuzzle.npuzzleui;

import org.apache.pivot.wtk.FlowPane;
import org.apache.pivot.wtk.Label;
import org.apache.pivot.wtk.TablePane;

/**
 *
 * @author thiago
 */
public class StatusBar extends TablePane {

    private Label label = new Label("Stoped");
    private Label commandBuffer = new Label("Command buffer: ");

    public static enum Status {

        SOLVING, MOVING, STOPED
    };
    private Status status;

    public StatusBar(int width) {
        getColumns().add(new Column(width / 2));
        getColumns().add(new Column(width / 2));
        FlowPane flowA = new FlowPane();
        FlowPane flowB = new FlowPane();
        flowA.add(label);
        flowB.add(commandBuffer);
        Row row = new Row();
        row.add(flowA);
        row.add(flowB);
        getRows().add(row);
    }

    public void setBufferSize(int size) {
        commandBuffer.setText("Command buffer: " + size);
    }

    public void setStatus(Status desc) {
        status = desc;
        String text = "Stoped";
        switch (desc) {
            case MOVING:
                text = "Moving";
                break;
            case SOLVING:
                text = "Solving...";
                break;
            case STOPED:
                text = "Stoped";
                break;
        }
        label.setText(text);
    }

    public Status getStatus() {
        return status;
    }
}
