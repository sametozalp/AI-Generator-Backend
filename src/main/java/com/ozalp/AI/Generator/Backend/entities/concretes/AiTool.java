package com.ozalp.AI.Generator.Backend.entities.concretes;

import com.ozalp.AI.Generator.Backend.entities.abstracts.BaseEntity;
import com.ozalp.AI.Generator.Backend.enums.MediaType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "ai_tools")
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AiTool extends BaseEntity {

    @Column(name = "categories", nullable = false)
    private List<String> categories;

    @Column(name = "costs", nullable = false)
    private int costs;

    @Column(name = "description", nullable = false)
    private int description;

    @Column(name = "icon", nullable = false)
    private int icon;

    @Column(name = "media_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private MediaType mediaType;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "prompt", nullable = false)
    private String prompt;

    @Column(name = "request_type", nullable = false)
    private String requestType;

    @Column(name = "visibility", nullable = false)
    private String visibility;
}
