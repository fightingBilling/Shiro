prompt PL/SQL Developer import file
prompt Created on 2015年11月16日 by Administrator
set feedback off
set define off
prompt Creating SET_ROLE_GROUP...
create table SET_ROLE_GROUP
(
  RGROUP_ID        NUMBER not null,
  RGROUP_CODE      VARCHAR2(64),
  RGROUP_NAME      VARCHAR2(128) not null,
  LAST_UPDATOR     VARCHAR2(32),
  LAST_UPDATE_TIME TIMESTAMP(6)
);

comment on table SET_ROLE_GROUP is '角色组表';

alter table SET_ROLE_GROUP add constraint PK_SET_ROLE_GROUP primary key (RGROUP_ID);

prompt Loading SET_ROLE_GROUP...
insert into SET_ROLE_GROUP (RGROUP_ID, RGROUP_CODE, RGROUP_NAME, LAST_UPDATOR, LAST_UPDATE_TIME)
values (10048, null, '后台管理角色组', null, null);
commit;
prompt 1 records loaded
set feedback on
set define on
prompt Done.
