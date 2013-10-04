/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.oneandone.idev.johanna.protocol.impl;

import java.util.logging.Logger;
import org.oneandone.idev.johanna.protocol.Request;
import org.oneandone.idev.johanna.protocol.Response;
import org.oneandone.idev.johanna.store.Session;
import org.oneandone.idev.johanna.store.SessionStore;

/**
 *
 * @author kiesel
 */
public class VarWriteRequest extends SessionKeyBasedRequest {
    private static final Logger LOG = Logger.getLogger(VarWriteRequest.class.getName());

    public VarWriteRequest(String command) {
        super(command);
    }
    
    protected Response executeOnSessionKey(SessionStore store, Session s, String name) {
        String value= this.paramAt(4);
        
        s.putValue(name, value);
        return Response.OK;
    }
    
}