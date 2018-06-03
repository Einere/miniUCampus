package Beans;

import java.sql.Date;
import java.util.List;

public class BoardBean {
    private int index;
    private int category_number;
    private String title;
    private String writer;
    private Date date;
    private int view;
    private String content;
    private int fileCount;
    private String file;

    public void setCategory_number(int category_number) {
        this.category_number = category_number;
    }

    public void setFileCount(int fileCount) {
        this.fileCount = fileCount;
    }

    public int getCategory_number() {
        return category_number;
    }

    public int getFileCount() {
        return fileCount;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getFilecount() {
        return fileCount;
    }

    public void setFilecount(int fileCount) {
        this.fileCount = fileCount;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }


}
