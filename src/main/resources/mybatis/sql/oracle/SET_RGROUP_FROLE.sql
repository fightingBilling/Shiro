prompt PL/SQL Developer import file
prompt Created on 2015年11月16日 by Administrator
set feedback off
set define off
prompt Creating SET_RGROUP_FROLE...
create table SET_RGROUP_FROLE
(
  RGROUP_ID        NUMBER not null,
  FUNC_ROLE_ID     NUMBER not null,
  LAST_UPDATOR     VARCHAR2(32),
  LAST_UPDATE_TIME TIMESTAMP(6)
);

comment on table SET_RGROUP_FROLE is '角色组功能角色关系表';
  
alter table SET_RGROUP_FROLE add constraint PK_SET_RGROUP_FROLE primary key (RGROUP_ID, FUNC_ROLE_ID);

prompt Loading SET_RGROUP_FROLE...
insert into SET_RGROUP_FROLE (RGROUP_ID, FUNC_ROLE_ID, LAST_UPDATOR, LAST_UPDATE_TIME)
values (10048, 10038, null, null);
commit;
prompt 1 records loaded
set feedback on
set define on
prompt Done.
