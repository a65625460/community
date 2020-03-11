package life.majiang.community.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PaginationDTO {
    private List<QuestionDTO> questions;
    // 上一页按钮
    private boolean showPrevious;
    // 首页按钮
    private boolean showFirstPage;
    // 下一页按钮
    private boolean showNext;
    // 末页按钮
    private boolean showEndPage;
    private Integer page;
    private List<Integer> pages = new ArrayList<>();
    private Integer totalPage;

    public void setPagination(Integer totalCount, Integer page, Integer size) {
        if (totalCount % size == 0 && totalCount != 0) {
            totalPage = totalCount / size;
        } else {
            totalPage = totalCount / size + 1;
        }

        if (page < 1) {
            page = 1;
        }
        if (page > totalPage) {
            page = totalPage;
        }
        this.page = page;

        for (int i = page - 3; i <= page + 3; i++) {
            if(i > 0 && i <= totalPage){
                pages.add(i);
            }
        }
        
        // 是否展示上一页按钮
        if (page == 1) {
            showPrevious = false;
        } else {
            showPrevious = true;
        }

        // 是否展示下一页按钮
        if (page == totalPage) {
            showNext = false;
        } else {
            showNext = true;
        }

        // 是否展示首页按钮
        if (pages.contains(1)) {
            showFirstPage = false;
        } else {
            showFirstPage = true;
        }

        // 是否展示末页按钮
        if (pages.contains(totalPage)) {
            showEndPage = false;
        } else {
            showEndPage = true;
        }
    }
}
