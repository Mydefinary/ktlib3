package ktlib.domain;

import java.time.LocalDate;
import java.util.*;
import ktlib.domain.*;
import ktlib.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class BookSubscribed extends AbstractEvent {

    private Long subscriptionId;
    private Long bookId;
    private Long userId;
    private Date subscribedAt;
    private Date expriedAt;
    private Date paymentAt;
    private Boolean paymentSuccess;
    private Integer readCost;

    public BookSubscribed(SubscribeSu aggregate) {
        super(aggregate);
    }

    public BookSubscribed() {
        super();
    }
}
//>>> DDD / Domain Event
