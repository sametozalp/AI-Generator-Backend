package com.ozalp.AI.Generator.Backend.entities.concretes;

import com.ozalp.AI.Generator.Backend.entities.abstracts.BaseEntity;
import com.ozalp.AI.Generator.Backend.enums.RequestStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "ai_requests")
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AiRequest extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ai_tool_id", nullable = false)
    private AiTool aiTool;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "image_size", nullable = false)
    private String imageSize;

    @Column(name = "process_time")
    private Long processTime;

    @Column(name = "result_media")
    private List<String> resultMedia;

    @Column(name = "upload_media", nullable = false)
    private List<String> uploadMedia;

    @Column(name = "variants", nullable = false)
    private int variants;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private RequestStatus status;

}
