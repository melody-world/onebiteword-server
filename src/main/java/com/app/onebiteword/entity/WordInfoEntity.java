package com.app.onebiteword.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@Entity
@Table(name="WORD_INFO")
@NoArgsConstructor
@AllArgsConstructor
public class WordInfoEntity {

    @Id
    private long seq;
    private String wordName;
    private String wordMean;

}
