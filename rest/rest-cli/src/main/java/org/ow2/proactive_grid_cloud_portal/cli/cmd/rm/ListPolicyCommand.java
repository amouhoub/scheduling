/*
 * ProActive Parallel Suite(TM):
 * The Open Source library for parallel and distributed
 * Workflows & Scheduling, Orchestration, Cloud Automation
 * and Big Data Analysis on Enterprise Grids & Clouds.
 *
 * Copyright (c) 2007 - 2017 ActiveEon
 * Contact: contact@activeeon.com
 *
 * This library is free software: you can redistribute it and/or
 * modify it under the terms of the GNU Affero General Public License
 * as published by the Free Software Foundation: version 3 of
 * the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 *
 * If needed, contact us to obtain a release under GPL Version 2 or 3
 * or a different license than the AGPL.
 */
package org.ow2.proactive_grid_cloud_portal.cli.cmd.rm;

import static org.ow2.proactive_grid_cloud_portal.cli.HttpResponseStatus.OK;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.ow2.proactive_grid_cloud_portal.cli.ApplicationContext;
import org.ow2.proactive_grid_cloud_portal.cli.CLIException;
import org.ow2.proactive_grid_cloud_portal.cli.cmd.AbstractCommand;
import org.ow2.proactive_grid_cloud_portal.cli.cmd.Command;
import org.ow2.proactive_grid_cloud_portal.cli.json.PluginView;
import org.ow2.proactive_grid_cloud_portal.cli.utils.HttpResponseWrapper;

import com.fasterxml.jackson.core.type.TypeReference;


public class ListPolicyCommand extends AbstractCommand implements Command {

    @Override
    public void execute(ApplicationContext currentContext) throws CLIException {
        Map<String, PluginView> knownPolicyMap = currentContext.getPolicies();
        if (knownPolicyMap == null) {
            HttpGet request = new HttpGet(currentContext.getResourceUrl("policies"));
            HttpResponseWrapper response = execute(request, currentContext);
            if (statusCode(OK) == statusCode(response)) {
                List<PluginView> pluginViewList = readValue(response, new TypeReference<List<PluginView>>() {
                }, currentContext);
                resultStack(currentContext).push(pluginViewList.toArray(new PluginView[pluginViewList.size()]));
                knownPolicyMap = new HashMap<>();
                for (PluginView pluginView : pluginViewList) {
                    knownPolicyMap.put(pluginView.getPluginName(), pluginView);
                }
                currentContext.setPolicies(knownPolicyMap);
            } else {
                handleError("An error occurred while retrieving supported policy types:", response, currentContext);
            }
        }
        if (!currentContext.isSilent()) {
            if (knownPolicyMap != null) {
                writeLine(currentContext, "%n%s:%n", "Supported policy types");
                for (PluginView policy : knownPolicyMap.values()) {
                    writeLine(currentContext, "%s%n", policy.toString());
                }
            }
        }

    }
}
