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
package org.eclipsescout.demo.bahbah.ui.rap;

import org.eclipse.scout.rt.ui.rap.AbstractStandaloneRwtEnvironment;
import org.eclipsescout.demo.bahbah.client.ClientSession;

public class StandaloneRwtEnvironment extends AbstractStandaloneRwtEnvironment {

  private static final long serialVersionUID = 1L;

  public StandaloneRwtEnvironment() {
    super(Activator.getDefault().getBundle(), ClientSession.class);
  }

  @Override
  protected String getLogoutLocation() {
    String logoutLandingUrl = super.getLogoutLocation();
    return logoutLandingUrl + "/../res/logout.html";
  }

}
