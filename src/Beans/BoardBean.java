package Beans;

import java.sql.Date;
import java.util.List;

public class BoardBean {
    private int index;
    private String title;
    private String writer;
    private Date date;
    private int view;
    private String content;
    private String ip;
    private int fileCount;
    private List<String> files; //다중 파일 업로드
    private String file;


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

    public void setIp(String ip) { this.ip = ip; }

    public String getIp(){ return ip; }

    public int getFilecount() {
        return fileCount;
    }

    public void setFilecount(int fileCount) {
        this.fileCount = fileCount;
    }

    public List<String> getFiles() {
        return files;
    }

    public void setFiles(List<String> files) {
        this.files = files;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }


}
