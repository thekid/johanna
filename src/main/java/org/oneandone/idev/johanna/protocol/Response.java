/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.oneandone.idev.johanna.protocol;

/**
 *
 * @author kiesel
 */
public class Response {
    public static final Response OK= new Response(true, "OK");
    public static final Response BADSESS= new Response(false, "BADSESS");
    public static final Response NOKEY= new Response(false, "NOKEY");
    
    private boolean success;
    private String data;

    public Response(boolean success, String data) {
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