/*
 * ################################################################
 *
 * ProActive Parallel Suite(TM): The Java(TM) library for
 *    Parallel, Distributed, Multi-Core Computing for
 *    Enterprise Grids & Clouds
 *
 * Copyright (C) 1997-2010 INRIA/University of 
 * 				Nice-Sophia Antipolis/ActiveEon
 * Contact: proactive@ow2.org or contact@activeeon.com
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; version 3 of
 * the License.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307
 * USA
 *
 * If needed, contact us to obtain a release under GPL Version 2 
 * or a different license than the GPL.
 *
 *  Initial developer(s):               The ProActive Team
 *                        http://proactive.inria.fr/team_members.htm
 *  Contributor(s):
 *
 * ################################################################
 * $$PROACTIVE_INITIAL_DEV$$
 */
package org.ow2.proactive.resourcemanager.gui.compact.view;

import org.ow2.proactive.resourcemanager.gui.compact.Filter;
import org.ow2.proactive.resourcemanager.gui.data.model.Host;
import org.ow2.proactive.resourcemanager.gui.data.model.Node;
import org.ow2.proactive.resourcemanager.gui.data.model.DeployingNode;
import org.ow2.proactive.resourcemanager.gui.data.model.Source;
import org.ow2.proactive.resourcemanager.gui.data.model.TreeLeafElement;
import org.ow2.proactive.resourcemanager.gui.data.model.VirtualMachine;


/**
 *
 * Class represents the factory for view creation.
 *
 */
public class ViewFractory {

    /**
     * Creates views based on the specified element.
     */
    public static View createView(TreeLeafElement element, Filter filter) {
        View view = null;
        if (element instanceof DeployingNode) {
            view = new DeployingNodeView(element, filter);
        } else if (element instanceof Node) {
            view = new NodeView(element, filter);
        } else if (element instanceof VirtualMachine) {
            view = new JVMView(element, filter);
        } else if (element instanceof Host) {
            view = new HostView(element, filter);
        } else if (element instanceof Source) {
            view = new SourceView(element, filter);
        } else {
            view = new View(element);
        }

        return view;
    }

}
