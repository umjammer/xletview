/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/

package xjavax.tv.service.selection;

/**
 * <code>AlternativeContentEvent</code> is generated to indicate that
 * "alternative" content is being presented during the presentation of
 * a service. Alternative content is content not actually part of the
 * requested service, such as content related to conditional access
 * failures (e.g., purchase dialogs or advertising for content for
 * which the user is not yet authorized). The presentation of
 * alternative content is always initiated by the system and never by
 * applications.<p>
 *
 * This event will be generated in two situations:
 *
 * <ul> <li> At the end of a successful service selection operation,
 * this event will be generated if any of the service components being
 * presented are alternative content. Under these conditions, the
 * generation of this event signals a change in state of the service
 * context from the <em>presentation pending</em> state to the
 * <em>presenting</em> state.  A <code>NormalContentEvent</code> will
 * not be generated.  </li>
 *
 * <li>
 * During the presentation of a service, this event will be generated
 * if any of the service components being presented are replaced by
 * alternative content.  One example of this is the expiration of a free
 * preview period. In this case, generation of this event does not
 * impact the service context state model.
 * </li>
 * </ul>
 *
 * Presentation failures enforced via a conditional access system may
 * be reported by this event or by a <code>SelectionFailedEvent</code>
 * with the <code>CA_REFUSAL</code> reason code. Which of these is
 * used depends on the precise nature of the conditional access
 * system. Applications must allow for both modes of failure.
 * <A HREF="../../../../javax/tv/service/selection/SelectionFailedEvent.html"><CODE>SelectionFailedEvent</CODE></A>, <A HREF="../../../../serialized-form.html#javax.tv.service.selection.AlternativeContentEvent">Serialized Form</A></DL>
 * <HR>
 *
 * @author Martin Sveden
 * @statuscode 4
 */
public class AlternativeContentEvent extends PresentationChangedEvent{
    /**
     * Constructs the event.
     *
     * @param source - The ServiceContext that generated the event.
     */
    public AlternativeContentEvent( ServiceContext source){
        super(source);
    }

}
