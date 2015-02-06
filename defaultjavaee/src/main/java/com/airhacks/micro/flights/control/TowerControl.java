package com.airhacks.micro.flights.control;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author airhacks.com
 */
public class TowerControl {

    public String getFlights() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(TowerControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "SFO";
    }
}
