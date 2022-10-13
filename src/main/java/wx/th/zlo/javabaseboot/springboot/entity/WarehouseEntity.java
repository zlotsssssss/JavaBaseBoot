package wx.th.zlo.javabaseboot.springboot.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

/**
 * ClassName: WarehouseEntity
 * Description: TODO
 * Author: zlo
 * Date: 2022/10/13 10:05
 * Version: 1.0.0
 */
@Data
@TableName("mom_warehouse")
public class WarehouseEntity  {

    @TableId("ID")
    @JsonProperty("id")
    private String id;

    @TableField("PARENTID")
    @JsonProperty("parentid")
    private String parentId;

    @TableField("FULLNAME")
    @JsonProperty("fullname")
    private String fullName;

    @TableField("ENCODE")
    @JsonProperty("encode")
    private String enCode;

    @TableField("WAREHOUSEATTRIBUTE")
    @JsonProperty("warehouseattribute")
    private Integer warehouseattribute;

    @TableField("TELEPHONE")
    @JsonProperty("telephone")
    private String telephone;

    @TableField("WAREHOUSETYPEID")
    @JsonProperty("warehousetypeid")
    private String warehousetypeid;

    @TableField("WAREHOUSEMANAGERID")
    @JsonProperty("warehousemanagerid")
    private String warehousemanagerid;

    @TableField("CREATORUSERID")
    @JsonProperty("creatoruserid")
    private String creatoruserid;

    @TableField("CREATORUSERNAME")
    @JsonProperty("creatorusername")
    private String creatorusername;

    @TableField("CREATORTIME")
    @JsonProperty("creatortime")
    private Date creatortime;

    @TableField("LASTMODIFYUSERID")
    @JsonProperty("lastmodifyuserid")
    private String lastmodifyuserid;

    @TableField("LASTMODIFYUSERNAME")
    @JsonProperty("lastmodifyusername")
    private String lastmodifyusername;

    @TableField("LASTMODIFYTIME")
    @JsonProperty("lastmodifytime")
    private Date lastmodifytime;

    @TableField("DATASTATUS")
    @JsonProperty("datastatus")
    private Integer datastatus;

    @TableField("SUBUSERID")
    @JsonProperty("subuserid")
    private String subuserid;

    @TableField("SUBUSERNAME")
    @JsonProperty("subusername")
    private String subusername;

    @TableField("SUBTIME")
    @JsonProperty("subtime")
    private Date subtime;

    @TableField("AUDITUSERID")
    @JsonProperty("audituserid")
    private String audituserid;

    @TableField("AUDITUSERNAME")
    @JsonProperty("auditusername")
    private String auditusername;

    @TableField("AUDITTIME")
    @JsonProperty("audittime")
    private Date audittime;

    @TableField("ISDEL")
    @JsonProperty("isdel")
    private Integer isdel;

    @TableField("DELUSERID")
    @JsonProperty("deluserid")
    private String deluserid;

    @TableField("DELUSERNAME")
    @JsonProperty("delusername")
    private String delusername;

    @TableField("DELTIME")
    @JsonProperty("deltime")
    private Date deltime;

    @TableField("ISDIS")
    @JsonProperty("isdis")
    private Integer isdis;

    @TableField("DISUSERID")
    @JsonProperty("disuserid")
    private String disuserid;

    @TableField("DISUSERNAME")
    @JsonProperty("disusername")
    private String disusername;

    @TableField("DISTIME")
    @JsonProperty("distime")
    private Date distime;


    @TableField("DESCRIPTION")
    @JsonProperty("description")
    private String description;

    @TableField(exist = false)
    @JsonProperty("parentname")
    private String parentname;

    @TableField(exist = false)
    @JsonProperty("parentencode")
    private String parentencode;







}
