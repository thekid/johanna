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
public class SessionSetTimeoutRequest extends SessionBasedRequest {
    private static final Logger LOG = Logger.getLogger(SessionSetTimeoutRequest.class.getName());

    public SessionSetTimeoutRequest(String command) {
        super(command);
    }

    @Override
    public Response processSession(SessionStore store, Session s) {
        s.setTTL(Integer.parseInt(this.paramAt(2)));
        return Response.OK;
    }
}
