/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.oneandone.idev.johanna.protocol;

/**
 *
 * @author kiesel
 */
public class HannahResponse {
    private boolean success;
    private String data;

    public HannahResponse(boolean success, String data) {
        this.success = success;
        this.data = data;
    }

    @Override
    public String toString() {
        StringBuffer buf= new StringBuffer(1024);
        
        if (this.success) {
            buf.append("+OK ");
        } else {
            buf.append("-");
        }
        
        buf.append(data);
        buf.append("\n");
        
        return buf.toString();
    }
}