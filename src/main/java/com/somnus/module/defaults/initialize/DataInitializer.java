package com.somnus.module.defaults.initialize;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

/** 
 * @Description: 创建数据库&初始化相关数据
 * @author Somnus
 * @date 2015年12月1日 上午10:46:48 
 * @version V1.0 
 */
public class DataInitializer implements InitializingBean{
    
    private TransactionTemplate transactionTemplate;
    
    private JdbcTemplate jdbcTemplate;

    @Override
    public void afterPropertiesSet() throws Exception {
        execute();
    }
    
    public void execute() throws Exception {
        /**创建相关表*/
        if(!existTable("SAMPLE_CITY")){
            String sample_city = "CREATE TABLE SAMPLE_CITY (" +
                    "ID int(11) NOT NULL AUTO_INCREMENT," +
                    "CITY_NAME varchar(32) COLLATE utf8_general_ci DEFAULT NULL," +
                    "PARENT_CITY int(11) DEFAULT NULL," +
                    "PRIMARY KEY (ID)" +
                  ") ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;";
            jdbcTemplate.update(sample_city);
        }
        if(!existTable("SET_FROLE_FMENU")){
            String set_frole_fmenu = "CREATE TABLE SET_FROLE_FMENU (" +
                    "FUNC_ROLE_ID int(11) NOT NULL DEFAULT '0'," +
                    "FUNC_MENU_ID int(11) NOT NULL DEFAULT '0'," +
                    "LAST_UPDATOR varchar(32) COLLATE utf8_general_ci DEFAULT NULL," +
                    "LAST_UPDATE_TIME datetime DEFAULT NULL," +
                    "PRIMARY KEY (FUNC_ROLE_ID,FUNC_MENU_ID)" +
                  ") ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;";
            jdbcTemplate.update(set_frole_fmenu);
        }
        if(!existTable("SET_FUNC_MENU")){
            String set_func_menu = "CREATE TABLE SET_FUNC_MENU (" +
                    "MENU_ID int(11) NOT NULL DEFAULT '0'," +
                    "PMENU_ID int(11) DEFAULT NULL," +
                    "MENU_CODE varchar(64) COLLATE utf8_general_ci DEFAULT NULL," +
                    "MENU_NAME varchar(128) COLLATE utf8_general_ci DEFAULT NULL," +
                    "MENU_NAME_BRIEF varchar(32) COLLATE utf8_general_ci DEFAULT NULL," +
                    "IS_LEAF char(1) COLLATE utf8_general_ci DEFAULT NULL COMMENT '0-非叶子菜单，1-叶子菜单'," +
                    "LV int(11) DEFAULT NULL," +
                    "URL varchar(128) COLLATE utf8_general_ci DEFAULT NULL," +
                    "DISPLAY_ORDER int(11) DEFAULT NULL," +
                    "STATUS char(1) COLLATE utf8_general_ci DEFAULT NULL COMMENT '0-无效，1-有效'," +
                    "LAST_UPDATOR varchar(32) COLLATE utf8_general_ci DEFAULT NULL," +
                    "LAST_UPDATE_TIME datetime DEFAULT NULL," +
                    "PRIMARY KEY (MENU_ID)," +
                    "UNIQUE KEY URL (URL)" +
                  ") ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;";
            jdbcTemplate.update(set_func_menu);
        }
        if(!existTable("SET_FUNC_ROLE")){
            String set_func_role = "CREATE TABLE SET_FUNC_ROLE (" +
                    "FUNC_ROLE_ID int(11) NOT NULL DEFAULT '0'," +
                    "FUNC_ROLE_CODE varchar(64) COLLATE utf8_general_ci DEFAULT NULL," +
                    "FUNC_ROLE_NAME varchar(128) COLLATE utf8_general_ci DEFAULT NULL," +
                    "FUNC_ROLE_TYPE varchar(12) COLLATE utf8_general_ci DEFAULT NULL," +
                    "FUNC_ROLE_DESC varchar(512) COLLATE utf8_general_ci DEFAULT NULL," +
                    "STATUS char(255) COLLATE utf8_general_ci DEFAULT NULL COMMENT '0-禁用，1-启用'," +
                    "LAST_UPDATOR varchar(32) COLLATE utf8_general_ci DEFAULT NULL," +
                    "LAST_UPDATE_TIME datetime DEFAULT NULL," +
                    "PRIMARY KEY (FUNC_ROLE_ID)" +
                  ") ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;";
            jdbcTemplate.update(set_func_role);
        }
        if(!existTable("SET_OPT_LOG")){
            String set_opt_log = "CREATE TABLE SET_OPT_LOG (" +
                    "LOG_ID int(11) NOT NULL AUTO_INCREMENT," +
                    "OPT_USER_NAME varchar(32) COLLATE utf8_general_ci DEFAULT NULL," +
                    "LOG_TYPE int(11) DEFAULT NULL," +
                    "OPT_NAME varchar(32) COLLATE utf8_general_ci DEFAULT NULL," +
                    "LOG_DESC varchar(256) COLLATE utf8_general_ci DEFAULT NULL," +
                    "OPT_IP varchar(32) COLLATE utf8_general_ci DEFAULT NULL," +
                    "OPT_ADDRESS varchar(128) COLLATE utf8_general_ci DEFAULT NULL," +
                    "STATUS char(255) COLLATE utf8_general_ci DEFAULT NULL," +
                    "LAST_UPDATOR varchar(32) COLLATE utf8_general_ci NOT NULL," +
                    "LAST_UPDATE_TIME datetime NOT NULL," +
                    "OPT_DATE datetime NOT NULL," +
                    "PRIMARY KEY (LOG_ID)" +
                  ") ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;";
            jdbcTemplate.update(set_opt_log);
        }
        if(!existTable("SET_RESOURCE_ROLE")){
            String set_resource_role = "CREATE TABLE SET_RESOURCE_ROLE (" +
                    "RESOURCE_ROLE_ID int(11) NOT NULL DEFAULT '0'," +
                    "RESOURCE_ROLE_CODE varchar(64) COLLATE utf8_general_ci DEFAULT NULL," +
                    "RESOURCE_ROLE_NAME varchar(128) COLLATE utf8_general_ci DEFAULT NULL," +
                    "RESOURCE_ROLE_TYPE varchar(12) COLLATE utf8_general_ci DEFAULT NULL," +
                    "RESOURCE_ROLE_DESC varchar(512) COLLATE utf8_general_ci DEFAULT NULL," +
                    "STATUS char(255) COLLATE utf8_general_ci DEFAULT NULL COMMENT '0-禁用，1-启用'," +
                    "LAST_UPDATOR varchar(32) COLLATE utf8_general_ci DEFAULT NULL," +
                    "LAST_UPDATE_TIME datetime DEFAULT NULL," +
                    "PRIMARY KEY (RESOURCE_ROLE_ID)" +
                  ") ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;";
            jdbcTemplate.update(set_resource_role);
        }
        if(!existTable("SET_RESOURCE")){
            String set_resource = "CREATE TABLE SET_RESOURCE (" +
                    "RESOURCE_ID int(11) NOT NULL DEFAULT '0'," +
                    "SECURITY_FILTER varchar(15) COLLATE utf8_general_ci DEFAULT NULL," +
                    "URL_PATTERN varchar(384) COLLATE utf8_general_ci DEFAULT NULL," +
                    "STATUS char(255) COLLATE utf8_general_ci DEFAULT NULL COMMENT '0-禁用，1-启用'," +
                    "LAST_UPDATOR varchar(32) COLLATE utf8_general_ci DEFAULT NULL," +
                    "LAST_UPDATE_TIME datetime DEFAULT NULL," +
                    "PRIMARY KEY (RESOURCE_ID)" +
                  ") ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;";
            jdbcTemplate.update(set_resource);
        }
        if(!existTable("SET_RGROUP_FROLE")){
            String set_rgroup_frole = "CREATE TABLE SET_RGROUP_FROLE (" +
                    "RGROUP_ID int(11) NOT NULL DEFAULT '0'," +
                    "FUNC_ROLE_ID int(11) NOT NULL DEFAULT '0'," +
                    "LAST_UPDATOR varchar(32) COLLATE utf8_general_ci DEFAULT NULL," +
                    "LAST_UPDATE_TIME datetime DEFAULT NULL," +
                    "PRIMARY KEY (RGROUP_ID,FUNC_ROLE_ID)" +
                  ") ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;";
            jdbcTemplate.update(set_rgroup_frole);
        }
        if(!existTable("SET_RGROUP_RROLE")){
            String set_rgroup_rrole = "CREATE TABLE SET_RGROUP_RROLE (" +
                    "RGROUP_ID int(11) NOT NULL DEFAULT '0'," +
                    "RESOURCE_ROLE_ID int(11) NOT NULL DEFAULT '0'," +
                    "LAST_UPDATOR varchar(32) COLLATE utf8_general_ci DEFAULT NULL," +
                    "LAST_UPDATE_TIME datetime DEFAULT NULL," +
                    "PRIMARY KEY (RGROUP_ID,RESOURCE_ROLE_ID)" +
                  ") ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;";
            jdbcTemplate.update(set_rgroup_rrole);
        }
        if(!existTable("SET_ROLE_GROUP")){
            String set_role_group = "CREATE TABLE SET_ROLE_GROUP (" +
                    "RGROUP_ID int(11) NOT NULL DEFAULT '0'," +
                    "RGROUP_CODE varchar(64) COLLATE utf8_general_ci DEFAULT NULL," +
                    "RGROUP_NAME varchar(128) COLLATE utf8_general_ci NOT NULL," +
                    "LAST_UPDATOR varchar(32) COLLATE utf8_general_ci DEFAULT NULL," +
                    "LAST_UPDATE_TIME datetime DEFAULT NULL," +
                    "PRIMARY KEY (RGROUP_ID)" +
                  ") ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;";
            jdbcTemplate.update(set_role_group);
        }
        if(!existTable("SET_RROLE_RESOURCE")){
            String set_rrole_resource = "CREATE TABLE SET_RROLE_RESOURCE (" +
                    "RESOURCE_ROLE_ID int(11) NOT NULL DEFAULT '0'," +
                    "RESOURCE_ID int(11) NOT NULL DEFAULT '0'," +
                    "LAST_UPDATOR varchar(32) COLLATE utf8_general_ci DEFAULT NULL," +
                    "LAST_UPDATE_TIME datetime DEFAULT NULL," +
                    "PRIMARY KEY (RESOURCE_ROLE_ID,RESOURCE_ID)" +
                  ") ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;";
            jdbcTemplate.update(set_rrole_resource);
        }
        if(!existTable("SET_USER_RGROUP")){
            String set_user_rgroup = "CREATE TABLE SET_USER_RGROUP (" +
                    "USER_ID int(11) NOT NULL DEFAULT '0'," +
                    "RGROUP_ID int(11) NOT NULL DEFAULT '0'," +
                    "LAST_UPDATOR varchar(32) COLLATE utf8_general_ci DEFAULT NULL," +
                    "LAST_UPDATE_TIME datetime DEFAULT NULL," +
                    "PRIMARY KEY (USER_ID,RGROUP_ID)" +
                  ") ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;";
            jdbcTemplate.update(set_user_rgroup);
        }
        if(!existTable("SET_USER")){
            String set_user = "CREATE TABLE SET_USER (" +
                    "USER_ID int(11) NOT NULL DEFAULT '0'," +
                    "USERNAME varchar(32) COLLATE utf8_general_ci DEFAULT NULL," +
                    "PASSWORD varchar(32) COLLATE utf8_general_ci DEFAULT NULL," +
                    "DESCRIPTION varchar(256) COLLATE utf8_general_ci DEFAULT NULL," +
                    "STATUS char(255) COLLATE utf8_general_ci DEFAULT NULL," +
                    "LAST_UPDATOR varchar(32) COLLATE utf8_general_ci DEFAULT NULL," +
                    "LAST_UPDATE_TIME datetime DEFAULT NULL," +
                    "PRIMARY KEY (USER_ID)," +
                    "UNIQUE KEY SET_USER_IX1 (USERNAME)" +
                  ") ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;";
            jdbcTemplate.update(set_user);
        }
        
        transactionTemplate.execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus status) {
                jdbcTemplate.execute("truncate table SAMPLE_CITY");
                jdbcTemplate.execute(String.format("INSERT INTO SAMPLE_CITY VALUES ('%s','%s',%s)", "1", "江西", "null"));
                jdbcTemplate.execute(String.format("INSERT INTO SAMPLE_CITY VALUES ('%s','%s',%s)", "2", "江苏", "null"));
                jdbcTemplate.execute(String.format("INSERT INTO SAMPLE_CITY VALUES ('%s','%s',%s)", "3", "浙江", "null"));
                jdbcTemplate.execute(String.format("INSERT INTO SAMPLE_CITY VALUES ('%s','%s','%s')", "11", "南昌", 1));
                jdbcTemplate.execute(String.format("INSERT INTO SAMPLE_CITY VALUES ('%s','%s','%s')", "12", "九江", 1));
                jdbcTemplate.execute(String.format("INSERT INTO SAMPLE_CITY VALUES ('%s','%s','%s')", "21", "南京", 2));
                jdbcTemplate.execute(String.format("INSERT INTO SAMPLE_CITY VALUES ('%s','%s','%s')", "22", "无锡", 2));
                jdbcTemplate.execute(String.format("INSERT INTO SAMPLE_CITY VALUES ('%s','%s','%s')", "31", "杭州", 3));
                jdbcTemplate.execute(String.format("INSERT INTO SAMPLE_CITY VALUES ('%s','%s','%s')", "32", "宁波", 3));
                return null;
            }
        });
        
        transactionTemplate.execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus status) {
                jdbcTemplate.execute("truncate table SET_FROLE_FMENU");
                jdbcTemplate.execute(String.format("INSERT INTO SET_FROLE_FMENU VALUES ('%s','%s',%s,%s)", "10038", "10001", "null", "null"));
                jdbcTemplate.execute(String.format("INSERT INTO SET_FROLE_FMENU VALUES ('%s','%s',%s,%s)", "10038", "10002", "null", "null"));
                jdbcTemplate.execute(String.format("INSERT INTO SET_FROLE_FMENU VALUES ('%s','%s',%s,%s)", "10038", "10050", "null", "null"));
                jdbcTemplate.execute(String.format("INSERT INTO SET_FROLE_FMENU VALUES ('%s','%s',%s,%s)", "10038", "10051", "null", "null"));
                jdbcTemplate.execute(String.format("INSERT INTO SET_FROLE_FMENU VALUES ('%s','%s',%s,%s)", "10038", "10052", "null", "null"));
                jdbcTemplate.execute(String.format("INSERT INTO SET_FROLE_FMENU VALUES ('%s','%s',%s,%s)", "10038", "10053", "null", "null"));
                jdbcTemplate.execute(String.format("INSERT INTO SET_FROLE_FMENU VALUES ('%s','%s',%s,%s)", "10038", "10054", "null", "null"));
                jdbcTemplate.execute(String.format("INSERT INTO SET_FROLE_FMENU VALUES ('%s','%s',%s,%s)", "10038", "10055", "null", "null"));
                jdbcTemplate.execute(String.format("INSERT INTO SET_FROLE_FMENU VALUES ('%s','%s',%s,%s)", "10038", "10056", "null", "null"));
                jdbcTemplate.execute(String.format("INSERT INTO SET_FROLE_FMENU VALUES ('%s','%s',%s,%s)", "10038", "10057", "null", "null"));
                jdbcTemplate.execute(String.format("INSERT INTO SET_FROLE_FMENU VALUES ('%s','%s',%s,%s)", "10038", "20010", "null", "null"));
                jdbcTemplate.execute(String.format("INSERT INTO SET_FROLE_FMENU VALUES ('%s','%s',%s,%s)", "10038", "20011", "null", "null"));
                return null;
            }
        });
        
        transactionTemplate.execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus status) {
                jdbcTemplate.execute("truncate table SET_FUNC_MENU");
                jdbcTemplate.execute(String.format("INSERT INTO SET_FUNC_MENU VALUES ('%s','%s','%s','%s',%s,'%s','%s',%s,'%s','%s',%s,%s)", 
                        "10001", "-1", "10001", "样例管理", "null", "0", "1", "null", "500000", "1", "null", "null"));
                jdbcTemplate.execute(String.format("INSERT INTO SET_FUNC_MENU VALUES ('%s','%s','%s','%s',%s,'%s','%s','%s','%s','%s',%s,%s)", 
                        "10002", "10001", "10001-10002", "功能组件展示", "null", "1", "2", "/sample/component.html?opt=s200", "500001", "1", "null", "null"));
                jdbcTemplate.execute(String.format("INSERT INTO SET_FUNC_MENU VALUES ('%s','%s','%s','%s',%s,'%s','%s',%s,'%s','%s',%s,%s)", 
                        "10050", "-1", "10050", "后台管理", "null", "0", "1", "null", "400000", "1", "null", "null"));
                jdbcTemplate.execute(String.format("INSERT INTO SET_FUNC_MENU VALUES ('%s','%s','%s','%s',%s,'%s','%s','%s','%s','%s',%s,%s)", 
                        "10051", "10050", "10050-10051", "用户维护", "null", "1", "2", "/mt/user/user_read.html?opt=s7000", "400100", "1", "null", "null"));
                jdbcTemplate.execute(String.format("INSERT INTO SET_FUNC_MENU VALUES ('%s','%s','%s','%s',%s,'%s','%s','%s','%s','%s',%s,%s)", 
                        "10052", "10050", "10050-10052", "角色组维护", "null", "1", "2", "/mt/rgroup/rgroup_read.html?opt=s5000", "400200", "1", "null", "null"));
                jdbcTemplate.execute(String.format("INSERT INTO SET_FUNC_MENU VALUES ('%s','%s','%s','%s',%s,'%s','%s',%s,'%s','%s',%s,%s)", 
                        "10053", "10050", "10050-10053", "角色维护", "null", "0", "2", "null", "400300", "1", "null", "null"));
                jdbcTemplate.execute(String.format("INSERT INTO SET_FUNC_MENU VALUES ('%s','%s','%s','%s',%s,'%s','%s','%s','%s','%s',%s,%s)", 
                        "10054", "10050", "10050-10054", "资源维护", "null", "1", "2", "/mt/resource/resource_read.html?opt=s2000", "400400", "1", "null", "null"));
                jdbcTemplate.execute(String.format("INSERT INTO SET_FUNC_MENU VALUES ('%s','%s','%s','%s',%s,'%s','%s','%s','%s','%s',%s,%s)", 
                        "10055", "10050", "10050-10055", "菜单维护", "null", "1", "2", "/mt/menu/menu_read.html?opt=s3000", "400500", "1", "null", "null"));
                jdbcTemplate.execute(String.format("INSERT INTO SET_FUNC_MENU VALUES ('%s','%s','%s','%s',%s,'%s','%s','%s','%s','%s',%s,%s)", 
                        "10056", "10053", "10050-10053-10056", "功能角色维护", "null", "1", "3", "/mt/role/role_menu_read.html?opt=s4000", "400320", "1", "null", "null"));
                jdbcTemplate.execute(String.format("INSERT INTO SET_FUNC_MENU VALUES ('%s','%s','%s','%s',%s,'%s','%s','%s','%s','%s',%s,%s)", 
                        "10057", "10053", "10050-10053-10057", "资源角色维护", "null", "1", "3", "/mt/role/role_resource_read.html?opt=s6000", "400310", "1", "null", "null"));
                jdbcTemplate.execute(String.format("INSERT INTO SET_FUNC_MENU VALUES ('%s','%s','%s','%s',%s,'%s','%s',%s,'%s','%s',%s,%s)", 
                        "20010", "10050", "10050-20010", "日志维护", "null", "0", "2", "null", "400430", "1", "null", "null"));
                jdbcTemplate.execute(String.format("INSERT INTO SET_FUNC_MENU VALUES ('%s','%s','%s','%s',%s,'%s','%s','%s','%s','%s',%s,%s)", 
                        "20011", "20010", "10050-20010-20011", "日志查询", "null", "1", "3", "/log/setoptlog_read.html?opt=optlogQuery", "400440", "1", "null", "null"));
                return null;
            }
        });
        
        transactionTemplate.execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus status) {
                jdbcTemplate.execute("truncate table SET_FUNC_ROLE");
                jdbcTemplate.execute(String.format("INSERT INTO SET_FUNC_ROLE VALUES ('%s',%s,'%s',%s,%s,'%s',%s,%s)", 
                        "10038", "null", "后台管理功能", "null", "null", "1", "null", "null"));
                return null;
            }
        });
        
        transactionTemplate.execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus status) {
                jdbcTemplate.execute("truncate table SET_RESOURCE_ROLE");
                jdbcTemplate.execute(String.format("INSERT INTO SET_RESOURCE_ROLE VALUES ('%s',%s,'%s',%s,%s,'%s',%s,%s)", 
                        "10046", "null", "后台管理资源", "null", "null", "1", "null", "null"));
                return null;
            }
        });
        
        transactionTemplate.execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus status) {
                jdbcTemplate.execute("truncate table SET_RESOURCE");
                jdbcTemplate.execute(String.format("INSERT INTO SET_RESOURCE VALUES ('%s','%s','%s','%s',%s,%s)", 
                        "100", "cAuthc", "/sample/component.html", "1", "null", "null"));
                jdbcTemplate.execute(String.format("INSERT INTO SET_RESOURCE VALUES ('%s','%s','%s','%s',%s,%s)", 
                        "992", "cAuthc", "/mt/rgroup/rgroup_read.html", "1", "null", "null"));
                jdbcTemplate.execute(String.format("INSERT INTO SET_RESOURCE VALUES ('%s','%s','%s','%s',%s,%s)", 
                        "993", "cAuthc", "/mt/user/user_read.html", "1", "null", "null"));
                jdbcTemplate.execute(String.format("INSERT INTO SET_RESOURCE VALUES ('%s','%s','%s','%s',%s,%s)", 
                        "994", "cAuthc", "/mt/role/role_resource_read.html", "1", "null", "null"));
                jdbcTemplate.execute(String.format("INSERT INTO SET_RESOURCE VALUES ('%s','%s','%s','%s',%s,%s)", 
                        "995", "cAuthc", "/mt/role/role_menu_read.html", "1", "null", "null"));
                jdbcTemplate.execute(String.format("INSERT INTO SET_RESOURCE VALUES ('%s','%s','%s','%s',%s,%s)", 
                        "996", "cAuthc", "/mt/resource/resource_read.html", "1", "null", "null"));
                jdbcTemplate.execute(String.format("INSERT INTO SET_RESOURCE VALUES ('%s','%s','%s','%s',%s,%s)", 
                        "997", "cAuthc", "/mt/menu/menu_read.html", "1", "null", "null"));
                jdbcTemplate.execute(String.format("INSERT INTO SET_RESOURCE VALUES ('%s','%s','%s','%s',%s,%s)", 
                        "998", "cAuthc", "/log/setoptlog_read.html", "1", "null", "null"));
                jdbcTemplate.execute(String.format("INSERT INTO SET_RESOURCE VALUES ('%s','%s','%s','%s',%s,%s)", 
                        "999", "cAuthc", "/default.html", "1", "null", "null"));
                return null;
            }
        });
        
        transactionTemplate.execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus status) {
                jdbcTemplate.execute("truncate table SET_RGROUP_FROLE");
                jdbcTemplate.execute(String.format("INSERT INTO SET_RGROUP_FROLE VALUES ('%s','%s',%s,%s)", 
                        "10048", "10038", "null", "null"));
                return null;
            }
        });
        
        transactionTemplate.execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus status) {
                jdbcTemplate.execute("truncate table SET_RGROUP_RROLE");
                jdbcTemplate.execute(String.format("INSERT INTO SET_RGROUP_RROLE VALUES ('%s','%s',%s,%s)", 
                        "10048", "10046", "null", "null"));
                return null;
            }
        });
        
        transactionTemplate.execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus status) {
                jdbcTemplate.execute("truncate table SET_ROLE_GROUP");
                jdbcTemplate.execute(String.format("INSERT INTO SET_ROLE_GROUP VALUES ('%s',%s,'%s',%s,%s)", 
                        "10048", "null", "后台管理角色组", "null", "null"));
                return null;
            }
        });
        
        transactionTemplate.execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus status) {
                jdbcTemplate.execute("truncate table SET_RROLE_RESOURCE");
                jdbcTemplate.execute(String.format("INSERT INTO SET_RROLE_RESOURCE VALUES ('%s','%s',%s,%s)", 
                        "10046", "100", "null", "null"));
                jdbcTemplate.execute(String.format("INSERT INTO SET_RROLE_RESOURCE VALUES ('%s','%s',%s,%s)", 
                        "10046", "992", "null", "null"));
                jdbcTemplate.execute(String.format("INSERT INTO SET_RROLE_RESOURCE VALUES ('%s','%s',%s,%s)", 
                        "10046", "993", "null", "null"));
                jdbcTemplate.execute(String.format("INSERT INTO SET_RROLE_RESOURCE VALUES ('%s','%s',%s,%s)", 
                        "10046", "994", "null", "null"));
                jdbcTemplate.execute(String.format("INSERT INTO SET_RROLE_RESOURCE VALUES ('%s','%s',%s,%s)", 
                        "10046", "995", "null", "null"));
                jdbcTemplate.execute(String.format("INSERT INTO SET_RROLE_RESOURCE VALUES ('%s','%s',%s,%s)", 
                        "10046", "996", "null", "null"));
                jdbcTemplate.execute(String.format("INSERT INTO SET_RROLE_RESOURCE VALUES ('%s','%s',%s,%s)", 
                        "10046", "997", "null", "null"));
                jdbcTemplate.execute(String.format("INSERT INTO SET_RROLE_RESOURCE VALUES ('%s','%s',%s,%s)", 
                        "10046", "998", "null", "null"));
                jdbcTemplate.execute(String.format("INSERT INTO SET_RROLE_RESOURCE VALUES ('%s','%s',%s,%s)", 
                        "10046", "999", "null", "null"));
                return null;
            }
        });
        
        transactionTemplate.execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus status) {
                jdbcTemplate.execute("truncate table SET_USER_RGROUP");
                jdbcTemplate.execute(String.format("INSERT INTO SET_USER_RGROUP VALUES ('%s','%s',%s,%s)", 
                        "10023", "10048", "null", "null"));
                return null;
            }
        });
        
        transactionTemplate.execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus status) {
                jdbcTemplate.execute("truncate table SET_USER");
                jdbcTemplate.execute(String.format("INSERT INTO SET_USER VALUES ('%s','%s','%s',%s,'%s','%s','%s')", 
                        "10023", "admin", "68cf63c62bc68d71fc41c028375e2f6e", "null", "1", "admin", "2015-12-01 12:00:00"));
                return null;
            }
        });
    
    }
    /**  
     * 查询数据库是否有某表  
     * @param tableName  
     * @return  
     * @throws Exception  
     */    
    private boolean existTable(String tableName) throws Exception {    
        Connection conn = jdbcTemplate.getDataSource().getConnection();    
        ResultSet tabs = null;    
        try {    
            DatabaseMetaData dbMetaData = conn.getMetaData();    
            String[] types = { "TABLE" };    
            tabs = dbMetaData.getTables(null, null, tableName, types);    
            if (tabs.next()) {    
                return true;    
            }    
        } catch (Exception e) {    
            e.printStackTrace();    
        }finally{    
            tabs.close();    
            conn.close();    
        }    
        return false;    
    }

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }  

}
