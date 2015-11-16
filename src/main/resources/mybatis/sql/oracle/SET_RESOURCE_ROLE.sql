prompt PL/SQL Developer import file
prompt Created on 2015年11月16日 by Administrator
set feedback off
set define off
prompt Creating SET_RESOURCE_ROLE...
create table SET_RESOURCE_ROLE
(
  RESOURCE_ROLE_ID   NUMBER not null,
  RESOURCE_ROLE_CODE VARCHAR2(64),
  RESOURCE_ROLE_NAME VARCHAR2(128) not null,
  RESOURCE_ROLE_TYPE VARCHAR2(12),
  RESOURCE_ROLE_DESC VARCHAR2(512),
  STATUS             CHAR(1) not null,
  LAST_UPDATOR       VARCHAR2(32),
  LAST_UPDATE_TIME   TIMESTAMP(6)
);

comment on table SET_RESOURCE_ROLE is '资源角色表(用于资源授权)';

comment on column SET_RESOURCE_ROLE.STATUS is '0-禁用，1-启用';

alter table SET_RESOURCE_ROLE add constraint PK_SET_RESOURCE_ROLE primary key (RESOURCE_ROLE_ID);

prompt Loading SET_RESOURCE_ROLE...

insert into SET_RESOURCE_ROLE (RESOURCE_ROLE_ID, RESOURCE_ROLE_CODE, RESOURCE_ROLE_NAME, RESOURCE_ROLE_TYPE, RESOURCE_ROLE_DESC, STATUS, LAST_UPDATOR, LAST_UPDATE_TIME)
values (10046, null, '后台管理资源', null, null, '1', null, null);

commit;
prompt 1 records loaded
set feedback on
set define on
prompt Done.
