package helloJpa.chap9;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
public class C9_Period {
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public C9_Period(LocalDateTime startDate, LocalDateTime endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public C9_Period() {

    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
}
