package com.company.domains;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Word {
     private Long wordId;
     private String wordText;
     private String translation;
     private List<String>examples;
}
