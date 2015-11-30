prompt PL/SQL Developer import file
prompt Created on 2015年11月30日 by Administrator
set feedback off
set define off
prompt Creating SET_OPT_LOG...
create table SET_OPT_LOG
(
  LOG_ID           VARCHAR2(40) not null,
  OPT_USER_NAME    VARCHAR2(1000) not null,
  LOG_TYPE         VARCHAR2(32) not null,
  OPT_NAME         VARCHAR2(32) not null,
  LOG_DESC         VARCHAR2(200) not null,
  OPT_IP           VARCHAR2(40) not null,
  OPT_DATE         DATE,
  STATUS           CHAR(1) not null,
  LAST_UPDATOR     VARCHAR2(32),
  LAST_UPDATE_TIME TIMESTAMP(6)
)
;
comment on table SET_OPT_LOG
  is '审计日志表';
comment on column SET_OPT_LOG.LOG_ID
  is '日志ID';
comment on column SET_OPT_LOG.OPT_USER_NAME
  is '操作用户名';
comment on column SET_OPT_LOG.LOG_TYPE
  is '日志类型';
comment on column SET_OPT_LOG.OPT_NAME
  is '操作名称';
comment on column SET_OPT_LOG.LOG_DESC
  is '描述';
comment on column SET_OPT_LOG.OPT_IP
  is 'ip地址';
comment on column SET_OPT_LOG.OPT_DATE
  is '操作日期';
comment on column SET_OPT_LOG.STATUS
  is '状态 ';
comment on column SET_OPT_LOG.LAST_UPDATOR
  is '最后更新人';
comment on column SET_OPT_LOG.LAST_UPDATE_TIME
  is '最后更新时间';
alter table SET_OPT_LOG
  add constraint LOG_ID primary key (LOG_ID);

prompt Loading SET_OPT_LOG...