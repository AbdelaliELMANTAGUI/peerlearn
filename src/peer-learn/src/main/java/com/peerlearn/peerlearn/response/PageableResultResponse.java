package com.peerlearn.peerlearn.response;

import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Data
public class PageableResultResponse <T> {
    private List<T> result;
    private Long totalElements;
    private int totalPages;
    private boolean last;
    private int page;
    public PageableResultResponse(List<T> result) {
        this.result = result;
    }

    public static <T> PageableResultResponse<T> of(Page<T> page){
        PageableResultResponse<T> response = new PageableResultResponse<>(page.getContent());
        response.setTotalElements(page.getTotalElements());
        response.setTotalPages(page.getTotalPages());
        response.setPage(page.getNumber());
        response.setLast(page.isLast());
        return response;
    }
}
