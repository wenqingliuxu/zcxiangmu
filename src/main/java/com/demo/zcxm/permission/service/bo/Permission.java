package com.demo.zcxm.permission.service.bo;

/**
 * @Author: 刘旭
 * Date: 2019/10/8 8:54
 * @Version 1.0
 */
public class Permission {
    private int id;
    private int pid;
    private String pname;
    private String url;
    private String icon;
    private String checked="false";
    private String open="true";
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", pid=" + pid +
                ", pname='" + pname + '\'' +
                ", url='" + url + '\'' +
                ", icon='" + icon + '\'' +
                ", checked='" + checked + '\'' +
                ", open='" + open + '\'' +
                '}';
    }
}
