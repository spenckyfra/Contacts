/*******************************************************************************
 * Copyright (c) 2015 BSI Business Systems Integration AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Distribution License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/org/documents/edl-v10.html
 *
 * Contributors:
 *     BSI Business Systems Integration AG - initial API and implementation
 ******************************************************************************/
package org.eclipsescout.demo.bahbah.server;

import java.security.AccessController;

import javax.security.auth.Subject;

import org.eclipse.scout.commons.annotations.FormData;
import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.commons.logger.IScoutLogger;
import org.eclipse.scout.commons.logger.ScoutLogManager;
import org.eclipse.scout.rt.server.AbstractServerSession;
import org.eclipse.scout.rt.server.IServerJobService;
import org.eclipse.scout.rt.server.ServerJob;
import org.eclipse.scout.rt.shared.services.common.code.CODES;
import org.eclipse.scout.rt.shared.services.common.code.ICode;
import org.eclipse.scout.service.SERVICES;
import org.eclipsescout.demo.bahbah.shared.services.code.UserRoleCodeType;
import org.eclipsescout.demo.bahbah.shared.services.process.IUserProcessService;

public class ServerSession extends AbstractServerSession {
  private static final long serialVersionUID = -6930164140912861947L;
  private static final IScoutLogger LOG = ScoutLogManager.getLogger(ServerSession.class);

  public ServerSession() {
    super(true);
  }

  /**
   * @return session in current ThreadContext
   */
  public static ServerSession get() {
    return ServerJob.getCurrentSession(ServerSession.class);
  }

  @SuppressWarnings("unchecked")
  @FormData
  public ICode<Integer> getPermission() {
    return getSharedContextVariable(IUserProcessService.PERMISSION_KEY, ICode.class);
  }

  @FormData
  public void setPermission(ICode<Integer> newValue) {
    setSharedContextVariable(IUserProcessService.PERMISSION_KEY, ICode.class, newValue);
  }

  @Override
  protected void execLoadSession() throws ProcessingException {
    if (getUserId() != null) {
      final Subject serverSubject = SERVICES.getService(IServerJobService.class).getServerSubject();
      if (Subject.getSubject(AccessController.getContext()) == serverSubject) {
        setPermission(CODES.getCode(UserRoleCodeType.UserCode.class));
      }
      else {
        LOG.info("created a new session for " + getUserId());
        setPermission(SERVICES.getService(IUserProcessService.class).getUserPermission());
        SERVICES.getService(IUserProcessService.class).registerUser();
      }
    }
  }
}
