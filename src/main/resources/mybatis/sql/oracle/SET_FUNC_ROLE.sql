prompt PL/SQL Developer import file
prompt Created on 2015年11月16日 by Administrator
set feedback off
set define off
prompt Creating SET_FUNC_ROLE...
create table SET_FUNC_ROLE
(
  FUNC_ROLE_ID     NUMBER not null,
  FUNC_ROLE_CODE   VARCHAR2(64),
  FUNC_ROLE_NAME   VARCHAR2(128) not null,
  FUNC_ROLE_TYPE   VARCHAR2(12),
  FUNC_ROLE_DESC   VARCHAR2(512),
  STATUS           CHAR(1) not null,
  LAST_UPDATOR     VARCHAR2(32),
  LAST_UPDATE_TIME TIMESTAMP(6)
);
comment on table SET_FUNC_ROLE is '功能角色表';

comment on column SET_FUNC_ROLE.STATUS is '0-禁用，1-启用';

alter table SET_FUNC_ROLE add constraint PK_SET_FUNC_ROLE primary key (FUNC_ROLE_ID);

prompt Loading SET_FUNC_ROLE...
insert into SET_FUNC_ROLE (FUNC_ROLE_ID, FUNC_ROLE_CODE, FUNC_ROLE_NAME, FUNC_ROLE_TYPE, FUNC_ROLE_DESC, STATUS, LAST_UPDATOR, LAST_UPDATE_TIME)
values (10038, null, '后台管理功能', null, null, '1', null, null);
commit;
prompt 1 records loaded
set feedback on
set define on
prompt Done.
