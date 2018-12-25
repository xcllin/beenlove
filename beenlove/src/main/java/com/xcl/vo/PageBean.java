
package com.xcl.vo;

import java.io.Serializable;
import java.util.List;


import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.github.miemiedev.mybatis.paginator.domain.Paginator;
import com.github.pagehelper.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author xiangchunlin
 * @description 分页
 * @date 2018年12月24日
 * @version 1.0.0
 */
@Getter
@Setter
@ApiModel(value = "分页对象")
public class PageBean<T> implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    /** 当前页 */
    @ApiModelProperty(value = "当前页 ")
    private int pageNum;

    /** 每页的数量 */
    @ApiModelProperty(value = "每页的数量")
    private int pageSize;

    /** 当前页的数量 */
    @ApiModelProperty(value = "当前页的数量 ")
    private int size;

    /** 当前页面第一个元素在数据库中的行号 */
    @ApiModelProperty(value = "当前页面第一个元素在数据库中的行号 ")
    private int startRow;

    /** 当前页面最后一个元素在数据库中的行号 */
    @ApiModelProperty(value = "当前页面最后一个元素在数据库中的行号 ")
    private int endRow;

    /** 总记录数 */
    @ApiModelProperty(value = "总记录数 ")
    private long total;

    /** 总页数 */
    @ApiModelProperty(value = "总页数 ")
    private int pages;

    /** 查询结果集 */
    @ApiModelProperty(value = "查询结果集 ")
    private List<T> data;

    /** 前一页 */
    @ApiModelProperty(value = "前一页 ")
    private int prePage;

    /** 下一页 */
    @ApiModelProperty(value = "下一页 ")
    private int nextPage;

    /** 是否为第一页 */
    @ApiModelProperty(value = "是否为第一页 ")
    private boolean isFirstPage = false;

    /** 是否为最后一页 */
    @ApiModelProperty(value = "是否为最后一页 ")
    private boolean isLastPage = false;

    /** 是否有前一页 */
    @ApiModelProperty(value = "是否有前一页 ")
    private boolean hasPreviousPage = false;

    /** 是否有下一页 */
    @ApiModelProperty(value = "是否有下一页  ")
    private boolean hasNextPage = false;

    /** 导航页码数 */
    @ApiModelProperty(value = "导航页码数 ")
    private int navigatePages;

    /** 所有导航页号 */
    @ApiModelProperty(value = "所有导航页号")
    private int[] navigatepageNums;

    /** 导航条上的第一页 */
    @ApiModelProperty(value = "导航条上的第一页 ")
    private int navigateFirstPage;

    /** 导航条上的最后一页 */
    @ApiModelProperty(value = "导航条上的最后一页 ")
    private int navigateLastPage;

    /** 查询条件（原则上只支持与逻辑的查询） */
    @ApiModelProperty(value = "查询条件 ")
    private T condition;

    /** 排序方式 */
    @ApiModelProperty(value = "排序方式 ")
    private String orderBy;

    public PageBean() {}

    /**
     * 包装Page对象
     *
     * @param list
     */
    public PageBean(List<T> list) {
        this(list, 8);
    }

    /**
     * 包装Page对象
     *
     * @param list page结果
     * @param navigatePages 页码数量
     */
    public PageBean(List<T> list, int navigatePages) {
        if (list instanceof PageList) {
            // 动态路由支持的分页形式
            PageList<T> page = (PageList<T>)list;
            Paginator paginator = page.getPaginator();
            this.pageNum = paginator.getPage();
            this.pageSize = paginator.getLimit();

            this.pages = paginator.getTotalPages();
            this.data = page;
            this.size = page.size();
            this.total = paginator.getTotalCount();
            // 由于结果是>startRow的，所以实际的需要+1
            if (this.size == 0) {
                this.startRow = 0;
                this.endRow = 0;
            } else {
                this.startRow = paginator.getStartRow() + 1;
                // 计算实际的endRow（最后一页的时候特殊）
                this.endRow = this.startRow - 1 + this.size;
            }
        } else if (list instanceof Page) {
            Page<T> page = (Page<T>)list;
            this.pageNum = page.getPageNum();
            this.pageSize = page.getPageSize();

            this.pages = page.getPages();
            this.data = page;
            this.size = page.size();
            this.total = page.getTotal();
            // 由于结果是>startRow的，所以实际的需要+1
            if (this.size == 0) {
                this.startRow = 0;
                this.endRow = 0;
            } else {
                this.startRow = page.getStartRow() + 1;
                // 计算实际的endRow（最后一页的时候特殊）
                this.endRow = this.startRow - 1 + this.size;
            }
        } else {
            this.pageNum = 1;
            this.pageSize = list.size();

            this.pages = this.pageSize > 0 ? 1 : 0;
            this.data = list;
            this.size = list.size();
            this.total = list.size();
            this.startRow = 0;
            this.endRow = list.size() > 0 ? list.size() - 1 : 0;
            this.navigatePages = navigatePages;
            // 计算导航页
            calcNavigatepageNums();
            // 计算前后页，第一页，最后一页
            calcPage();
            // 判断页面边界
            judgePageBoudary();
        }
    }

    /**
     * 计算导航页
     */
    private void calcNavigatepageNums() {
        // 当总页数小于或等于导航页码数时
        if (pages <= navigatePages) {
            navigatepageNums = new int[pages];
            for (int i = 0; i < pages; i++) {
                navigatepageNums[i] = i + 1;
            }
        } else { // 当总页数大于导航页码数时
            navigatepageNums = new int[navigatePages];
            int startNum = pageNum - navigatePages / 2;
            int endNum = pageNum + navigatePages / 2;

            if (startNum < 1) {
                startNum = 1;
                // (最前navigatePages页
                for (int i = 0; i < navigatePages; i++) {
                    navigatepageNums[i] = startNum++;
                }
            } else if (endNum > pages) {
                endNum = pages;
                // 最后navigatePages页
                for (int i = navigatePages - 1; i >= 0; i--) {
                    navigatepageNums[i] = endNum--;
                }
            } else {
                // 所有中间页
                for (int i = 0; i < navigatePages; i++) {
                    navigatepageNums[i] = startNum++;
                }
            }
        }
    }

    /**
     * 计算前后页，第一页，最后一页
     */
    private void calcPage() {
        if (navigatepageNums != null && navigatepageNums.length > 0) {
            navigateFirstPage = navigatepageNums[0];
            navigateLastPage = navigatepageNums[navigatepageNums.length - 1];
            if (pageNum > 1) {
                prePage = pageNum - 1;
            }
            if (pageNum < pages) {
                nextPage = pageNum + 1;
            }
        }
    }

    /**
     * 判定页面边界
     */
    private void judgePageBoudary() {
        isFirstPage = pageNum == 1;
        isLastPage = pageNum == pages || pages == 0;;
        hasPreviousPage = pageNum > 1;
        hasNextPage = pageNum < pages;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PageInfo{");
        sb.append("pageNum=").append(pageNum);
        sb.append(", pageSize=").append(pageSize);
        sb.append(", size=").append(size);
        sb.append(", startRow=").append(startRow);
        sb.append(", endRow=").append(endRow);
        sb.append(", total=").append(total);
        sb.append(", pages=").append(pages);
        sb.append(", list=").append(data);
        sb.append(", prePage=").append(prePage);
        sb.append(", nextPage=").append(nextPage);
        sb.append(", isFirstPage=").append(isFirstPage);
        sb.append(", isLastPage=").append(isLastPage);
        sb.append(", hasPreviousPage=").append(hasPreviousPage);
        sb.append(", hasNextPage=").append(hasNextPage);
        sb.append(", navigatePages=").append(navigatePages);
        sb.append(", navigateFirstPage=").append(navigateFirstPage);
        sb.append(", navigateLastPage=").append(navigateLastPage);
        sb.append(", navigatepageNums=");
        if (navigatepageNums == null)
            sb.append("null");
        else {
            sb.append('[');
            for (int i = 0; i < navigatepageNums.length; ++i) {
                sb.append(i == 0 ? "" : ", ").append(navigatepageNums[i]);
            }
            sb.append(']');
        }
        sb.append('}');
        return sb.toString();
    }

}
