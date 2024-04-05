package projectByRavi.journalProject.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(value = "JouralEntries")
@Data
@NoArgsConstructor
public class Journal {
    @Id
    private String id;
    private String context;
    private String description;
    private LocalDateTime date;


}
