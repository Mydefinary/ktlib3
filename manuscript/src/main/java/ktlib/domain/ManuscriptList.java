package ktlib.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

//<<< EDA / CQRS
@Entity
@Table(name = "ManuscriptList_table")
@Data
public class ManuscriptList {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long manuscriptId;

    private String title;
    private String content;
    private String createdDate;
    private String lastModified;
    private String authorId;
    private String status;
}
