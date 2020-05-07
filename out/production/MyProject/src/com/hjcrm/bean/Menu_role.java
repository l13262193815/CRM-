package com.hjcrm.bean;
/*菜单角色关系表*/
public class Menu_role {
    private int id;
    private int roleid;
    private int menuid;
    private int dr;//删除标志，0未删除，1已删除

    @Override
    public String toString() {
        return "Menu_role{" +
                "id=" + id +
                ", roleid=" + roleid +
                ", menuid=" + menuid +
                ", dr=" + dr +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public int getMenuid() {
        return menuid;
    }

    public void setMenuid(int menuid) {
        this.menuid = menuid;
    }

    public int getDr() {
        return dr;
    }

    public void setDr(int dr) {
        this.dr = dr;
    }

    public Menu_role(int id, int roleid, int menuid, int dr) {
        this.id = id;
        this.roleid = roleid;
        this.menuid = menuid;
        this.dr = dr;
    }

    public Menu_role() {
    }
}
