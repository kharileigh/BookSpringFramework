/**
 *
 * @author kharileigh
 * <------ 1st STEP : CREATE POJO - encapsulated entity - getters & setters / lombok API -------->
 */

package com.teamsix.book.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

public class Book {
    
    private int bookId;
    private String bookName;
    private String authorName;
    private int noOfCopies;
    
}
