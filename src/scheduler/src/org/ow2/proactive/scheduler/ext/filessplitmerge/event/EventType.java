//============================================================================
// Name        : ProActive Files Split-Merge Framework 
// Author      : Emil Salageanu, ActiveEon team
// Version     : 0.1
// Copyright   : Copyright ActiveEon 2008-2009, Tous Droits Réservés (All Rights Reserved)
// Description : Framework for building distribution layers for native applications
//================================================================================

package org.ow2.proactive.scheduler.ext.filessplitmerge.event;

/**
 * Type of the event produced by the {@link InternalSchedulerEventListener} 
 * see {@link InternalEvent}
 * @author esalagea
 *
 */
public enum EventType {
    jobSubmitted, jobPendingToRunning, jobRunningToFinishedEvent, jobRemoveFinished, jobKilledEvent, jobChangePriorityEvent
}
