package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Timestamp {

    @CreatedDate // 생성당시 시간 자동 저장
    private LocalDateTime createdAt;
    @LastModifiedDate // 수정당시 시간 자동 저장
    private LocalDateTime modifiedAt;

}
