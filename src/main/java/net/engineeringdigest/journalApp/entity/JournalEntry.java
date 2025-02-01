package net.engineeringdigest.journalApp.entity;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@Document(collection = "journal_entries")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JournalEntry {

    @Id
    private ObjectId id;
    @NonNull
    private String title;
    private String content;
    private LocalDateTime date;

//    // Getter for id
//    public ObjectId getId() {
//        return id;
//    }
//
//    // Setter for id
//    public void setId(ObjectId id) {
//        this.id = id;
//    }
//
//    // Getter for title
//    public String getTitle() {
//        return title;
//    }
//
//    // Setter for title
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    // Getter for content
//    public String getContent() {
//        return content;
//    }
//
//    // Setter for content
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    // Getter for date
//    public LocalDateTime getDate() {
//        return date;
//    }
//
//    // Setter for date
//    public void setDate(LocalDateTime date) {
//        this.date = date;
//    }
}
